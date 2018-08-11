package anjelloatoz.com.codetestapp.Service;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Anjelloatoz on 8/11/18.
 */

public class PersistenceManager {

    private static PersistenceManager INSTANCE;
    private Context context;

    private String LOGIN_INFO = "LOGIN_INFO";

    public static PersistenceManager getInstance(){
        return INSTANCE;
    }

    public static void initInstance(Context context){
        INSTANCE = new PersistenceManager();
        INSTANCE.context = context;
    }

    public boolean isLoggedIn(){
        SharedPreferences sharedPref = this.context.getSharedPreferences(LOGIN_INFO, Context.MODE_PRIVATE);
        return null != sharedPref.getString(LOGIN_INFO, null);
    }
}


