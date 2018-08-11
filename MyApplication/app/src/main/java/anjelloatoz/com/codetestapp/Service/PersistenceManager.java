package anjelloatoz.com.codetestapp.Service;

import android.content.Context;
import android.content.SharedPreferences;

import anjelloatoz.com.codetestapp.Constants;

import static android.content.Context.MODE_PRIVATE;

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
        SharedPreferences sharedPref = this.context.getSharedPreferences(LOGIN_INFO, MODE_PRIVATE);
        return null != sharedPref.getString(LOGIN_INFO, null);
    }

    public void storeAuthToken(String code){
        SharedPreferences sharedPref = this.context.getSharedPreferences(Constants.AUTH_TOKEN_KEY, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(Constants.AUTH_TOKEN_KEY, code);
        editor.commit();
    }

    public String getAuthToken(){
        SharedPreferences sharedPrefs = this.context.getSharedPreferences(Constants.AUTH_TOKEN_KEY, MODE_PRIVATE);
        return sharedPrefs.getString(Constants.AUTH_TOKEN_KEY, null);
    }
}


