package anjelloatoz.com.codetestapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import anjelloatoz.com.codetestapp.Service.ServiceProxy;

public class MainActivity extends AppCompatActivity {

    private static String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(ServiceProxy.getInstance().isLoggedIn()){
            Log.e(TAG, "User loged in");
        } else{
            Log.e(TAG, "User NOT loged in");
        }
    }
}
