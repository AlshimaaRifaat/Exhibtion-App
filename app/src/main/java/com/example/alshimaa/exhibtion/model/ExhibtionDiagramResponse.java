package com.example.exhibtion.model;

import java.io.Serializable;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

import com.example.exhibtion.model.ExhibtionDiagramData;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ExhibtionDiagramResponse implements Serializable, Parcelable
{

    @SerializedName("data")
    @Expose
    private List<ExhibtionDiagramData> data = null;
    @SerializedName("status")
    @Expose
    private boolean status;
    @SerializedName("error")
    @Expose
    private String error;
    public final static Parcelable.Creator<ExhibtionDiagramResponse> CREATOR = new Creator<ExhibtionDiagramResponse>() {


        @SuppressWarnings({
                "unchecked"
        })
        public ExhibtionDiagramResponse createFromParcel(Parcel in) {
            return new ExhibtionDiagramResponse(in);
        }

        public ExhibtionDiagramResponse[] newArray(int size) {
            return (new ExhibtionDiagramResponse[size]);
        }

    }
            ;
    private final static long serialVersionUID = 5996408732863001577L;

    protected ExhibtionDiagramResponse(Parcel in) {
        in.readList(this.data, (ExhibtionDiagramData.class.getClassLoader()));
        this.status = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.error = ((String) in.readValue((String.class.getClassLoader())));
    }

    public ExhibtionDiagramResponse() {
    }

    public List<ExhibtionDiagramData> getData() {
        return data;
    }

    public void setData(List<ExhibtionDiagramData> data) {
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
