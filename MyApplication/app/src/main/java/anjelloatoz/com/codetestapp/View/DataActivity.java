package anjelloatoz.com.codetestapp.View;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.ArrayList;

import anjelloatoz.com.codetestapp.Adapter.RepoAdapter;
import anjelloatoz.com.codetestapp.Model.GeneralCallback;
import anjelloatoz.com.codetestapp.Model.Repo;
import anjelloatoz.com.codetestapp.R;
import anjelloatoz.com.codetestapp.ViewModel.RepoModel;
import anjelloatoz.com.codetestapp.databinding.ActivityDataBinding;

public class DataActivity extends AppCompatActivity {
    private static String TAG = "DataActivity";

    private ActivityDataBinding activityDataBinding;
    private RepoModel repoModel;
    private ArrayList<RepoModel> repoModelArrayList;
    private RepoAdapter repoAdapter;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;

        activityDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_data);
        repoModel = new RepoModel();
        repoModel.getRepoList(new GeneralCallback() {
            @Override
            public void success(Object result) {
                repoModelArrayList = (ArrayList<RepoModel>) result;
                repoAdapter = new RepoAdapter(context, repoModelArrayList);
                activityDataBinding.dataList.setAdapter(repoAdapter);
            }

            @Override
            public void failure(String message) {
                Log.e(TAG, "getRepoList Failure: "+message);
            }
        });
    }
}
