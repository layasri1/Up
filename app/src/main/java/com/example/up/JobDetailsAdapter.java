package com.example.up;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class JobDetailsAdapter extends RecyclerView.Adapter<JobDetailsAdapter.ViewHolder> {

    private List<UserDetails> jobDetailsList;

    public JobDetailsAdapter(List<UserDetails> jobDetailsList) {
        this.jobDetailsList = jobDetailsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_job_detail, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
       public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        UserDetails jobDetails = jobDetailsList.get(position);

        // Bind job details to the ViewHolder
        holder.userIdTextView.setText("User ID: " + jobDetails.getUserId());
        holder.daysTextView.setText("Days: " + jobDetails.getDays());
        holder.startDateTextView.setText("Start Date: " + jobDetails.getStartDate());
        holder.cropNameTextView.setText("Crop Name: " + jobDetails.getCropName());
        holder.workTypeTextView.setText("Work Type: " + jobDetails.getWorkType());
        holder.requirementTextView.setText("Requirement: " + jobDetails.getRequirement());
        holder.areaTextView.setText("Area: " + jobDetails.getArea());
        holder.wageTextView.setText("Wage: " + jobDetails.getWage());
        // Bind more job details to their respective TextViews here
    }


    @Override
    public int getItemCount() {
        return jobDetailsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView userIdTextView, daysTextView, startDateTextView, cropNameTextView, workTypeTextView,
                requirementTextView, areaTextView, wageTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.jobDetailCardView);
            userIdTextView = itemView.findViewById(R.id.jobUserIdTextView);
            daysTextView = itemView.findViewById(R.id.jobDaysTextView);
            startDateTextView = itemView.findViewById(R.id.jobStartDateTextView);
            cropNameTextView = itemView.findViewById(R.id.jobCropNameTextView);
            workTypeTextView = itemView.findViewById(R.id.jobWorkTypeTextView);
            requirementTextView = itemView.findViewById(R.id.jobRequirementTextView);
            areaTextView = itemView.findViewById(R.id.jobAreaTextView);
            wageTextView = itemView.findViewById(R.id.jobWageTextView);
            // Initialize other TextViews here
        }
    }

}
