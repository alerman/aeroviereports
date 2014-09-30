package aerovie.alerman.com.aeroviereports.background;

import android.app.AlarmManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import aerovie.alerman.com.aeroviereports.LoginActivity;
import aerovie.alerman.com.aeroviereports.MainActivity;
import aerovie.alerman.com.aeroviereports.R;
import aerovie.alerman.com.aerovieweb.WebRequestExecutor;
import common.SharedPreferencesManager;

/**
 * Created by alerman on 9/27/14.
 */
public class DBSyncReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String sessionId = SharedPreferencesManager.retrieve(context,context.getString(R.string.sessionId),null);
        String deviceSyncId = SharedPreferencesManager.retrieve(context,context.getString(R.string.deviceId),null);
        try {
             deviceSyncId = WebRequestExecutor.getInstance(context.getString(R.string.aerovie_url)).sync(sessionId,deviceSyncId);
            if(deviceSyncId == null) {
                SharedPreferencesManager.store(context, context.getString(R.string.sessionId), null);
                Intent mainActivity = new Intent(context, LoginActivity.class);

                if(LoginActivity.dbSyncIntent != null) {
                    AlarmManager am = (AlarmManager) context
                            .getSystemService(context.ALARM_SERVICE);
                    am.cancel(LoginActivity.dbSyncIntent);
                }


                mainActivity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(mainActivity);
            }
            SharedPreferencesManager.store(context, context.getString(R.string.deviceId),deviceSyncId);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
