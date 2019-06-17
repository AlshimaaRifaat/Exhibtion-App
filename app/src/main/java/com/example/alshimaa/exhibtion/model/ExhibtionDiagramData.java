package com.example.exhibtion.model;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ExhibtionDiagramData implements Serializable, Parcelable
{

    @SerializedName("img")
    @Expose
    private String img;
    public final static Parcelable.Creator<ExhibtionDiagramData> CREATOR = new Creator<ExhibtionDiagramData>() {


        @SuppressWarnings({
                "unchecked"
        })
        public ExhibtionDiagramData createFromParcel(Parcel in) {
            return new ExhibtionDiagramData(in);
        }

        public ExhibtionDiagramData[] newArray(int size) {
            return (new ExhibtionDiagramData[size]);
        }

    }
            ;
    private final static long serialVersionUID = -3570612628768821546L;

    protected ExhibtionDiagramData(Parcel in) {
        this.img = ((String) in.readValue((String.class.getClassLoader())));
    }

    public ExhibtionDiagramData() {
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(img);
    }

    public int describeContents() {
        return 0;
    }

}
