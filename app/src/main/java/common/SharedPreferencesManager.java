package common;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by alerman on 9/27/14.
 */
public class SharedPreferencesManager {


    public static final String SHARED_PREFS_NAME = "aerovie.alerman.com.aerovie";

    public static void store(Context context, String key, String value){

        SharedPreferences prefs = context.getSharedPreferences(
                SHARED_PREFS_NAME, Context.MODE_PRIVATE);

        prefs.edit().putString(key,value).commit();


    }

    public static String retrieve(Context context,String key, String defaultValue){
        return context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE).getString(key, defaultValue);

    }
}
