package anjelloatoz.com.codetestapp.Service;

/**
 * Created by Anjelloatoz on 8/11/18.
 */

public class ServiceProxy {
    private static ServiceProxy INSTANCE;

    public static ServiceProxy getInstance(){
        if(INSTANCE == null)
            INSTANCE = new ServiceProxy();
        return INSTANCE;
    }

    public boolean isLoggedIn(){
        return PersistenceManager.getInstance().isLoggedIn();
    }

    public void setAuthToken(String auth_token){
        PersistenceManager.getInstance().storeAuthToken(auth_token);
    }

    public String getAuthToken(){
        return PersistenceManager.getInstance().getAuthToken();
    }
}
