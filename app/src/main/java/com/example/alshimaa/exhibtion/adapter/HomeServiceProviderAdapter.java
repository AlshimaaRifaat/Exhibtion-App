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
import com.example.alshimaa.exhibtion.model.HomeServiceProviderData;

import java.util.List;

public class HomeServiceProviderAdapter extends RecyclerView.Adapter<HomeServiceProviderAdapter.ViewHolder> {
        Context context;
        List<HomeServiceProviderData> homeServiceProviderDataList;

    public HomeServiceProviderAdapter(Context context, List<HomeServiceProviderData> homeServiceProviderDataList) {
        this.context = context;
        this.homeServiceProviderDataList = homeServiceProviderDataList;
    }

    @Override
   public HomeServiceProviderAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from( context ).inflate(R.layout.row_home_service_provider,parent,false);
        return new HomeServiceProviderAdapter.ViewHolder(view);
        }

@Override
public void onBindViewHolder(@NonNull HomeServiceProviderAdapter.ViewHolder holder, int position) {
        Glide.with( context ).load( "http://yallahshare.com"
        +homeServiceProviderDataList.get( position ).getImg() ).into(holder.imageView);
        holder.title.setText(homeServiceProviderDataList.get( position ).getTitEn());
        // Typeface customFontBold = Typeface.createFromAsset( context.getAssets(), "DroidKufi-Bold.ttf" );

        Typeface customFontRegular = Typeface.createFromAsset( context.getAssets(), "DroidKufi-Regular.ttf" );
        holder.title.setTypeface( customFontRegular );
        }

@Override
public int getItemCount() {
        return homeServiceProviderDataList.size();
        }

public class ViewHolder extends RecyclerView.ViewHolder{
    private ImageView imageView;
    private TextView title;
    public ViewHolder(View itemView) {
        super( itemView );
        imageView=itemView.findViewById( R.id.row_home_service_provider_img);
        title=itemView.findViewById(R.id.row_home_service_provider_title);

    }
}
}
