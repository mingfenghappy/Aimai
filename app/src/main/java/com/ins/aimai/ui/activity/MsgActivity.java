package com.ins.aimai.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.reflect.TypeToken;
import com.ins.aimai.R;
import com.ins.aimai.bean.Info;
import com.ins.aimai.bean.Msg;
import com.ins.aimai.bean.Order;
import com.ins.aimai.bean.common.CommonBean;
import com.ins.aimai.bean.common.TestBean;
import com.ins.aimai.common.AppData;
import com.ins.aimai.net.BaseCallback;
import com.ins.aimai.net.NetApi;
import com.ins.aimai.net.NetParam;
import com.ins.aimai.net.helper.NetListHelper;
import com.ins.aimai.ui.adapter.RecycleAdapterMsg;
import com.ins.aimai.ui.base.BaseAppCompatActivity;
import com.ins.aimai.utils.ToastUtil;
import com.ins.common.helper.LoadingViewHelper;
import com.ins.common.interfaces.OnRecycleItemClickListener;
import com.ins.common.utils.StrUtil;
import com.ins.common.view.LoadingLayout;
import com.liaoinstan.springview.container.AliFooter;
import com.liaoinstan.springview.container.AliHeader;
import com.liaoinstan.springview.widget.SpringView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;

public class MsgActivity extends BaseAppCompatActivity implements OnRecycleItemClickListener {

    private LoadingLayout loadingLayout;
    private SpringView springView;
    private RecyclerView recycler;
    private RecycleAdapterMsg adapter;

    private NetListHelper netListHelper;

    public static void start(Context context) {
        if (AppData.App.getUser() != null) {
            Intent intent = new Intent(context, MsgActivity.class);
            context.startActivity(intent);
        } else {
            LoginActivity.start(context);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_msg);
        setToolbar();
        initBase();
        initView();
        initCtrl();
        initData();
    }

    private void initBase() {
    }

    private void initView() {
        loadingLayout = (LoadingLayout) findViewById(R.id.loadingLayout);
        recycler = (RecyclerView) findViewById(R.id.recycler);
        springView = (SpringView) findViewById(R.id.spring);
    }

    private void initCtrl() {
        adapter = new RecycleAdapterMsg(this);
        adapter.setOnItemClickListener(this);
        recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recycler.setAdapter(adapter);
        loadingLayout.setOnRefreshListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                netListHelper.netQueryList(0);
            }
        });
        springView.setHeader(new AliHeader(this, false));
        springView.setFooter(new AliFooter(this, false));
        springView.setListener(new SpringView.OnFreshListener() {
            @Override
            public void onRefresh() {
                netListHelper.netQueryList(1);
            }

            @Override
            public void onLoadmore() {
                netListHelper.netQueryList(2);
            }
        });
        netListHelper = new NetListHelper<Msg>().init(loadingLayout, springView,
                new TypeToken<List<Msg>>() {
                }.getType(),
                new NetListHelper.CallHander() {
                    @Override
                    public Call getCall(int type) {
                        Map param = netListHelper.getParam(type);
                        return NetApi.NI().queryMsg(param);
                    }
                },
                new NetListHelper.OnListLoadCallback<Msg>() {
                    @Override
                    public void onFreshSuccess(int status, List<Msg> beans, String msg) {
                        adapter.getResults().clear();
                        adapter.getResults().addAll(beans);
                        adapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onLoadSuccess(int status, List<Msg> beans, String msg) {
                        adapter.getResults().addAll(beans);
                        adapter.notifyDataSetChanged();
                    }
                });
    }

    private void initData() {
        netListHelper.netQueryList(0);
    }

    @Override
    public void onItemClick(RecyclerView.ViewHolder viewHolder) {
        Msg msg = adapter.getResults().get(viewHolder.getLayoutPosition());
        WebActivity.start(this, msg.getTitle(), "http://www.baidu.com");
        netCheckMsg(msg.getId());
    }

    private void netCheckMsg(int id) {
        Map<String, Object> param = new NetParam()
                .put("systemInfoId", id)
                .build();
        NetApi.NI().checkMsg(param).enqueue(new BaseCallback<CommonBean>(CommonBean.class) {
            @Override
            public void onSuccess(int status, CommonBean com, String msg) {
                netListHelper.netQueryList(1);
            }

            @Override
            public void onError(int status, String msg) {
                ToastUtil.showToastShort(msg);
            }
        });
    }

//    ///////////////////////////////////
//    //////////////分页查询
//    ///////////////////////////////////
//
//    private int page;
//    private final int PAGE_COUNT = 10;
//
//    /**
//     * type:0 首次加载 1:下拉刷新 2:上拉加载
//     *
//     * @param type
//     */
//    private void netQueryMsg(final int type) {
//        Map map = new HashMap<String, Object>() {{
//            put("pageNO", type == 0 || type == 1 ? "1" : page + 1 + "");
//            put("pageSize", PAGE_COUNT + "");
//        }};
//        if (type == 0) loadingLayout.showLoadingView();
//        NetApi.NI().queryMsg(NetParam.newInstance().put(map).build()).enqueue(new BaseCallback<List<Msg>>(new TypeToken<List<Msg>>() {
//        }.getType()) {
//            @Override
//            public void onSuccess(int status, List<Msg> beans, String msg) {
//                if (!StrUtil.isEmpty(beans)) {
//                    //下拉加载和首次加载要清除原有数据并把页码置为1，上拉加载不断累加页码
//                    if (type == 0 || type == 1) {
//                        adapter.getResults().clear();
//                        page = 1;
//                    } else {
//                        page++;
//                    }
//                    adapter.getResults().addAll(beans);
//                    adapter.notifyDataSetChanged();
//
//                    //加载结束恢复列表
//                    if (type == 0) {
//                        loadingLayout.showOut();
//                    } else {
//                        springView.onFinishFreshAndLoad();
//                    }
//                } else {
//                    //没有数据设置空数据页面，下拉加载不用，仅提示
//                    if (type == 0 || type == 1) {
//                        loadingLayout.showLackView();
//                    } else {
//                        springView.onFinishFreshAndLoad();
//                        ToastUtil.showToastShort("没有更多的数据了");
//                    }
//                }
//            }
//
//            @Override
//            public void onError(int status, String msg) {
//                ToastUtil.showToastShort(msg);
//                //首次加载发生异常设置error页面，其余仅提示
//                if (type == 0) {
//                    loadingLayout.showFailView();
//                } else {
//                    springView.onFinishFreshAndLoad();
//                }
//            }
//        });
//    }
}
