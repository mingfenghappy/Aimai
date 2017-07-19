package com.ins.aimai.ui.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ins.aimai.R;
import com.ins.aimai.bean.TestBean;
import com.ins.aimai.interfaces.PagerInter;
import com.ins.aimai.ui.adapter.RecycleAdapterPracticeList;
import com.ins.aimai.ui.base.BaseFragment;
import com.ins.common.common.ItemDecorationDivider;
import com.ins.common.helper.LoadingViewHelper;
import com.ins.common.interfaces.OnRecycleItemClickListener;
import com.liaoinstan.springview.container.AliFooter;
import com.liaoinstan.springview.container.AliHeader;
import com.liaoinstan.springview.widget.SpringView;

/**
 * Created by liaoinstan
 */
public class PracticeListFragment extends BaseFragment implements OnRecycleItemClickListener {

    private int position;
    private View rootView;

    private View showin;
    private ViewGroup showingroup;

    private SpringView springView;
    private RecyclerView recycler;
    private RecycleAdapterPracticeList adapter;
    private PagerInter pagerInter;

    public static Fragment newInstance(int position) {
        PracticeListFragment fragment = new PracticeListFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("position", position);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.position = getArguments().getInt("position");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_practice_list, container, false);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initBase();
        initView();
        initCtrl();
        initData();
    }

    private void initBase() {
        pagerInter = (PagerInter) getActivity();
    }

    private void initView() {
        showingroup = (ViewGroup) rootView.findViewById(R.id.showingroup);
        springView = (SpringView) rootView.findViewById(R.id.spring);
        recycler = (RecyclerView) rootView.findViewById(R.id.recycler);
    }

    private void initCtrl() {
        adapter = new RecycleAdapterPracticeList(getContext());
        adapter.setOnItemClickListener(this);
        recycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recycler.addItemDecoration(new ItemDecorationDivider(getContext()));
        recycler.setAdapter(adapter);
        springView.setHeader(new AliHeader(getContext(), false));
        springView.setFooter(new AliFooter(getContext(), false));
        springView.setListener(new SpringView.OnFreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        springView.onFinishFreshAndLoad();
                    }
                }, 800);
            }

            @Override
            public void onLoadmore() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        adapter.getResults().add(new TestBean());
                        adapter.getResults().add(new TestBean());
                        adapter.notifyDataSetChanged();
                        springView.onFinishFreshAndLoad();
                    }
                }, 800);
            }
        });
    }

    private void initData() {
        showin = LoadingViewHelper.showin(showingroup, R.layout.layout_loading, showin);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                adapter.getResults().clear();
                adapter.getResults().add(new TestBean());
                adapter.getResults().add(new TestBean());
                adapter.getResults().add(new TestBean());
                adapter.getResults().add(new TestBean());
                adapter.getResults().add(new TestBean());
                adapter.getResults().add(new TestBean());
                adapter.getResults().add(new TestBean());
                adapter.getResults().add(new TestBean());
                adapter.getResults().add(new TestBean());
                adapter.getResults().add(new TestBean());
                adapter.getResults().add(new TestBean());
                adapter.getResults().add(new TestBean());
                adapter.getResults().add(new TestBean());
                adapter.getResults().add(new TestBean());
                adapter.notifyDataSetChanged();
                LoadingViewHelper.showout(showingroup, showin);
            }
        }, 1000);
    }

    @Override
    public void onItemClick(RecyclerView.ViewHolder viewHolder) {
    }
}