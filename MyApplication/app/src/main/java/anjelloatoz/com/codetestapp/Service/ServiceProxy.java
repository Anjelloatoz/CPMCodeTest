package anjelloatoz.com.codetestapp.Service;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.HashMap;
import java.util.Map;

import anjelloatoz.com.codetestapp.BuildConfig;
import anjelloatoz.com.codetestapp.Model.GHToken;
import anjelloatoz.com.codetestapp.Network.CallbackNetwork;
import anjelloatoz.com.codetestapp.Network.NetworkBroker;

import static com.android.volley.VolleyLog.TAG;

/**
 * Created by Anjelloatoz on 8/11/18.
 */

public class ServiceProxy {
    private static ServiceProxy INSTANCE;
    Gson gson = new GsonBuilder().serializeNulls().create();

    public static ServiceProxy getInstance(){
        if(INSTANCE == null)
            INSTANCE = new ServiceProxy();
        return INSTANCE;
    }

    public void setAuthToken(String auth_token){
        PersistenceManager.getInstance().storeAuthToken(auth_token);
    }

    public String getAuthToken(){
        return PersistenceManager.getInstance().getAuthToken();
    }

    public void getAccessToken(){
        Map<String, String> mParams = new HashMap<String, String>();
        mParams.put("client_id", BuildConfig.clientId);
        mParams.put("client_secret", BuildConfig.clientSecret);
        mParams.put("code", getAuthToken());
        mParams.put("scope", "repo");
        mParams.put("Accept","application/json");

        NetworkBroker.getInstance().sendPost(NetworkBroker.PATH_ACCESS_TOKEN, mParams, new CallbackNetwork() {
            @Override
            public void success(Object result) {
                Log.e(TAG, "OAuth success: "+result.toString());

                GHToken token = gson.fromJson((String) result, new TypeToken<GHToken>() {
                }.getType());
                PersistenceManager.getInstance().setAccessToken(token);
            }

            @Override
            public void failure(int errorCode, String message) {
                Log.e(TAG, "OAuth failure: "+message);
            }

            @Override
            public void networkFailure() {
                Log.e(TAG, "Network failure");
            }

            @Override
            public void serverFailure() {
                Log.e(TAG, "Server failure");
            }
        });
    }
}
