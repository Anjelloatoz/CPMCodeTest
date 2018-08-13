package anjelloatoz.com.codetestapp.ViewModel;

import android.util.Log;

import anjelloatoz.com.codetestapp.BusinessModel.GeneralCallback;
import anjelloatoz.com.codetestapp.BusinessModel.Owner;
import anjelloatoz.com.codetestapp.BusinessModel.Repo;
import anjelloatoz.com.codetestapp.Service.ServiceProxy;

/**
 * Created by Anjelloatoz on 8/12/18.
 */

public class RepoModel {
    private static String TAG = "RepoModel";

    public String id;
    public String name;
    public String full_name;
    public Owner owner;

    public RepoModel(Repo repo){
        this.id = repo.id;
        this.name = repo.name;
        this.full_name = repo.full_name;
        this.owner = repo.owner;
    }

    public RepoModel(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public void getRepoList(final GeneralCallback callback){
        ServiceProxy.getInstance().requestUserRepos(new GeneralCallback() {
            @Override
            public void success(Object result) {
                callback.success(result);
            }

            @Override
            public void failure(String message) {
                Log.e(TAG, "getRepoList Failure: "+message);
            }
        });
    }
}
