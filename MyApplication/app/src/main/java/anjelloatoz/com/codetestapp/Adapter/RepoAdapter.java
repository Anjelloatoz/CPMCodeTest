package anjelloatoz.com.codetestapp.Adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import anjelloatoz.com.codetestapp.Model.Repo;
import anjelloatoz.com.codetestapp.R;
import anjelloatoz.com.codetestapp.ViewModel.RepoModel;
import anjelloatoz.com.codetestapp.databinding.RepoListItemLayoutBinding;

/**
 * Created by Anjelloatoz on 8/12/18.
 */

public class RepoAdapter extends ArrayAdapter<RepoModel>{

    ArrayList<RepoModel> repoModelArrayList;
    Context context;


    public RepoAdapter(@NonNull Context context, ArrayList<RepoModel> repoModelArrayList) {
        super(context, R.layout.repo_list_item_layout, repoModelArrayList);
        this.context = context;
        this.repoModelArrayList = repoModelArrayList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        RepoListItemLayoutBinding repoListItemLayoutBinding = DataBindingUtil.inflate(layoutInflater, R.layout.repo_list_item_layout, parent, false);
        repoListItemLayoutBinding.setRepoList(repoModelArrayList.get(position));
        return repoListItemLayoutBinding.getRoot();
    }
}
