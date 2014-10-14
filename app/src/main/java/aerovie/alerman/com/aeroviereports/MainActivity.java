package aerovie.alerman.com.aeroviereports;

import android.app.AlarmManager;
import android.app.Fragment;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.activeandroid.query.Select;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;

import aerovie.alerman.com.aeroviedata.types.Pirep;
import aerovie.alerman.com.aeroviereports.adapters.PirepListAdapter;
import aerovie.alerman.com.aeroviereports.background.DBSyncReceiver;
import aerovie.alerman.com.aerovieweb.WebRequestExecutor;
import common.SharedPreferencesManager;

public class MainActivity extends FragmentActivity {


    private GoogleMap mMap; // Might be null if Google Play services APK is not available.
    private ListView listview;
    public static PendingIntent dbSyncIntent = null;
    public static PirepListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent i = new Intent(getApplicationContext(), DBSyncReceiver.class);

        dbSyncIntent = PendingIntent.getBroadcast(getApplicationContext(), Integer.valueOf((int) Math.floor(Math.random() * 100)), i, 0);

        // We want the alarm to go off 3 seconds from now.
        long firstTime = SystemClock.elapsedRealtime();
        firstTime += 3 * 1000;//start 3 seconds after first register.

//        Schedule the alarm!
        //TODO run in backround, for now, do once in an asynctask

        AsyncTask<Context,Void,Void> task = new AsyncTask<Context, Void, Void>() {
            @Override
            protected Void doInBackground(Context... contexts) {
                String sessionId = SharedPreferencesManager.retrieve(contexts[0], contexts[0].getString(R.string.sessionId), null);
                String deviceSyncId = SharedPreferencesManager.retrieve(contexts[0], contexts[0].getString(R.string.deviceId), null);
                try {
                    deviceSyncId = WebRequestExecutor.getInstance(contexts[0].getString(R.string.aerovie_url)).sync(sessionId, deviceSyncId);
                    if (deviceSyncId == null) {
                        SharedPreferencesManager.store(contexts[0], contexts[0].getString(R.string.sessionId), null);
                        Intent loginActivity = new Intent(contexts[0], LoginActivity.class);

                        if (MainActivity.dbSyncIntent != null) {
                            AlarmManager am = (AlarmManager) contexts[0]
                                    .getSystemService(contexts[0].ALARM_SERVICE);
                            am.cancel(MainActivity.dbSyncIntent);
                            MainActivity.dbSyncIntent = null;
                        }


                        loginActivity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        contexts[0].startActivity(loginActivity);
                    }
                    SharedPreferencesManager.store(contexts[0], contexts[0].getString(R.string.deviceId), deviceSyncId);




                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }
        };

//        AlarmManager am = (AlarmManager) getApplicationContext()
//                .getSystemService(ALARM_SERVICE);
//        am.setRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP, firstTime,
//                60*1000*1, dbSyncIntent);//1min interval

        setContentView(R.layout.activity_main);

        setUpMapIfNeeded();
        listview = (ListView) findViewById(R.id.pirepListView);
        adapter = new PirepListAdapter(this, R.layout.pireplistview, new Select().all().from(Pirep.class).orderBy("pirep_time desc").<Pirep>execute());
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Pirep pirep = (Pirep) adapterView.getItemAtPosition(i);
                double lat = Double.parseDouble(pirep.getMyLat());
                double longitude = Double.parseDouble(pirep.getMyLong());
                mMap.moveCamera( CameraUpdateFactory.newLatLng(new LatLng(lat,longitude)));
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
       // getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
     * installed) and the map has not already been instantiated.. This will ensure that we only ever
     * call {@link #setUpMap()} once when {@link #mMap} is not null.
     * <p/>
     * If it isn't installed {@link SupportMapFragment} (and
     * {@link com.google.android.gms.maps.MapView MapView}) will show a prompt for the user to
     * install/update the Google Play services APK on their device.
     * <p/>
     * A user can return to this FragmentActivity after following the prompt and correctly
     * installing/updating/enabling the Google Play services. Since the FragmentActivity may not
     * have been completely destroyed during this process (it is likely that it would only be
     * stopped or paused), {@link #onCreate(android.os.Bundle)} may not be called again so we should call this
     * method in {@link #onResume()} to guarantee that it will be called.
     */
    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }

    /**
     * This is where we can add markers or lines, add listeners or move the camera. In this case, we
     * just add a marker near Africa.
     * <p/>
     * This should only be called once and when we are sure that {@link #mMap} is not null.
     */
    private void setUpMap() {
        mMap.setMyLocationEnabled(true);
        mMap.addMarker(new MarkerOptions().position(new LatLng(0, 0)).title("Marker"));
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }
}
