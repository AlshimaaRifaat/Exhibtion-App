package com.exhibtion.adapter;

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
import com.exhibtion.R;
import com.exhibtion.model.CurrentExhibtionData;
import com.exhibtion.model.ResultRegisterAsVisitorData;
import com.exhibtion.view.DetailsExhibtionView;

import java.util.List;

public class ResultRegisterAsVisitorAdapter extends RecyclerView.Adapter<ResultRegisterAsVisitorAdapter.ViewHolder> {
    Context context;
    List<ResultRegisterAsVisitorData> resultRegisterAsVisitorDataList;

   /* DetailsExhibtionView detailsExhibtionView;*/
    /*public CurrentExhibtionAdapter(Context context, List<CurrentExhibtionData> currentExhibtionDataList) {
        this.context = context;
        this.currentExhibtionDataList = currentExhibtionDataList;
    }*/

    public ResultRegisterAsVisitorAdapter(Context context, List<ResultRegisterAsVisitorData> resultRegisterAsVisitorDataList) {
        this.context = context;
        this.resultRegisterAsVisitorDataList = resultRegisterAsVisitorDataList;
    }

    /*public  void onClick(DetailsExhibtionView detailsExhibtionView)
    {
        this.detailsExhibtionView=detailsExhibtionView;
    }*/
    @Override
    public ResultRegisterAsVisitorAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from( context ).inflate(R.layout.row_result_register_as_visitor,parent,false);
        return new ResultRegisterAsVisitorAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ResultRegisterAsVisitorAdapter.ViewHolder holder, final int position) {
        Glide.with( context ).load( "http://electronic-expos.com"
                +resultRegisterAsVisitorDataList.get( position ).getQRcode() ).into(holder.imageView);
        holder.title.setText(resultRegisterAsVisitorDataList.get( position ).getTitle());
       /* holder.describtion.setText(currentExhibtionDataList.get( position ).getDescription());*/
        // Typeface customFontBold = Typeface.createFromAsset( context.getAssets(), "DroidKufi-Bold.ttf" );
        holder.phone.setText(resultRegisterAsVisitorDataList.get( position ).getPhone());

        Typeface customFontRegular = Typeface.createFromAsset( context.getAssets(), "DroidKufi-Regular.ttf" );
        holder.title.setTypeface( customFontRegular );
        /*holder.describtion.setTypeface( customFontRegular );*/

        holder.phone.setTypeface( customFontRegular );

    /*    holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CurrentExhibtionData currentExhibtionData=new CurrentExhibtionData();
                currentExhibtionData.setYoutube(currentExhibtionDataList.get(position).getYoutube());
                currentExhibtionData.setTitle(currentExhibtionDataList.get(position).getTitle());
                currentExhibtionData.setDescription(currentExhibtionDataList.get(position).getDescription());
                currentExhibtionData.setAddress(currentExhibtionDataList.get(position).getAddress());
                currentExhibtionData.setId(currentExhibtionDataList.get(position).getId());
                currentExhibtionData.setIdUser(currentExhibtionDataList.get(position).getIdUser());
                currentExhibtionData.setLogo(currentExhibtionDataList.get(position).getLogo());
                detailsExhibtionView.showExhibtionDetails(currentExhibtionData);
            }
        });*/

    }

    @Override
    public int getItemCount() {
        return resultRegisterAsVisitorDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView title;
        private TextView phone;
        public ViewHolder(View itemView) {
            super( itemView );
            imageView=itemView.findViewById( R.id.row_cur_exhibtion_img);
            title=itemView.findViewById(R.id.row_cur_exhibtion_title);

            phone=itemView.findViewById(R.id.row_cur_exhibtion_phone);
        }
    }
}
