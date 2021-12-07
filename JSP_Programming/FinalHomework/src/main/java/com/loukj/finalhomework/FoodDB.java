package com.loukj.finalhomework;

import java.sql.*;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class FoodDB {
    private static Map<String, FoodInfo> newFood = new LinkedHashMap<String, FoodInfo>();
    static {
        Connection newConn = null;
        Statement newSta = null;
        ResultSet newRst = null;
        try {
            newConn = JdbcUtils.getConnection();
            newSta = newConn.createStatement();
            String sqlSelectLang = "SELECT * FROM foodinfo";
            newRst = newSta.executeQuery(sqlSelectLang);

            while (newRst.next()) {
                String getFoodNo = newRst.getString("foodno");
                String getFoodName = newRst.getString("foodname");
                String getFoodNameEng = newRst.getString("foodname_eng");
                String getPrice = newRst.getString("price");
                newFood.put(getFoodNo, new FoodInfo(getFoodNo, getFoodName, getFoodNameEng, getPrice));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.release(newRst, newSta, newConn);
        }
    }
    public static Collection<FoodInfo> getAll() {
        return newFood.values();
    }
    public static FoodInfo getFood(String foodNo) {
        return newFood.get(foodNo);
    }
}
