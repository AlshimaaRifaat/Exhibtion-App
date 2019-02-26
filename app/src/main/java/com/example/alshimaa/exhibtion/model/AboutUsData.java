package com.example.alshimaa.exhibtion.model;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AboutUsData implements  Parcelable
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
    public final static Parcelable.Creator<AboutUsData> CREATOR = new Creator<AboutUsData>() {


        @SuppressWarnings({
                "unchecked"
        })
        public AboutUsData createFromParcel(Parcel in) {
            return new AboutUsData(in);
        }

        public AboutUsData[] newArray(int size) {
            return (new AboutUsData[size]);
        }

    }
            ;
    private final static long serialVersionUID = -5793225288116495528L;

    protected AboutUsData(Parcel in) {
        this.img = ((String) in.readValue((String.class.getClassLoader())));
        this.titEn = ((String) in.readValue((String.class.getClassLoader())));
        this.desEn = ((String) in.readValue((String.class.getClassLoader())));
    }

    public AboutUsData() {
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
