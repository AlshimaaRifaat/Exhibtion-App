package com.example.alshimaa.exhibtion.model;

import java.io.Serializable;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HallFourResponse implements Serializable, Parcelable
{

    @SerializedName("data")
    @Expose
    private List<HallFourData> data = null;
    @SerializedName("status")
    @Expose
    private boolean status;
    @SerializedName("error")
    @Expose
    private String error;
    public final static Parcelable.Creator<HallFourResponse> CREATOR = new Creator<HallFourResponse>() {


        @SuppressWarnings({
                "unchecked"
        })
        public HallFourResponse createFromParcel(Parcel in) {
            return new HallFourResponse(in);
        }

        public HallFourResponse[] newArray(int size) {
            return (new HallFourResponse[size]);
        }

    }
            ;
    private final static long serialVersionUID = 6387678217558533339L;

    protected HallFourResponse(Parcel in) {
        in.readList(this.data, (HallFourData.class.getClassLoader()));
        this.status = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.error = ((String) in.readValue((String.class.getClassLoader())));
    }

    public HallFourResponse() {
    }

    public List<HallFourData> getData() {
        return data;
    }

    public void setData(List<HallFourData> data) {
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
