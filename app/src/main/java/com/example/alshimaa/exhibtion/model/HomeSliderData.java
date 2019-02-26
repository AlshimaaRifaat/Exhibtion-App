package com.example.alshimaa.exhibtion.model;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HomeSliderData implements  Parcelable
{

    @SerializedName("img")
    @Expose
    private String img;
    @SerializedName("tit_ar")
    @Expose
    private String titAr;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("des_ar")
    @Expose
    private String desAr;
    public final static Parcelable.Creator<HomeSliderData> CREATOR = new Creator<HomeSliderData>() {


        @SuppressWarnings({
                "unchecked"
        })
        public HomeSliderData createFromParcel(Parcel in) {
            return new HomeSliderData(in);
        }

        public HomeSliderData[] newArray(int size) {
            return (new HomeSliderData[size]);
        }

    }
            ;
    private final static long serialVersionUID = -7124282826241606875L;

    protected HomeSliderData(Parcel in) {
        this.img = ((String) in.readValue((String.class.getClassLoader())));
        this.titAr = ((String) in.readValue((String.class.getClassLoader())));
        this.date = ((String) in.readValue((String.class.getClassLoader())));
        this.desAr = ((String) in.readValue((String.class.getClassLoader())));
    }

    public HomeSliderData() {
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitAr() {
        return titAr;
    }

    public void setTitAr(String titAr) {
        this.titAr = titAr;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDesAr() {
        return desAr;
    }

    public void setDesAr(String desAr) {
        this.desAr = desAr;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(img);
        dest.writeValue(titAr);
        dest.writeValue(date);
        dest.writeValue(desAr);
    }

    public int describeContents() {
        return 0;
    }

}
