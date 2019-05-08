package com.example.alshimaa.exhibtion.model;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ExhibtorDetailsData implements Serializable, Parcelable
{

    @SerializedName("id_exhibitor")
    @Expose
    private String idExhibitor;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("link_map")
    @Expose
    private String linkMap;
    @SerializedName("website_link")
    @Expose
    private String websiteLink;
    @SerializedName("youtube_link")
    @Expose
    private String youtubeLink;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("img2")
    @Expose
    private String img2;
    @SerializedName("phone")
    @Expose
    private String phone;
    public final static Parcelable.Creator<ExhibtorDetailsData> CREATOR = new Creator<ExhibtorDetailsData>() {


        @SuppressWarnings({
                "unchecked"
        })
        public ExhibtorDetailsData createFromParcel(Parcel in) {
            return new ExhibtorDetailsData(in);
        }

        public ExhibtorDetailsData[] newArray(int size) {
            return (new ExhibtorDetailsData[size]);
        }

    }
            ;
    private final static long serialVersionUID = -6413800194015990359L;

    protected ExhibtorDetailsData(Parcel in) {
        this.idExhibitor = ((String) in.readValue((String.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.description = ((String) in.readValue((String.class.getClassLoader())));
        this.email = ((String) in.readValue((String.class.getClassLoader())));
        this.linkMap = ((String) in.readValue((String.class.getClassLoader())));
        this.websiteLink = ((String) in.readValue((String.class.getClassLoader())));
        this.youtubeLink = ((String) in.readValue((String.class.getClassLoader())));
        this.address = ((String) in.readValue((String.class.getClassLoader())));
        this.img2 = ((String) in.readValue((String.class.getClassLoader())));
        this.phone = ((String) in.readValue((String.class.getClassLoader())));
    }

    public ExhibtorDetailsData() {
    }

    public String getIdExhibitor() {
        return idExhibitor;
    }

    public void setIdExhibitor(String idExhibitor) {
        this.idExhibitor = idExhibitor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLinkMap() {
        return linkMap;
    }

    public void setLinkMap(String linkMap) {
        this.linkMap = linkMap;
    }

    public String getWebsiteLink() {
        return websiteLink;
    }

    public void setWebsiteLink(String websiteLink) {
        this.websiteLink = websiteLink;
    }

    public String isYoutubeLink() {
        return youtubeLink;
    }

    public void setYoutubeLink(String youtubeLink) {
        this.youtubeLink = youtubeLink;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImg2() {
        return img2;
    }

    public void setImg2(String img2) {
        this.img2 = img2;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(idExhibitor);
        dest.writeValue(name);
        dest.writeValue(description);
        dest.writeValue(email);
        dest.writeValue(linkMap);
        dest.writeValue(websiteLink);
        dest.writeValue(youtubeLink);
        dest.writeValue(address);
        dest.writeValue(img2);
        dest.writeValue(phone);
    }

    public int describeContents() {
        return 0;
    }

}