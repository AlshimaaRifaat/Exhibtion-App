package com.exhibtion.model;

import java.io.Serializable;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.exhibtion.model.HallThreeData;

public class HallThreeResponse implements Serializable, Parcelable
{

    @SerializedName("data")
    @Expose
    private List<HallThreeData> data = null;
    @SerializedName("status")
    @Expose
    private boolean status;
    @SerializedName("error")
    @Expose
    private String error;
    public final static Parcelable.Creator<HallThreeResponse> CREATOR = new Creator<HallThreeResponse>() {


        @SuppressWarnings({
                "unchecked"
        })
        public HallThreeResponse createFromParcel(Parcel in) {
            return new HallThreeResponse(in);
        }

        public HallThreeResponse[] newArray(int size) {
            return (new HallThreeResponse[size]);
        }

    }
            ;
    private final static long serialVersionUID = 847029375158917868L;

    protected HallThreeResponse(Parcel in) {
        in.readList(this.data, (HallThreeData.class.getClassLoader()));
        this.status = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.error = ((String) in.readValue((String.class.getClassLoader())));
    }

    public HallThreeResponse() {
    }

    public List<HallThreeData> getData() {
        return data;
    }

    public void setData(List<HallThreeData> data) {
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
