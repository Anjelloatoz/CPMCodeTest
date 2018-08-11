package anjelloatoz.com.codetestapp.View;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import anjelloatoz.com.codetestapp.BuildConfig;
import anjelloatoz.com.codetestapp.R;
import anjelloatoz.com.codetestapp.Service.ServiceProxy;

public class MainActivity extends AppCompatActivity {

    private static String TAG = "MainActivity";

    private String clientId = BuildConfig.clientId;
    private String clientSecret = BuildConfig.clientSecret;
    private String redirectUri = BuildConfig.redirectUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(ServiceProxy.getInstance().isLoggedIn()){
            Log.e(TAG, "User loged in");
        } else{
            Log.e(TAG, "User NOT loged in");
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/login/oauth/authorize"+"?client_id="+clientId+"&scope=repo&redirect_uri="+redirectUri));
            startActivity(intent);
        }
    }

    @Override
    protected void onResume(){
        super.onResume();
        Uri uri = getIntent().getData();

        if(uri != null && uri.toString().startsWith(redirectUri)){
            String code = uri.getQueryParameter("code");
            String scope = uri.getQueryParameter("scope");
            Log.e(TAG, "REDIRECT CODE: "+code);
        }
    }
}
