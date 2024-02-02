package com.example.driftdreams.ModelClass;

public class RecModel {
     String imageUrl;
     String companybrand;

    public RecModel(String imageUrl, String companybrand) {
        this.imageUrl = imageUrl;
        this.companybrand = companybrand;
    }

    public RecModel() {
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getCompanybrand() {
        return companybrand;
    }

    public void setCompanybrand(String companybrand) {
        this.companybrand = companybrand;
    }
}