package com.ins.aimai.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ins.aimai.R;
import com.ins.aimai.bean.ExamResult;
import com.ins.aimai.bean.common.TestBean;
import com.ins.common.interfaces.OnRecycleItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class RecycleAdapterExamResult extends RecyclerView.Adapter<RecycleAdapterExamResult.Holder> {

    private Context context;
    private List<ExamResult> results = new ArrayList<>();

    public List<ExamResult> getResults() {
        return results;
    }

    public RecycleAdapterExamResult(Context context) {
        this.context = context;
    }

    @Override
    public RecycleAdapterExamResult.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Holder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_exam_result, parent, false));
    }

    @Override
    public void onBindViewHolder(final RecycleAdapterExamResult.Holder holder, final int position) {
        final ExamResult examResult = results.get(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) listener.onItemClick(holder);
            }
        });
        holder.text_item_examresult_num.setText(position + 1 + "");
        holder.text_item_examresult_num.setSelected(examResult.getIsCorrect() == 1 ? true : false);
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public ArrayList<Integer> getErrorIdsList() {
        ArrayList<Integer> ids = new ArrayList<>();
        for (ExamResult examResult : results) {
            if (!examResult.isCorrect()) {
                ids.add(examResult.getExaminationId());
            }
        }
        return ids;
    }

    public ArrayList<Integer> getAllIdsList() {
        ArrayList<Integer> ids = new ArrayList<>();
        for (ExamResult examResult : results) {
            ids.add(examResult.getExaminationId());
        }
        return ids;
    }

    public class Holder extends RecyclerView.ViewHolder {

        private TextView text_item_examresult_num;

        public Holder(View itemView) {
            super(itemView);
            text_item_examresult_num = (TextView) itemView.findViewById(R.id.text_item_examresult_num);
        }
    }

    private OnRecycleItemClickListener listener;

    public void setOnItemClickListener(OnRecycleItemClickListener listener) {
        this.listener = listener;
    }
}
