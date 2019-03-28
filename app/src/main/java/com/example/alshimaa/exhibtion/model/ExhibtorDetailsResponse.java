package com.example.alshimaa.exhibtion.model;

import java.io.Serializable;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ExhibtorDetailsResponse implements Serializable, Parcelable
{

    @SerializedName("data")
    @Expose
    private List<ExhibtorDetailsData> data = null;
    @SerializedName("status")
    @Expose
    private boolean status;
    @SerializedName("error")
    @Expose
    private String error;
    public final static Parcelable.Creator<ExhibtorDetailsResponse> CREATOR = new Creator<ExhibtorDetailsResponse>() {


        @SuppressWarnings({
                "unchecked"
        })
        public ExhibtorDetailsResponse createFromParcel(Parcel in) {
            return new ExhibtorDetailsResponse(in);
        }

        public ExhibtorDetailsResponse[] newArray(int size) {
            return (new ExhibtorDetailsResponse[size]);
        }

    }
            ;
    private final static long serialVersionUID = 9110617843148503905L;

    protected ExhibtorDetailsResponse(Parcel in) {
        in.readList(this.data, (ExhibtorDetailsData.class.getClassLoader()));
        this.status = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.error = ((String) in.readValue((String.class.getClassLoader())));
    }

    public ExhibtorDetailsResponse() {
    }

    public List<ExhibtorDetailsData> getData() {
        return data;
    }

    public void setData(List<ExhibtorDetailsData> data) {
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