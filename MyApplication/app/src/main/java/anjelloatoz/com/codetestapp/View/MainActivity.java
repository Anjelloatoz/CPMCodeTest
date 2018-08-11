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
    private String redirectUri = BuildConfig.redirectUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Uri uri = getIntent().getData(); //We check if the app is started by the redirect uri.
        if(uri != null && uri.toString().startsWith(redirectUri)){ //If so, we store the auth_token to obtain the access token
            String code = uri.getQueryParameter("code");
            ServiceProxy.getInstance().requestAccessToken(code);
        } else{
            if(ServiceProxy.getInstance().getAccessToken() != null){ //Access token already available
                Log.e(TAG, "ACCESS TOKEN: "+ServiceProxy.getInstance().getAccessToken());
                getUserRepos();
            } else{
                Log.e(TAG, "User NOT loged in"); //We do not have an access token. This is the first time the app is running. We proceed to the OAuth flow.
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/login/oauth/authorize"+"?client_id="+clientId+"&scope=repo&redirect_uri="+redirectUri));
                startActivity(intent);
            }
        }
    }

    private void getUserRepos(){
        ServiceProxy.getInstance().requestUserRepos();
    }

    @Override
    protected void onResume(){
        super.onResume();

    }
}
