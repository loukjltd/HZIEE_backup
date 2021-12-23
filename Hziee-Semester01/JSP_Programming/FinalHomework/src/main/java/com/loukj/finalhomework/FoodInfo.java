package com.loukj.finalhomework;
import java.io.Serializable;
public class FoodInfo implements Serializable{
    private static final long serialVersionUID = 1L;
    private String foodNo;
    private String foodName;
    private String foodNameEng;
    private String price;
    public FoodInfo() {

    }
    public FoodInfo(String foodNo, String foodName, String foodNameEng, String price) {
        this.foodNo = foodNo;
        this.foodName = foodName;
        this.foodNameEng = foodNameEng;
        this.price = price;
    }
    public String getFoodNo() {
        return foodNo;
    }
    public void setFoodNo() {
        this.foodNo = foodNo;
    }
    public String getFoodName() {
        return foodName;
    }
    public void setFoodName() {
        this.foodName = foodName;
    }
    public String getFoodNameEng() {
        return foodNameEng;
    }
    public void setFoodNameEng() {
        this.foodNameEng = foodNameEng;
    }
    public String getPrice() {
        return price;
    }
    public void setPrice() {
        this.price = price;
    }
}
