package com.example.driftdreams.ModelClass;

public class CartModel {

    String imageurlcar,carname,carprice,carrating,carcategory;

    public CartModel(String imageurlcar, String carname, String carprice, String carrating, String carcategory) {
        this.imageurlcar = imageurlcar;
        this.carname = carname;
        this.carprice = carprice;
        this.carrating = carrating;
        this.carcategory = carcategory;
    }

    public String getImageurlcar() {
        return imageurlcar;
    }

    public void setImageurlcar(String imageurlcar) {
        this.imageurlcar = imageurlcar;
    }

    public String getCarname() {
        return carname;
    }

    public void setCarname(String carname) {
        this.carname = carname;
    }

    public String getCarprice() {
        return carprice;
    }

    public void setCarprice(String carprice) {
        this.carprice = carprice;
    }

    public String getCarrating() {
        return carrating;
    }

    public void setCarrating(String carrating) {
        this.carrating = carrating;
    }

    public String getCarcategory() {
        return carcategory;
    }

    public void setCarcategory(String carcategory) {
        this.carcategory = carcategory;
    }
}
