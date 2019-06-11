package com.example.alshimaa.exhibtion.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.exhibtion.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailsHomeJopsFragment extends Fragment {

    public  String Img,Title,Description,Email,Date;
    TextView title,description,email,date,textToolbar;
    ImageView img;
    public DetailsHomeJopsFragment() {
        // Required empty public constructor
    }

View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_details_home_jops, container, false);
        init();
        Bundle bundle=this.getArguments();
        if (bundle!=null) {
            Img = bundle.getString("jop_img");
            Title = bundle.getString("jop_title");
            Description = bundle.getString("jop_description");
            Email = bundle.getString("jop_email");
            Date = bundle.getString("jop_date");

            // FromCur=bundle.getString("registerFromCurExhib");
            //  Toast.makeText(getContext(), Under, Toast.LENGTH_SHORT).show();

            //RegisterFromCurExhib = bundle.getString("registerFromCurExhib");
            // Visitor=bundle.getString("visitor");
            //"visitor","no_from_under"
        }

        Glide.with(getContext()).load("http://electronic-expos.com"+Img).into(img);
        title.setText(Title);
        description.setText(Description);
        email.setText(Email);
        date.setText(Date);
        textToolbar.setText(Title);
        return view;
    }

    private void init() {

        img=view.findViewById( R.id.img );
        title=view.findViewById( R.id.T_title );
        description=view.findViewById( R.id.T_description );
        email=view.findViewById( R.id.T_email );
        date=view.findViewById( R.id.T_date );
        textToolbar=view.findViewById( R.id.T_toolbar );
    }

}
