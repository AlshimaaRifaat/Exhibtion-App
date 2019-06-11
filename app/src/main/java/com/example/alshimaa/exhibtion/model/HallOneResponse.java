package com.exhibtion.model;

import java.io.Serializable;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HallOneResponse implements Serializable, Parcelable
{

    @SerializedName("data")
    @Expose
    private List<HallOneData> data = null;
    @SerializedName("status")
    @Expose
    private boolean status;
    @SerializedName("error")
    @Expose
    private String error;
    public final static Parcelable.Creator<HallOneResponse> CREATOR = new Creator<HallOneResponse>() {


        @SuppressWarnings({
                "unchecked"
        })
        public HallOneResponse createFromParcel(Parcel in) {
            return new HallOneResponse(in);
        }

        public HallOneResponse[] newArray(int size) {
            return (new HallOneResponse[size]);
        }

    }
            ;
    private final static long serialVersionUID = 8292355474591717588L;

    protected HallOneResponse(Parcel in) {
        in.readList(this.data, (HallOneData.class.getClassLoader()));
        this.status = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.error = ((String) in.readValue((String.class.getClassLoader())));
    }

    public HallOneResponse() {
    }

    public List<com.exhibtion.model.HallOneData> getData() {
        return data;
    }

    public void setData(List<HallOneData> data) {
        this.data = data;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(data);
        dest.writeValue(status);
        dest.writeValue(error);
    }

    public int describeContents() {
        return 0;
    }

}
