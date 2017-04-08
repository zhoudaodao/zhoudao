package bawei.com.slidingmenutab;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;

/**
 * date:2017/4/8
 * author:周道(leovo)
 * funcation:
 */

public class MenuFragment extends Fragment{

    private ListView mLv;
    private List<String> list=new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      View view=inflater.inflate(R.layout.fragment_menu,null);
        mLv = (ListView) view.findViewById(R.id.lv);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getData();
        mLv.setAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,list));
    }

    private void getData() {
        list.add("好友动态");
        list.add("我的话题");
        list.add("收藏");
        list.add("活动");
        list.add("商城");
    }
}
