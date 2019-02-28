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
import com.example.alshimaa.exhibtion.model.HomeServiceProviderData;

import java.util.List;

public class CurrentExhibtionAdapter extends RecyclerView.Adapter<CurrentExhibtionAdapter.ViewHolder> {
    Context context;
    List<CurrentExhibtionData> currentExhibtionDataList;

    public CurrentExhibtionAdapter(Context context, List<CurrentExhibtionData> currentExhibtionDataList) {
        this.context = context;
        this.currentExhibtionDataList = currentExhibtionDataList;
    }

    @Override
    public CurrentExhibtionAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from( context ).inflate(R.layout.row_current_exhibtion,parent,false);
        return new CurrentExhibtionAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CurrentExhibtionAdapter.ViewHolder holder, int position) {
        Glide.with( context ).load( "http://yallahshare.com"
                +currentExhibtionDataList.get( position ).getImg() ).into(holder.imageView);
        holder.title.setText(currentExhibtionDataList.get( position ).getTitle());
        holder.describtion.setText(currentExhibtionDataList.get( position ).getDescription());
        // Typeface customFontBold = Typeface.createFromAsset( context.getAssets(), "DroidKufi-Bold.ttf" );
        holder.address.setText(currentExhibtionDataList.get( position ).getAddress());
        Typeface customFontRegular = Typeface.createFromAsset( context.getAssets(), "DroidKufi-Regular.ttf" );
        holder.title.setTypeface( customFontRegular );
        holder.describtion.setTypeface( customFontRegular );

        holder.address.setTypeface( customFontRegular );

        Glide.with( context ).load( "http://yallahshare.com"
                +currentExhibtionDataList.get( position ).getImg() ).into(holder.videoYoutube);

    }

    @Override
    public int getItemCount() {
        return currentExhibtionDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView title;
        private TextView describtion;
        private ImageView videoYoutube;
        private TextView address;
        public ViewHolder(View itemView) {
            super( itemView );
            imageView=itemView.findViewById( R.id.row_cur_exhibtion_img);
            title=itemView.findViewById(R.id.row_cur_exhibtion_title);
            describtion=itemView.findViewById(R.id.row_cur_exhibtion_desc);

            videoYoutube=itemView.findViewById(R.id.row_cur_exhibtion_detail_img_video);
            address=itemView.findViewById(R.id.row_cur_exhibtion_detail_address);
        }
    }
}
