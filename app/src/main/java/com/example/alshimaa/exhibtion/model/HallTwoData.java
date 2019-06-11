package com.exhibtion.model;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HallTwoData implements  Parcelable
{

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("img")
    @Expose
    private String img;
    public final static Parcelable.Creator<HallTwoData> CREATOR = new Creator<HallTwoData>() {


        @SuppressWarnings({
                "unchecked"
        })
        public HallTwoData createFromParcel(Parcel in) {
            return new HallTwoData(in);
        }

        public HallTwoData[] newArray(int size) {
            return (new HallTwoData[size]);
        }

    }
            ;
    private final static long serialVersionUID = -3438115835303227429L;

    protected HallTwoData(Parcel in) {
        this.id = ((int) in.readValue((int.class.getClassLoader())));
        this.title = ((String) in.readValue((String.class.getClassLoader())));
        this.img = ((String) in.readValue((String.class.getClassLoader())));
    }

    public HallTwoData() {
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(title);
        dest.writeValue(img);
    }

    public int describeContents() {
        return 0;
    }

}
