package com.exhibtion.model;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResultRegisterAsVisitorData implements Serializable, Parcelable
{

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("QRcode")
    @Expose
    private String qRcode;
    @SerializedName("phone")
    @Expose
    private String phone;
    public final static Parcelable.Creator<ResultRegisterAsVisitorData> CREATOR = new Creator<ResultRegisterAsVisitorData>() {


        @SuppressWarnings({
                "unchecked"
        })
        public ResultRegisterAsVisitorData createFromParcel(Parcel in) {
            return new ResultRegisterAsVisitorData(in);
        }

        public ResultRegisterAsVisitorData[] newArray(int size) {
            return (new ResultRegisterAsVisitorData[size]);
        }

    }
            ;
    private final static long serialVersionUID = -6357480691983279966L;

    protected ResultRegisterAsVisitorData(Parcel in) {
        this.title = ((String) in.readValue((String.class.getClassLoader())));
        this.qRcode = ((String) in.readValue((String.class.getClassLoader())));
        this.phone = ((String) in.readValue((String.class.getClassLoader())));
    }

    public ResultRegisterAsVisitorData() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getQRcode() {
        return qRcode;
    }

    public void setQRcode(String qRcode) {
        this.qRcode = qRcode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(title);
        dest.writeValue(qRcode);
        dest.writeValue(phone);
    }

    public int describeContents() {
        return 0;
    }

}
