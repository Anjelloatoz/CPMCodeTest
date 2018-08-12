package anjelloatoz.com.codetestapp.Service;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import anjelloatoz.com.codetestapp.Constants;
import anjelloatoz.com.codetestapp.Model.GHToken;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Anjelloatoz on 8/11/18.
 */

public class PersistenceManager {

    private static PersistenceManager INSTANCE;
    private Context context;
    Gson gson = new GsonBuilder().serializeNulls().create();

    public static PersistenceManager getInstance(){
        return INSTANCE;
    }

    public static void initInstance(Context context){
        INSTANCE = new PersistenceManager();
        INSTANCE.context = context;
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

    //Todo This is a test approach only. Access token management should be done with an appropriate framework.
    public void setAccessToken(GHToken token){
        SharedPreferences sharedPref = this.context.getSharedPreferences(Constants.ACCESS_TOKEN_KEY, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(Constants.ACCESS_TOKEN_KEY, token == null? null : gson.toJson(token));
        editor.commit();
    }

    public GHToken getAccessToken() {
        SharedPreferences sharedPref = this.context.getSharedPreferences(Constants.ACCESS_TOKEN_KEY, MODE_PRIVATE);
        return gson.fromJson(sharedPref.getString(Constants.ACCESS_TOKEN_KEY, ""), new TypeToken<GHToken>() {}.getType());
    }
}


