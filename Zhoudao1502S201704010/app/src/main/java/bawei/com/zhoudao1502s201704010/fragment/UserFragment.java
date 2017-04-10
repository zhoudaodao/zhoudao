package bawei.com.zhoudao1502s201704010.fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import bawei.com.zhoudao1502s201704010.R;
import bawei.com.zhoudao1502s201704010.utils.Xutils;
import static bawei.com.zhoudao1502s201704010.R.id.lv;

/**
 * date:2017/4/10
 * author:周道(leovo)
 * funcation:
 */

public class UserFragment extends Fragment {

    private ListView mLv;
    private String url;

    public static UserFragment getFragment(String url){
        UserFragment userFragment=new UserFragment();
        Bundle bundle=new Bundle();
        bundle.putString("url",url);
        userFragment.setArguments(bundle);
        return userFragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.userfragment,null);
        mLv = (ListView) view.findViewById(lv);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle arguments = getArguments();
        url = arguments.getString("url");
        Xutils.get(url,mLv,getActivity());
    }
}
