package com.exhibtion.model;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HomeUnderConstructData implements Serializable, Parcelable
{

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("id_user")
    @Expose
    private String idUser;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("link360")
    @Expose
    private String link360;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("youtube")
    @Expose
    private String youtube;
    @SerializedName("img")
    @Expose
    private String img;
    @SerializedName("logo")
    @Expose
    private String logo;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("start_date")
    @Expose
    private String startDate;
    @SerializedName("end_date")
    @Expose
    private String endDate;
    public final static Parcelable.Creator<HomeUnderConstructData> CREATOR = new Creator<HomeUnderConstructData>() {


        @SuppressWarnings({
                "unchecked"
        })
        public HomeUnderConstructData createFromParcel(Parcel in) {
            return new HomeUnderConstructData(in);
        }

        public HomeUnderConstructData[] newArray(int size) {
            return (new HomeUnderConstructData[size]);
        }

    }
            ;
    private final static long serialVersionUID = 1387333795482908375L;

    protected HomeUnderConstructData(Parcel in) {
        this.id = ((int) in.readValue((int.class.getClassLoader())));
        this.idUser = ((String) in.readValue((String.class.getClassLoader())));
        this.title = ((String) in.readValue((String.class.getClassLoader())));
        this.link360 = ((String) in.readValue((String.class.getClassLoader())));
        this.description = ((String) in.readValue((String.class.getClassLoader())));
        this.youtube = ((String) in.readValue((String.class.getClassLoader())));
        this.img = ((String) in.readValue((String.class.getClassLoader())));
        this.logo = ((String) in.readValue((String.class.getClassLoader())));
        this.address = ((String) in.readValue((String.class.getClassLoader())));
        this.phone = ((String) in.readValue((String.class.getClassLoader())));
        this.startDate = ((String) in.readValue((String.class.getClassLoader())));
        this.endDate = ((String) in.readValue((String.class.getClassLoader())));
    }

    public HomeUnderConstructData() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink360() {
        return link360;
    }

    public void setLink360(String link360) {
        this.link360 = link360;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getYoutube() {
        return youtube;
    }

    public void setYoutube(String youtube) {
        this.youtube = youtube;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(idUser);
        dest.writeValue(title);
        dest.writeValue(link360);
        dest.writeValue(description);
        dest.writeValue(youtube);
        dest.writeValue(img);
        dest.writeValue(logo);
        dest.writeValue(address);
        dest.writeValue(phone);
        dest.writeValue(startDate);
        dest.writeValue(endDate);
    }

    public int describeContents() {
        return 0;
    }

}