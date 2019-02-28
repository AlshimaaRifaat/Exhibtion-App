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
import com.example.alshimaa.exhibtion.model.HomeUnderConstructData;
import com.example.alshimaa.exhibtion.model.PreviousExhibtionData;

import java.util.List;

public class HomeUnderConstructAdapter extends RecyclerView.Adapter<HomeUnderConstructAdapter.ViewHolder> {
    Context context;
    List<HomeUnderConstructData> homeUnderConstructDataList;

    public HomeUnderConstructAdapter(Context context, List<HomeUnderConstructData> homeUnderConstructDataList) {
        this.context = context;
        this.homeUnderConstructDataList = homeUnderConstructDataList;
    }

    @Override
    public HomeUnderConstructAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from( context ).inflate(R.layout.row_home_exhibitions_under_construct,parent,false);
        return new HomeUnderConstructAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeUnderConstructAdapter.ViewHolder holder, int position) {
        Glide.with( context ).load( "http://yallahshare.com"
                +homeUnderConstructDataList.get( position ).getImg() ).into(holder.imageView);
        holder.title.setText(homeUnderConstructDataList.get( position ).getTitle());
        // Typeface customFontBold = Typeface.createFromAsset( context.getAssets(), "DroidKufi-Bold.ttf" );

        Typeface customFontRegular = Typeface.createFromAsset( context.getAssets(), "DroidKufi-Regular.ttf" );
        holder.title.setTypeface( customFontRegular );

    }

    @Override
    public int getItemCount() {
        return homeUnderConstructDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView title;

        public ViewHolder(View itemView) {
            super( itemView );
            imageView=itemView.findViewById( R.id.row_home_exhib_under_construct_img);
            title=itemView.findViewById(R.id.row_home_exhib_under_construct_title);

        }
    }
}
