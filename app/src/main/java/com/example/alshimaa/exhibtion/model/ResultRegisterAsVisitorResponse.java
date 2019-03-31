package com.example.alshimaa.exhibtion.model;

import java.io.Serializable;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResultRegisterAsVisitorResponse implements Serializable, Parcelable
{

    @SerializedName("data")
    @Expose
    private List<ResultRegisterAsVisitorData> data = null;
    @SerializedName("status")
    @Expose
    private boolean status;
    @SerializedName("error")
    @Expose
    private String error;
    public final static Parcelable.Creator<ResultRegisterAsVisitorResponse> CREATOR = new Creator<ResultRegisterAsVisitorResponse>() {


        @SuppressWarnings({
                "unchecked"
        })
        public ResultRegisterAsVisitorResponse createFromParcel(Parcel in) {
            return new ResultRegisterAsVisitorResponse(in);
        }

        public ResultRegisterAsVisitorResponse[] newArray(int size) {
            return (new ResultRegisterAsVisitorResponse[size]);
        }

    }
            ;
    private final static long serialVersionUID = 724566371082843291L;

    protected ResultRegisterAsVisitorResponse(Parcel in) {
        in.readList(this.data, (ResultRegisterAsVisitorData.class.getClassLoader()));
        this.status = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.error = ((String) in.readValue((String.class.getClassLoader())));
    }

    public ResultRegisterAsVisitorResponse() {
    }

    public List<ResultRegisterAsVisitorData> getData() {
        return data;
    }

    public void setData(List<ResultRegisterAsVisitorData> data) {
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
