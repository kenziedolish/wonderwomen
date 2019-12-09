package com.example.pinhole3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerView_Config {
    private Context mContext;
    private JobsAdapter mJobAdapter;
    public void setConfig(RecyclerView recyclerView, Context context, List<JobDTO> jobs, List<String> keys){
        mContext = context;
        mJobAdapter = new JobsAdapter(jobs, keys);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(mJobAdapter);
    }
    class JobItemView extends RecyclerView.ViewHolder
    {
        private TextView mJobTitle;
        private TextView mAnnualSalary;
        private TextView mMajor;
        private TextView mHourlyRate;

        private String key;

        public JobItemView( ViewGroup parent) {
            super(LayoutInflater.from(mContext).inflate(R.layout.job_list_item, parent, false));

            mJobTitle = (TextView) itemView.findViewById(R.id.job_titletxt);
            mMajor = (TextView) itemView.findViewById(R.id.majortxt);
            mAnnualSalary = (TextView) itemView.findViewById(R.id.majortxt);
            mHourlyRate = (TextView) itemView.findViewById(R.id.hourlyRatetxt);

        }

        public void bind(JobDTO job, String key){
            mJobTitle.setText(job.getJOB_TITLE());
            mAnnualSalary.setText("Annual Salary: "+job.getANNUAL_SALARY());
            mMajor.setText("Major: "+job.getMAJOR());
            mHourlyRate.setText("Hourly Rate: "+job.getHOURLY_RATE());
            this.key = key;
        }


    }
    class JobsAdapter extends RecyclerView.Adapter<JobItemView>{
        private List<JobDTO> mJobList;
        private List<String> mKeys;

        public JobsAdapter(List<JobDTO> mJobList, List<String> mKeys) {
            this.mJobList = mJobList;
            this.mKeys = mKeys;
        }

        @NonNull
        @Override
        public JobItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new JobItemView(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull JobItemView holder, int position) {
            holder.bind(mJobList.get(position),mKeys.get(position));
        }

        @Override
        public int getItemCount() {
            return mJobList.size();
        }
    }
}
