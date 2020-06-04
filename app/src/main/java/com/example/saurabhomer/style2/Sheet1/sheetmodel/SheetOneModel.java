package com.example.saurabhomer.style2.Sheet1.sheetmodel;

import com.example.saurabhomer.style2.Sheet1.SheetTwo;

import java.util.ArrayList;

public class SheetOneModel {

    private String totalman=" ",remainingquantity="",totallineoutput="",rundays="",date="",currentTime="";
    private ArrayList<SheetTwoModel> sheetTwoArrayList;




    public String getTotalman() {
        return totalman;
    }

    public void setTotalman(String totalman) {
        this.totalman = totalman;
    }

    public String getRemainingquantity() {
        return remainingquantity;
    }

    public void setRemainingquantity(String remainingquantity) {
        this.remainingquantity = remainingquantity;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }

    public String getTotallineoutput() {
        return totallineoutput;
    }

    public void setTotallineoutput(String totallineoutput) {
        this.totallineoutput = totallineoutput;
    }

    public String getRundays() {
        return rundays;
    }

    public void setRundays(String rundays) {
        this.rundays = rundays;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ArrayList<SheetTwoModel> getSheetTwoArrayList() {
        return sheetTwoArrayList;
    }

    public void setSheetTwoArrayList(ArrayList<SheetTwoModel> sheetTwoArrayList) {
        this.sheetTwoArrayList = sheetTwoArrayList;
    }
}
