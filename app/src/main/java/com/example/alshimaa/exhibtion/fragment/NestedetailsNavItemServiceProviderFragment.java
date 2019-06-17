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
public class NestedetailsNavItemServiceProviderFragment extends Fragment {
   // nested_details_nav_item_service_prov_img
    ImageView imageView;
    TextView title,description;
String Img,Title,Description;
    public NestedetailsNavItemServiceProviderFragment() {
        // Required empty public constructor
    }

View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_nestedetails_nav_item_service, container, false);
        init();
        Bundle bundle=this.getArguments();
        if (bundle!=null) {
            Img = bundle.getString("img");
            Title = bundle.getString("title");
            Description = bundle.getString("description");

            title.setText(Title);
            description.setText(Description);
            Glide.with(getContext()).load( "http://electronic-expos.com"
                    +Img).into(imageView);

        }
        return view;
    }

    private void init() {
        imageView=view.findViewById(R.id.nested_details_nav_item_service_prov_img);
        title=view.findViewById(R.id.nested_details_nav_item_service_prov_title);
        description=view.findViewById(R.id.nested_details_nav_item_service_prov_desc);
    }

}
