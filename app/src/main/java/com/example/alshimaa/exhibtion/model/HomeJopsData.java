package com.example.alshimaa.exhibtion.model;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HomeJopsData implements Serializable, Parcelable
{

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("img")
    @Expose
    private String img;
    public final static Parcelable.Creator<HomeJopsData> CREATOR = new Creator<HomeJopsData>() {


        @SuppressWarnings({
                "unchecked"
        })
        public HomeJopsData createFromParcel(Parcel in) {
            return new HomeJopsData(in);
        }

        public HomeJopsData[] newArray(int size) {
            return (new HomeJopsData[size]);
        }

    }
            ;
    private final static long serialVersionUID = -4963438926053779052L;

    protected HomeJopsData(Parcel in) {
        this.title = ((String) in.readValue((String.class.getClassLoader())));
        this.email = ((String) in.readValue((String.class.getClassLoader())));
        this.date = ((String) in.readValue((String.class.getClassLoader())));
        this.description = ((String) in.readValue((String.class.getClassLoader())));
        this.img = ((String) in.readValue((String.class.getClassLoader())));
    }

    public HomeJopsData() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(title);
        dest.writeValue(email);
        dest.writeValue(date);
        dest.writeValue(description);
        dest.writeValue(img);
    }

    public int describeContents() {
        return 0;
    }

}