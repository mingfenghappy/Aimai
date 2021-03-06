package com.ins.aimai.ui.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ins.aimai.R;
import com.ins.aimai.bean.Video;
import com.ins.aimai.bean.common.TestBean;
import com.ins.aimai.bean.common.VideoDirectiry;
import com.ins.aimai.common.AppData;
import com.ins.aimai.common.AppHelper;
import com.ins.common.interfaces.OnRecycleItemClickListener;
import com.ins.common.utils.TimeUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RecycleAdapterVideoDirectory extends RecyclerView.Adapter<RecycleAdapterVideoDirectory.Holder> {

    private Context context;
    private List<Video> results = new ArrayList<>();
    //字体大小，默认中号
    private int sizeType = AppData.Constant.TEXTSIZE_MIDDLE;

    public List<Video> getResults() {
        return results;
    }

    public RecycleAdapterVideoDirectory(Context context) {
        this.context = context;
    }

    @Override
    public RecycleAdapterVideoDirectory.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Holder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_video_directory, parent, false));
    }

    @Override
    public void onBindViewHolder(final RecycleAdapterVideoDirectory.Holder holder, final int position) {
        final Video video = results.get(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) listener.onItemClick(holder);
            }
        });

        holder.text_directory_title.setText(video.getCourseWareName() + ": " + video.getName());
        holder.text_directory_time.setText(TimeUtil.formatTimeRange(video.getHighDefinitionSeconds() * 1000, "mm:ss"));
        holder.text_directory_title.setSelected(AppHelper.VideoPlay.isVideoStatusFinish(video));

        //动态设置字体大小
        switch (sizeType) {
            case AppData.Constant.TEXTSIZE_BIG:
                holder.text_directory_title.setTextSize(TypedValue.COMPLEX_UNIT_PX, context.getResources().getDimension(R.dimen.text_big_nomal));
                holder.text_directory_time.setTextSize(TypedValue.COMPLEX_UNIT_PX, context.getResources().getDimension(R.dimen.text_nomal_small));
                break;
            case AppData.Constant.TEXTSIZE_MIDDLE:
                holder.text_directory_title.setTextSize(TypedValue.COMPLEX_UNIT_PX, context.getResources().getDimension(R.dimen.text_nomal));
                holder.text_directory_time.setTextSize(TypedValue.COMPLEX_UNIT_PX, context.getResources().getDimension(R.dimen.text_small));
                break;
            case AppData.Constant.TEXTSIZE_SMALL:
                holder.text_directory_title.setTextSize(TypedValue.COMPLEX_UNIT_PX, context.getResources().getDimension(R.dimen.text_nomal_small));
                holder.text_directory_time.setTextSize(TypedValue.COMPLEX_UNIT_PX, context.getResources().getDimension(R.dimen.text_small_tiny));
                break;
        }
    }

    public void setTextSize(int sizeType) {
        this.sizeType = sizeType;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        private TextView text_directory_title;
        private TextView text_directory_time;

        public Holder(View itemView) {
            super(itemView);
            text_directory_title = (TextView) itemView.findViewById(R.id.text_directory_title);
            text_directory_time = (TextView) itemView.findViewById(R.id.text_directory_time);
        }
    }

    private OnRecycleItemClickListener listener;

    public void setOnItemClickListener(OnRecycleItemClickListener listener) {
        this.listener = listener;
    }
}
