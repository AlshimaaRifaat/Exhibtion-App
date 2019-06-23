package com.exhibtion.model;

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
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("map_fair")
    @Expose
    private String mapFair;
    @SerializedName("facebook_link")
    @Expose
    private String facebookLink;
    @SerializedName("tweeter_link")
    @Expose
    private String tweeterLink;
    @SerializedName("instgram_link")
    @Expose
    private String instgramLink;
    @SerializedName("youtube_link")
    @Expose
    private String youtubeLink;
    @SerializedName("snap_link")
    @Expose
    private String snapLink;
    @SerializedName("website_link")
    @Expose
    private String websiteLink;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("img2")
    @Expose
    private String img2;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("phone2")
    @Expose
    private String phone2;
    @SerializedName("tit_ser")
    @Expose
    private String titSer;
    @SerializedName("tit_prod")
    @Expose
    private String titProd;
    @SerializedName("map_3D")
    @Expose
    private String map3D;
    @SerializedName("link_map")
    @Expose
    private String linkMap;
    @SerializedName("youtube")
    @Expose
    private String youtube;
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
    private final static long serialVersionUID = 7791571587776583259L;

    protected ExhibtorDetailsData(Parcel in) {
        this.idExhibitor = ((String) in.readValue((String.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.email = ((String) in.readValue((String.class.getClassLoader())));
        this.mapFair = ((String) in.readValue((String.class.getClassLoader())));
        this.facebookLink = ((String) in.readValue((String.class.getClassLoader())));
        this.tweeterLink = ((String) in.readValue((String.class.getClassLoader())));
        this.instgramLink = ((String) in.readValue((String.class.getClassLoader())));
        this.youtubeLink = ((String) in.readValue((String.class.getClassLoader())));
        this.snapLink = ((String) in.readValue((String.class.getClassLoader())));
        this.websiteLink = ((String) in.readValue((String.class.getClassLoader())));
        this.address = ((String) in.readValue((String.class.getClassLoader())));
        this.img2 = ((String) in.readValue((String.class.getClassLoader())));
        this.phone = ((String) in.readValue((String.class.getClassLoader())));
        this.description = ((String) in.readValue((String.class.getClassLoader())));
        this.phone2 = ((String) in.readValue((String.class.getClassLoader())));
        this.titSer = ((String) in.readValue((String.class.getClassLoader())));
        this.titProd = ((String) in.readValue((String.class.getClassLoader())));
        this.map3D = ((String) in.readValue((String.class.getClassLoader())));
        this.linkMap = ((String) in.readValue((String.class.getClassLoader())));
        this.youtube = ((String) in.readValue((String.class.getClassLoader())));
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMapFair() {
        return mapFair;
    }

    public void setMapFair(String mapFair) {
        this.mapFair = mapFair;
    }

    public String getFacebookLink() {
        return facebookLink;
    }

    public void setFacebookLink(String facebookLink) {
        this.facebookLink = facebookLink;
    }

    public String getTweeterLink() {
        return tweeterLink;
    }

    public void setTweeterLink(String tweeterLink) {
        this.tweeterLink = tweeterLink;
    }

    public String getInstgramLink() {
        return instgramLink;
    }

    public void setInstgramLink(String instgramLink) {
        this.instgramLink = instgramLink;
    }

    public String getYoutubeLink() {
        return youtubeLink;
    }

    public void setYoutubeLink(String youtubeLink) {
        this.youtubeLink = youtubeLink;
    }

    public String getSnapLink() {
        return snapLink;
    }

    public void setSnapLink(String snapLink) {
        this.snapLink = snapLink;
    }

    public String getWebsiteLink() {
        return websiteLink;
    }

    public void setWebsiteLink(String websiteLink) {
        this.websiteLink = websiteLink;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getTitSer() {
        return titSer;
    }

    public void setTitSer(String titSer) {
        this.titSer = titSer;
    }

    public String getTitProd() {
        return titProd;
    }

    public void setTitProd(String titProd) {
        this.titProd = titProd;
    }

    public String getMap3D() {
        return map3D;
    }

    public void setMap3D(String map3D) {
        this.map3D = map3D;
    }

    public String getLinkMap() {
        return linkMap;
    }

    public void setLinkMap(String linkMap) {
        this.linkMap = linkMap;
    }

    public String getYoutube() {
        return youtube;
    }

    public void setYoutube(String youtube) {
        this.youtube = youtube;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(idExhibitor);
        dest.writeValue(name);
        dest.writeValue(email);
        dest.writeValue(mapFair);
        dest.writeValue(facebookLink);
        dest.writeValue(tweeterLink);
        dest.writeValue(instgramLink);
        dest.writeValue(youtubeLink);
        dest.writeValue(snapLink);
        dest.writeValue(websiteLink);
        dest.writeValue(address);
        dest.writeValue(img2);
        dest.writeValue(phone);
        dest.writeValue(description);
        dest.writeValue(phone2);
        dest.writeValue(titSer);
        dest.writeValue(titProd);
        dest.writeValue(map3D);
        dest.writeValue(linkMap);
        dest.writeValue(youtube);
    }

    public int describeContents() {
        return 0;
    }

}