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
import com.exhibtion.model.HomeJopsData;
import com.exhibtion.model.HomeUnderConstructData;
import com.exhibtion.view.DetailsExhibtionUnderConstructView;
import com.exhibtion.view.OnclickIconHomeUnderConstructView;

import java.util.List;

public class HomeJopsAdapter extends RecyclerView.Adapter<HomeJopsAdapter.ViewHolder> {
    Context context;
    List<HomeJopsData> homeJopsDataList;
  /*  OnclickIconHomeUnderConstructView onclickIconHomeUnderConstructView;
    DetailsExhibtionUnderConstructView detailsExhibtionUnderConstructView;*/

    public HomeJopsAdapter(Context context, List<HomeJopsData> homeJopsDataList) {
        this.context = context;
        this.homeJopsDataList = homeJopsDataList;
    }

    /* public  void onClick(OnclickIconHomeUnderConstructView onclickIconHomeUnderConstructView)
        {
            this.onclickIconHomeUnderConstructView=onclickIconHomeUnderConstructView;
        }
        public  void onClickItem(DetailsExhibtionUnderConstructView detailsExhibtionUnderConstructView)
        {
            this.detailsExhibtionUnderConstructView=detailsExhibtionUnderConstructView;
        }*/
    @Override
    public HomeJopsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from( context ).inflate(R.layout.row_home_jops,parent,false);
        return new HomeJopsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeJopsAdapter.ViewHolder holder, final int position) {
        Glide.with( context ).load( "http://electronic-expos.com"
                +homeJopsDataList.get( position ).getImg() ).into(holder.imageView);

        holder.title.setText(homeJopsDataList.get( position ).getTitle());
        holder.desc.setText(homeJopsDataList.get( position ).getDescription());
        holder.email.setText(homeJopsDataList.get( position ).getEmail());
        holder.date.setText(homeJopsDataList.get( position ).getDate());
        // Typeface customFontBold = Typeface.createFromAsset( context.getAssets(), "DroidKufi-Bold.ttf" );

        Typeface customFontRegular = Typeface.createFromAsset( context.getAssets(), "DroidKufi-Regular.ttf" );
        holder.title.setTypeface( customFontRegular );
        holder.desc.setTypeface( customFontRegular );

       /* holder.iconRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomeUnderConstructData homeUnderConstructData=new HomeUnderConstructData();
                homeUnderConstructData.setId(homeUnderConstructDataList.get(position).getId());
                onclickIconHomeUnderConstructView.showOnclickIconHomeUnderConstructDetails(homeUnderConstructData);

            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomeUnderConstructData homeUnderConstructData=new HomeUnderConstructData();
                homeUnderConstructData.setYoutube(homeUnderConstructDataList.get(position).getYoutube());
                homeUnderConstructData.setTitle(homeUnderConstructDataList.get(position).getTitle());
                homeUnderConstructData.setDescription(homeUnderConstructDataList.get(position).getDescription());
                homeUnderConstructData.setAddress(homeUnderConstructDataList.get(position).getAddress());
                homeUnderConstructData.setId(homeUnderConstructDataList.get(position).getId());
                homeUnderConstructData.setIdUser(homeUnderConstructDataList.get(position).getIdUser());
                homeUnderConstructData.setLogo(homeUnderConstructDataList.get(position).getLogo());
                detailsExhibtionUnderConstructView.showDetailsExhibtionUnderConstruct(homeUnderConstructData);
            }
        });
*/
    }

    @Override
    public int getItemCount() {
        return homeJopsDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView title;
        private TextView desc;
        private TextView email;
        private TextView date;
        public ViewHolder(View itemView) {
            super( itemView );
            imageView=itemView.findViewById( R.id.row_home_jops_img);
            title=itemView.findViewById(R.id.row_home_jops_title);
            desc=itemView.findViewById(R.id.row_home_jops_desc);
            email=itemView.findViewById(R.id.row_home_jops_email);
            date=itemView.findViewById(R.id.row_home_jops_date);

            /*videoYoutube=itemView.findViewById(R.id.row_cur_exhibtion_img_video);
            address=itemView.findViewById(R.id.row_cur_exhibtion_address);*/

        }
    }
}

