package aerovie.alerman.com.aeroviereports.background;

import android.app.AlarmManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.activeandroid.query.Select;
import com.activeandroid.util.Log;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import aerovie.alerman.com.aeroviedata.types.Pirep;
import aerovie.alerman.com.aeroviereports.LoginActivity;
import aerovie.alerman.com.aeroviereports.MainActivity;
import aerovie.alerman.com.aeroviereports.R;
import aerovie.alerman.com.aeroviereports.adapters.PirepListAdapter;
import aerovie.alerman.com.aerovieweb.WebRequestExecutor;
import common.SharedPreferencesManager;

/**
 * Created by alerman on 9/27/14.
 */
public class DBSyncReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(final Context context, Intent intent) {
//        AsyncTask task  = new AsyncTask<Object, Void, Void>() {
//            @Override
//            protected Void doInBackground(Object... voids) {
//                Log.d("DBSync running");
        String sessionId = SharedPreferencesManager.retrieve(context, context.getString(R.string.sessionId), null);
        String deviceSyncId = SharedPreferencesManager.retrieve(context, context.getString(R.string.deviceId), null);
        try {
            deviceSyncId = WebRequestExecutor.getInstance(context.getString(R.string.aerovie_url)).sync(sessionId, deviceSyncId);
            if (deviceSyncId == null) {
                SharedPreferencesManager.store(context, context.getString(R.string.sessionId), null);
                Intent loginActivity = new Intent(context, LoginActivity.class);

                if (MainActivity.dbSyncIntent != null) {
                    AlarmManager am = (AlarmManager) context
                            .getSystemService(context.ALARM_SERVICE);
                    am.cancel(MainActivity.dbSyncIntent);
                    MainActivity.dbSyncIntent = null;
                }


                loginActivity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(loginActivity);
            }
            SharedPreferencesManager.store(context, context.getString(R.string.deviceId), deviceSyncId);


            if(MainActivity.adapter != null)
            {
                MainActivity.adapter.clear();
                MainActivity.adapter.addAll( new Select().all().from(Pirep.class).orderBy("pirep_time desc").<Pirep>execute());
                MainActivity.adapter.notifyDataSetChanged();
            }


        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
//                return null;
//            }
//        };
//
//        task.execute();
//
//    }
//}
