package com.ins.aimai.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ins.aimai.R;
import com.ins.aimai.bean.User;
import com.ins.aimai.bean.common.TestBean;
import com.ins.common.interfaces.OnRecycleItemClickListener;
import com.ins.common.utils.GlideUtil;

import java.util.ArrayList;
import java.util.List;

public class RecycleAdapterLessonEmploy extends RecyclerView.Adapter<RecycleAdapterLessonEmploy.Holder> {

    private Context context;
    private List<User> results = new ArrayList<>();

    public List<User> getResults() {
        return results;
    }

    public RecycleAdapterLessonEmploy(Context context) {
        this.context = context;
    }

    @Override
    public RecycleAdapterLessonEmploy.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Holder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lesson_employ, parent, false));
    }

    @Override
    public void onBindViewHolder(final RecycleAdapterLessonEmploy.Holder holder, final int position) {
        final User user = results.get(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) listener.onItemClick(holder);
            }
        });
        GlideUtil.loadCircleImg(holder.img_lessonemploy_header, R.drawable.default_header_edit, user.getAvatar());
        holder.text_lessonemploy_name.setText(user.getShowName());
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        private ImageView img_lessonemploy_header;
        private TextView text_lessonemploy_name;

        public Holder(View itemView) {
            super(itemView);
            img_lessonemploy_header = (ImageView) itemView.findViewById(R.id.img_lessonemploy_header);
            text_lessonemploy_name = (TextView) itemView.findViewById(R.id.text_lessonemploy_name);
        }
    }

    private OnRecycleItemClickListener listener;

    public void setOnItemClickListener(OnRecycleItemClickListener listener) {
        this.listener = listener;
    }
}
