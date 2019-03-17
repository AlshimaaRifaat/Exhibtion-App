package com.example.alshimaa.exhibtion.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.alshimaa.exhibtion.R;
import com.example.alshimaa.exhibtion.model.PreviousExhibtionData;
import com.example.alshimaa.exhibtion.model.PuthesData;
import com.example.alshimaa.exhibtion.view.DetailsPreviousExhibtion;

import java.util.List;

public class PuthesAdapter extends RecyclerView.Adapter<PuthesAdapter.ViewHolder> {
    Context context;
    List<PuthesData> puthesDataList;

   // DetailsPreviousExhibtion detailsPreviousExhibtion;

    public PuthesAdapter(Context context, List<PuthesData> puthesDataList) {
        this.context = context;
        this.puthesDataList = puthesDataList;
    }

   /* public void onClick(DetailsPreviousExhibtion detailsPreviousExhibtion)
    {
        this.detailsPreviousExhibtion=detailsPreviousExhibtion;
    }*/
    @Override
    public PuthesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from( context ).inflate(R.layout.row_pollutant,parent,false);
        return new PuthesAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PuthesAdapter.ViewHolder holder, final int position) {

        holder.number.setText(puthesDataList.get( position ).getNumber()+"بوثة");
        holder.area.setText(puthesDataList.get( position ).getWidth()+" * "+puthesDataList.get(position).getHeight());
        holder.price.setText(" ريال "+puthesDataList.get( position ).getPrice());


        Typeface customFontRegular = Typeface.createFromAsset( context.getAssets(), "DroidKufi-Regular.ttf" );
        holder.number.setTypeface( customFontRegular );
        holder.area.setTypeface( customFontRegular );
        holder.price.setTypeface(customFontRegular);

       /* holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PreviousExhibtionData previousExhibtionData=new PreviousExhibtionData();
                previousExhibtionData.setYoutube(previousExhibtionDataList.get(position).getYoutube());
                previousExhibtionData.setTitle(previousExhibtionDataList.get(position).getTitle());
                previousExhibtionData.setDescription(previousExhibtionDataList.get(position).getDescription());
                previousExhibtionData.setAddress(previousExhibtionDataList.get(position).getAddress());
                previousExhibtionData.setId(previousExhibtionDataList.get(position).getId());
                previousExhibtionData.setIdUser(previousExhibtionDataList.get(position).getIdUser());
                previousExhibtionData.setLogo(previousExhibtionDataList.get(position).getLogo());
                detailsPreviousExhibtion.showExhibtionDetails(previousExhibtionData);
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return puthesDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private CheckBox checkBox;
        private TextView number;
        private TextView area;
        private TextView price;

        public ViewHolder(View itemView) {
            super( itemView );
            checkBox=itemView.findViewById(R.id.row_pollutant_checkbox);
            number=itemView.findViewById(R.id.row_pollutant_text_number);
            area=itemView.findViewById(R.id.row_pollutant_text_area);
            price=itemView.findViewById(R.id.row_pollutant_text_price);

        }
    }
}
