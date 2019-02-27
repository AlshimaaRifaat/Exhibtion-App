package com.example.alshimaa.exhibtion.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.alshimaa.exhibtion.R;
import com.example.alshimaa.exhibtion.model.CurrentExhibtionData;
import com.example.alshimaa.exhibtion.model.PreviousExhibtionData;

import java.util.List;

public class PreviousExhibtionAdapter extends RecyclerView.Adapter<PreviousExhibtionAdapter.ViewHolder> {
    Context context;
    List<PreviousExhibtionData> previousExhibtionDataList;

    public PreviousExhibtionAdapter(Context context, List<PreviousExhibtionData> previousExhibtionDataList) {
        this.context = context;
        this.previousExhibtionDataList = previousExhibtionDataList;
    }

    @Override
    public PreviousExhibtionAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from( context ).inflate(R.layout.row_previous_exhibtion,parent,false);
        return new PreviousExhibtionAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PreviousExhibtionAdapter.ViewHolder holder, int position) {
        Glide.with( context ).load( "http://yallahshare.com"
                +previousExhibtionDataList.get( position ).getImg() ).into(holder.imageView);
        holder.title.setText(previousExhibtionDataList.get( position ).getTitle());
        holder.describtion.setText(previousExhibtionDataList.get( position ).getDescription());
        holder.endDate.setText(previousExhibtionDataList.get( position ).getEndDate());
        // Typeface customFontBold = Typeface.createFromAsset( context.getAssets(), "DroidKufi-Bold.ttf" );

        Typeface customFontRegular = Typeface.createFromAsset( context.getAssets(), "DroidKufi-Regular.ttf" );
        holder.title.setTypeface( customFontRegular );
        holder.describtion.setTypeface( customFontRegular );
        holder.endDate.setTypeface(customFontRegular);
    }

    @Override
    public int getItemCount() {
        return previousExhibtionDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView title;
        private TextView describtion;
        private TextView endDate;
        public ViewHolder(View itemView) {
            super( itemView );
            imageView=itemView.findViewById( R.id.row_prev_exhibtion_img);
            title=itemView.findViewById(R.id.row_prev_exhibtion_title);
            describtion=itemView.findViewById(R.id.row_prev_exhibtion_desc);
            endDate=itemView.findViewById(R.id.row_prev_exhibtion_end_date);
        }
    }
}
