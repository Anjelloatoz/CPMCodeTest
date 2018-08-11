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
}
