package com.example.alshimaa.exhibtion.model;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HomeServiceProviderData implements  Parcelable
{

    @SerializedName("img")
    @Expose
    private String img;
    @SerializedName("tit_en")
    @Expose
    private String titEn;
    @SerializedName("des_en")
    @Expose
    private String desEn;
    public final static Parcelable.Creator<HomeServiceProviderData> CREATOR = new Creator<HomeServiceProviderData>() {


        @SuppressWarnings({
                "unchecked"
        })
        public HomeServiceProviderData createFromParcel(Parcel in) {
            return new HomeServiceProviderData(in);
        }

        public HomeServiceProviderData[] newArray(int size) {
            return (new HomeServiceProviderData[size]);
        }

    }
            ;
    private final static long serialVersionUID = -5793225288116495528L;

    protected HomeServiceProviderData(Parcel in) {
        this.img = ((String) in.readValue((String.class.getClassLoader())));
        this.titEn = ((String) in.readValue((String.class.getClassLoader())));
        this.desEn = ((String) in.readValue((String.class.getClassLoader())));
    }

    public HomeServiceProviderData() {
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitEn() {
        return titEn;
    }

    public void setTitEn(String titEn) {
        this.titEn = titEn;
    }

    public String getDesEn() {
        return desEn;
    }

    public void setDesEn(String desEn) {
        this.desEn = desEn;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(img);
        dest.writeValue(titEn);
        dest.writeValue(desEn);
    }

    public int describeContents() {
        return 0;
    }

}
