package com.exhibtion.model;

import java.io.Serializable;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HallTwoResponse implements Serializable, Parcelable
{

    @SerializedName("data")
    @Expose
    private List<HallTwoData> data = null;
    @SerializedName("status")
    @Expose
    private boolean status;
    @SerializedName("error")
    @Expose
    private String error;
    public final static Parcelable.Creator<HallTwoResponse> CREATOR = new Creator<HallTwoResponse>() {


        @SuppressWarnings({
                "unchecked"
        })
        public HallTwoResponse createFromParcel(Parcel in) {
            return new HallTwoResponse(in);
        }

        public HallTwoResponse[] newArray(int size) {
            return (new HallTwoResponse[size]);
        }

    }
            ;
    private final static long serialVersionUID = 8706453750017174097L;

    protected HallTwoResponse(Parcel in) {
        in.readList(this.data, (HallTwoData.class.getClassLoader()));
        this.status = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.error = ((String) in.readValue((String.class.getClassLoader())));
    }

    public HallTwoResponse() {
    }

    public List<com.exhibtion.model.HallTwoData> getData() {
        return data;
    }

    public void setData(List<HallTwoData> data) {
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