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
import com.example.exhibtion.model.ExhibtionDiagramData;
import com.exhibtion.R;

import java.util.List;

public class ExhibtionDiagramAdapter  extends RecyclerView.Adapter<ExhibtionDiagramAdapter.ViewHolder> {
    Context context;
    List<ExhibtionDiagramData> exhibtionDiagramDataList;

    //DetailsExhibtionView detailsExhibtionView;
   /* public CurrentExhibtionAdapter(Context context, List<CurrentExhibtionData> currentExhibtionDataList) {
        this.context = context;
        this.currentExhibtionDataList = currentExhibtionDataList;
    }*/

    public ExhibtionDiagramAdapter(Context context, List<ExhibtionDiagramData> exhibtionDiagramDataList) {
        this.context = context;
        this.exhibtionDiagramDataList = exhibtionDiagramDataList;
    }

    /*
                public  void onClick(DetailsExhibtionView detailsExhibtionView)
                {
                    this.detailsExhibtionView=detailsExhibtionView;
                }*/
    @Override
    public ExhibtionDiagramAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from( context ).inflate(R.layout.row_exhibtion_diagram,parent,false);
        return new com.exhibtion.adapter.ExhibtionDiagramAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExhibtionDiagramAdapter.ViewHolder holder, final int position) {
        Glide.with( context ).load( "http://electronic-expos.com"
                +exhibtionDiagramDataList.get( position ).getImg() ).into(holder.imageView);



        /* holder.describtion.setText(currentExhibtionDataList.get( position ).getDescription());*/
        // Typeface customFontBold = Typeface.createFromAsset( context.getAssets(), "DroidKufi-Bold.ttf" );
        /*  holder.address.setText(currentExhibtionDataList.get( position ).getAddress());*/





      /*  holder.describtion.setTypeface( customFontRegular );

        holder.address.setTypeface( customFontRegular );

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CurrentExhibtionData currentExhibtionData=new CurrentExhibtionData();
                currentExhibtionData.setYoutube(currentExhibtionDataList.get(position).getYoutube());
                currentExhibtionData.setTitle(currentExhibtionDataList.get(position).getTitle());
                currentExhibtionData.setDescription(currentExhibtionDataList.get(position).getDescription());
                currentExhibtionData.setAddress(currentExhibtionDataList.get(position).getAddress());
                currentExhibtionData.setId(currentExhibtionDataList.get(position).getId());
                currentExhibtionData.setIdUser(currentExhibtionDataList.get(position).getIdUser());
                detailsExhibtionView.showExhibtionDetails(currentExhibtionData);
            }
        });*/

    }

    @Override
    public int getItemCount() {
        return exhibtionDiagramDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView imageView;

        /*  private TextView describtion;
          private ImageView videoYoutube;
          private TextView address;*/
        public ViewHolder(View itemView) {
            super( itemView );
            imageView=itemView.findViewById( R.id.row_exhibtion_diagram_img);

         /*   describtion=itemView.findViewById(R.id.row_cur_exhibtion_desc);
            videoYoutube=itemView.findViewById(R.id.row_cur_exhibtion_img_video);
            address=itemView.findViewById(R.id.row_cur_exhibtion_address);*/
        }
    }
}

