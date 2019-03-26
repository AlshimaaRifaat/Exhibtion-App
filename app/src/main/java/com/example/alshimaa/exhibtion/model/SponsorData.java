package com.example.alshimaa.exhibtion.model;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SponsorData implements Serializable, Parcelable
{

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("img")
    @Expose
    private String img;
    public final static Parcelable.Creator<SponsorData> CREATOR = new Creator<SponsorData>() {


        @SuppressWarnings({
                "unchecked"
        })
        public SponsorData createFromParcel(Parcel in) {
            return new SponsorData(in);
        }

        public SponsorData[] newArray(int size) {
            return (new SponsorData[size]);
        }

    }
            ;
    private final static long serialVersionUID = 1777996230345524358L;

    protected SponsorData(Parcel in) {
        this.id = ((int) in.readValue((int.class.getClassLoader())));
        this.title = ((String) in.readValue((String.class.getClassLoader())));
        this.description = ((String) in.readValue((String.class.getClassLoader())));
        this.img = ((String) in.readValue((String.class.getClassLoader())));
    }

    public SponsorData() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
        dest.writeValue(id);
        dest.writeValue(title);
        dest.writeValue(description);
        dest.writeValue(img);
    }

    public int describeContents() {
        return 0;
    }

}