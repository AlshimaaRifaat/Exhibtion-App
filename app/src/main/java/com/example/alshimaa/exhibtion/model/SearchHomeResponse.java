package com.exhibtion.model;

import java.io.Serializable;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SearchHomeResponse /*implements Serializable, Parcelable*/
{

   /* @SerializedName("data")
    @Expose
    private List<SearchHomeData> data = null;
    @SerializedName("status")
    @Expose
    private boolean status;
    @SerializedName("error")
    @Expose
    private String error;
    public final static Parcelable.Creator<SearchHomeResponse> CREATOR = new Creator<SearchHomeResponse>() {


        @SuppressWarnings({
                "unchecked"
        })
        public SearchHomeResponse createFromParcel(Parcel in) {
            return new SearchHomeResponse(in);
        }

        public SearchHomeResponse[] newArray(int size) {
            return (new SearchHomeResponse[size]);
        }

    }
            ;
    private final static long serialVersionUID = -4222406994533783444L;

    protected SearchHomeResponse(Parcel in) {
        in.readList(this.data, (SearchHomeData.class.getClassLoader()));
        this.status = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.error = ((String) in.readValue((String.class.getClassLoader())));
    }

    public SearchHomeResponse() {
    }

    public List<SearchHomeData> getData() {
        return data;
    }

    public void setData(List<SearchHomeData> data) {
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
    }*/

}
