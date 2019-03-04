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
import com.example.alshimaa.exhibtion.model.ExhibtorsData;
import com.example.alshimaa.exhibtion.view.DetailsExhibtionView;

import java.util.List;

public class ExhibtorsAdapter extends RecyclerView.Adapter<ExhibtorsAdapter.ViewHolder> {
    Context context;
    List<ExhibtorsData> exhibtorsDataList;

    //DetailsExhibtionView detailsExhibtionView;


    public ExhibtorsAdapter(Context context, List<ExhibtorsData> exhibtorsDataList) {
        this.context = context;
        this.exhibtorsDataList = exhibtorsDataList;
    }

   /* public  void onClick(DetailsExhibtionView detailsExhibtionView)
    {
        this.detailsExhibtionView=detailsExhibtionView;
    }*/
    @Override
    public ExhibtorsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from( context ).inflate(R.layout.row_exhibtors,parent,false);
        return new ExhibtorsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExhibtorsAdapter.ViewHolder holder, final int position) {
        Glide.with( context ).load( "http://yallahshare.com"
                +exhibtorsDataList.get( position ).getImg2() ).into(holder.imageView);
        holder.title.setText(exhibtorsDataList.get( position ).getName());
       // holder.describtion.setText(currentExhibtionDataList.get( position ).getDescription());
        // Typeface customFontBold = Typeface.createFromAsset( context.getAssets(), "DroidKufi-Bold.ttf" );
        holder.address.setText(exhibtorsDataList.get( position ).getAddress());

        Typeface customFontRegular = Typeface.createFromAsset( context.getAssets(), "DroidKufi-Regular.ttf" );
        holder.title.setTypeface( customFontRegular );
       // holder.describtion.setTypeface( customFontRegular );

        holder.address.setTypeface( customFontRegular );

       /* holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CurrentExhibtionData currentExhibtionData=new CurrentExhibtionData();
                currentExhibtionData.setYoutube(currentExhibtionDataList.get(position).getYoutube());
                currentExhibtionData.setTitle(currentExhibtionDataList.get(position).getTitle());
                currentExhibtionData.setDescription(currentExhibtionDataList.get(position).getDescription());
                currentExhibtionData.setAddress(currentExhibtionDataList.get(position).getAddress());
                currentExhibtionData.setId(currentExhibtionDataList.get(position).getId());
                detailsExhibtionView.showExhibtionDetails(currentExhibtionData);
            }
        });*/

    }

    @Override
    public int getItemCount() {
        return exhibtorsDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView title;
        /*private TextView describtion;
        private ImageView videoYoutube;*/
        private TextView address;
        public ViewHolder(View itemView) {
            super( itemView );
            imageView=itemView.findViewById( R.id.row_exhibtor_img);
            title=itemView.findViewById(R.id.row_exhibtor_title);
            /*describtion=itemView.findViewById(R.id.row_cur_exhibtion_desc);

            videoYoutube=itemView.findViewById(R.id.row_cur_exhibtion_img_video);*/
            address=itemView.findViewById(R.id.row_exhibtor_address);
        }
    }
}
