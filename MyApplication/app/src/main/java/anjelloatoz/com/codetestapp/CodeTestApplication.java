package anjelloatoz.com.codetestapp;

import android.app.Application;

import anjelloatoz.com.codetestapp.Network.NetworkBroker;
import anjelloatoz.com.codetestapp.Service.PersistenceManager;

/**
 * Created by Anjelloatoz on 8/11/18.
 */

public class CodeTestApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        PersistenceManager.initInstance(getApplicationContext());
        NetworkBroker.initInstance(getApplicationContext());
    }
}
