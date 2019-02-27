package com.example.alshimaa.exhibtion.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.alshimaa.exhibtion.Language;
import com.example.alshimaa.exhibtion.R;
import com.example.alshimaa.exhibtion.model.AboutUsData;
import com.example.alshimaa.exhibtion.presenter.AboutUsPresenter;
import com.example.alshimaa.exhibtion.view.AboutUsView;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class AboutUsFragment extends Fragment implements AboutUsView{
    ImageView imageView;
    TextView description;
    AboutUsPresenter aboutUsPresenter;
    public AboutUsFragment() {
        // Required empty public constructor
    }

View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_about_us, container, false);
        init();
        AboutUs();
        return view;
    }

    private void AboutUs() {
        aboutUsPresenter=new AboutUsPresenter(getContext(),this);
        if (Language.isRTL()) {
            aboutUsPresenter.getAboutUsResult("ar");
        }else
        {
            aboutUsPresenter.getAboutUsResult("en");
        }
    }

    private void init() {
            imageView=view.findViewById(R.id.about_us_img);
            description=view.findViewById(R.id.about_us_description);


    }

    @Override
    public void showAboutUsResult(List<AboutUsData> aboutUsDataList) {
        Glide.with(getContext()).load("http://yallahshare.com"+aboutUsDataList.get(0).getImg())
                .into(imageView);
        description.setText(aboutUsDataList.get(0).getDesEn());
    }

    @Override
    public void showError() {

    }
}
