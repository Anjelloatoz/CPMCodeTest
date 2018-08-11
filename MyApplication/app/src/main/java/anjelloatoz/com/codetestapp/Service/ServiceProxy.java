package anjelloatoz.com.codetestapp.Service;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import anjelloatoz.com.codetestapp.BuildConfig;
import anjelloatoz.com.codetestapp.Model.GHToken;
import anjelloatoz.com.codetestapp.Model.Repo;
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

    public GHToken getAccessToken(){ //Obtaining from the local persistence layer
        return  PersistenceManager.getInstance().getAccessToken();
    }

    public void requestAccessToken(String code){ //Requesting from the server.
        Map<String, String> mParams = new HashMap<String, String>();
        mParams.put("client_id", BuildConfig.clientId);
        mParams.put("client_secret", BuildConfig.clientSecret);
        mParams.put("code", code);
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

    public void requestUserRepos(){
        NetworkBroker.getInstance().sendGet(NetworkBroker.PATH_USER_REPOS, null, new CallbackNetwork() {
            @Override
            public void success(Object result) {
                Log.e(TAG, "requestUserRepos SUCCESS: "+result.toString());
                ArrayList<Repo> repo_list = gson.fromJson((String) result, new TypeToken<ArrayList<Repo>>() {
                }.getType());
            }

            @Override
            public void failure(int errorCode, String message) {
                Log.e(TAG, "requestUserRepos FAILURE: "+message);
            }

            @Override
            public void networkFailure() {
                Log.e(TAG, "requestUserRepos NETWORK FAILURE");
            }

            @Override
            public void serverFailure() {
                Log.e(TAG, "requestUserRepos SERVER FAILURE");
            }
        });
    }
}
