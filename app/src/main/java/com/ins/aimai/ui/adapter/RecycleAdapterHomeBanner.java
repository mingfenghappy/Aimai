package com.ins.aimai.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.bumptech.glide.Glide;
import com.ins.aimai.R;
import com.ins.aimai.common.AppData;
import com.ins.aimai.ui.activity.InfoActivity;
import com.ins.aimai.ui.activity.WebActivity;
import com.ins.common.entity.Image;
import com.ins.common.utils.GlideUtil;
import com.ins.common.view.BannerView;

import java.util.ArrayList;
import java.util.List;

public class RecycleAdapterHomeBanner extends DelegateAdapter.Adapter<RecycleAdapterHomeBanner.Holder> {

    private Context context;
    private LayoutHelper layoutHelper;
    private List<Image> results = new ArrayList<>();

    public List<Image> getResults() {
        return results;
    }

    public RecycleAdapterHomeBanner(Context context, LayoutHelper layoutHelper) {
        this.context = context;
        this.layoutHelper = layoutHelper;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return layoutHelper;
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.item_home_banner;
    }

    @Override
    public RecycleAdapterHomeBanner.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Holder(LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false));
    }

    @Override
    public void onBindViewHolder(final RecycleAdapterHomeBanner.Holder holder, final int position) {
        holder.banner.setDatas(results);
        holder.item_home_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InfoActivity.start(context);
            }
        });
        holder.banner.setOnBannerClickListener(onBannerClickListener);

        holder.lay_home_about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WebActivity.start(context, "关于我们", AppData.Url.about);
            }
        });
        holder.lay_home_quali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WebActivity.start(context, "资质", AppData.Url.quelity);
            }
        });
        holder.lay_home_station.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WebActivity.start(context, "网点", AppData.Url.netpoint);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class Holder extends RecyclerView.ViewHolder {

        private BannerView banner;
        private View item_home_more;
        private View lay_home_about;
        private View lay_home_quali;
        private View lay_home_station;

        public Holder(View itemView) {
            super(itemView);
            lay_home_about = itemView.findViewById(R.id.lay_home_about);
            lay_home_quali = itemView.findViewById(R.id.lay_home_quali);
            lay_home_station = itemView.findViewById(R.id.lay_home_station);
            banner = (BannerView) itemView.findViewById(R.id.banner);
            item_home_more = itemView.findViewById(R.id.item_home_more);
            banner.showTitle(false);
            banner.setOnLoadImgListener(new BannerView.OnLoadImgListener() {
                @Override
                public void onloadImg(ImageView imageView, String imgurl, int defaultSrc) {
                    GlideUtil.loadImg(imageView, defaultSrc, imgurl);
                }
            });
        }
    }

    private BannerView.OnBannerClickListener onBannerClickListener;

    public void setOnBannerClickListener(BannerView.OnBannerClickListener onBannerClickListener) {
        this.onBannerClickListener = onBannerClickListener;
    }
}
