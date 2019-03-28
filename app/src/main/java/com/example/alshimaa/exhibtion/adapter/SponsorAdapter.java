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
import com.example.alshimaa.exhibtion.model.OrganizersAndServiceProvidersData;
import com.example.alshimaa.exhibtion.model.SponsorData;

import java.util.List;

public class SponsorAdapter extends RecyclerView.Adapter<SponsorAdapter.ViewHolder> {
    Context context;
    //List<OrganizersAndServiceProvidersData> organizersAndServiceProvidersDataList;

    List<SponsorData> sponsorDataList;


    public SponsorAdapter(Context context, List<SponsorData> sponsorDataList) {
        this.context = context;
        this.sponsorDataList = sponsorDataList;
    }

    @Override
    public SponsorAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from( context ).inflate(R.layout.row_sponsor,parent,false);
        return new SponsorAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SponsorAdapter.ViewHolder holder, int position) {
        Glide.with( context ).load( "http://eelectronicexpo.com"
                +sponsorDataList.get( position ).getImg() ).into(holder.imageView);
        holder.title.setText(sponsorDataList.get( position ).getTitle());
        // Typeface customFontBold = Typeface.createFromAsset( context.getAssets(), "DroidKufi-Bold.ttf" );

        Typeface customFontRegular = Typeface.createFromAsset( context.getAssets(), "DroidKufi-Regular.ttf" );
        holder.title.setTypeface( customFontRegular );

    }

    @Override
    public int getItemCount() {
        return sponsorDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView title;

        public ViewHolder(View itemView) {
            super( itemView );
            imageView=itemView.findViewById( R.id.row_sponsor_circle_img);
            title=itemView.findViewById(R.id.row_sponsor_text_title);

        }
    }
}

