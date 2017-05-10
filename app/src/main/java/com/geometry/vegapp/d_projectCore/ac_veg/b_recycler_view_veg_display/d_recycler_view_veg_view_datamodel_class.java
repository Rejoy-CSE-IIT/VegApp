package com.geometry.vegapp.d_projectCore.ac_veg.b_recycler_view_veg_display;


public class d_recycler_view_veg_view_datamodel_class
{


    public boolean isDisableview() {
        return disableview;
    }

    public void setDisableview(boolean disableview) {
        this.disableview = disableview;
    }



    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getApproval() {
        return approval;
    }

    public void setApproval(int approval) {
        this.approval = approval;
    }

    public int getMobno() {
        return mobno;
    }

    public void setMobno(int mobno) {
        this.mobno = mobno;
    }

    String organization;
    String category;



    public d_recycler_view_veg_view_datamodel_class(String organization, String category, String details, String image, String place, String contacts, int price, int userid, int id, int approval, int mobno, boolean disableview, float rating)
    {
        this.organization = organization;
        this.category = category;
        this.details = details;
        this.image = image;
        this.place = place;
        this.contacts = contacts;
        this.price = price;
        this.userid = userid;
        this.id = id;
        this.approval = approval;
        this.mobno = mobno;
        this.disableview=      disableview;
        this.rating=rating;
    }

    String details;
    String image;
    String place;
    String contacts;

    int  price;
    int  userid;
    int  id;
    int approval;
    int mobno;

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    float  rating;
    boolean disableview;










}
