/*
        AUTHORS

        S.C.R FERNANDO AS2019918
        H.R.Ranaweera  AS2019950

*/

package com.example.foodie;

public class FoodItem {

    private String foodName;
    private String manufacture;
    private int netWeight;//in grams

    private float carbohydrate;//in grams
    private float protein;//in grams
    private float salt;//in grams
    private float fat;//in grams
    private float additional;//in grams

    private float containsFactor;//in grams



    // Mandatory empty constructor for use of FirebaseUI
    public FoodItem() {}

    public FoodItem(String foodName,String manufacture,int netWeight,
                    float carbohydrate,float protein,float salt,
                    float fat,float additional,float containsFactor) {
        this.foodName = foodName;
        this.manufacture = manufacture;
        this.netWeight = netWeight;
        this.carbohydrate = carbohydrate;
        this.protein = protein;
        this.salt = salt;
        this.fat = fat;
        this.additional = additional;
        this.containsFactor = containsFactor;

        //derive total No Of Nutrients



    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public int getNetWeight() {
        return netWeight;
    }

    public void setNetWeight(int netWeight) {
        this.netWeight = netWeight;
    }

    public float getCarbohydrate() {
        return carbohydrate;
    }

    public void setCarbohydrate(float carbohydrate) {
        this.carbohydrate = carbohydrate;
    }

    public float getProtein() {
        return protein;
    }

    public void setProtein(float protein) {
        this.protein = protein;
    }

    public float getSalt() {
        return salt;
    }

    public void setSalt(float salt) {
        this.salt = salt;
    }

    public float getFat() {
        return fat;
    }

    public void setFat(float fat) {
        this.fat = fat;
    }

    public float getAdditional() {
        return additional;
    }

    public void setAdditional(float additional) {
        this.additional = additional;
    }

    public float getContainsFactor() {
        return containsFactor;
    }

    public void setContainsFactor(float containsFactor) {
        this.containsFactor = containsFactor;
    }


    @Override
    public String toString() {
        return "FoodItem{" +
                "foodName='" + foodName + '\'' +
                ", manufacture='" + manufacture + '\'' +
                ", netWeight=" + netWeight +
                ", carbohydrate=" + carbohydrate +
                ", protein=" + protein +
                ", salt=" + salt +
                ", fat=" + fat +
                ", additional=" + additional +
                ", containsFactor=" + containsFactor +
                '}';
    }

}
