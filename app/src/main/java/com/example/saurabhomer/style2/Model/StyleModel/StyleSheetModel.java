package com.example.saurabhomer.style2.Model.StyleModel;

public class StyleSheetModel {
    private String sheetNumber;
    private String BuyersName;
    private String ProduectDetail;
    private String Description;
    private String totalQuality;
    private String ShipmentDate;
    private String sum;

    public StyleSheetModel(String sheetNumber, String buyersName, String produectDetail, String description, String totalQuality, String shipmentDate, String sum, String lineNumber, String size) {
        this.sheetNumber = sheetNumber;
        BuyersName = buyersName;
        ProduectDetail = produectDetail;
        Description = description;
        this.totalQuality = totalQuality;
        ShipmentDate = shipmentDate;
        this.sum = sum;
        this.lineNumber = lineNumber;

        this.size = size;
    }

    public StyleSheetModel() {
    }

    private String lineNumber;
    private String lineEfficiency;

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    private String size;

    public String getSheetNumber() {
        return sheetNumber;
    }

    public void setSheetNumber(String sheetNumber) {
        this.sheetNumber = sheetNumber;
    }

    public String getBuyersName() {
        return BuyersName;
    }

    public void setBuyersName(String buyersName) {
        BuyersName = buyersName;
    }

    public String getProduectDetail() {
        return ProduectDetail;
    }

    public void setProduectDetail(String produectDetail) {
        ProduectDetail = produectDetail;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getTotalQuality() {
        return totalQuality;
    }

    public void setTotalQuality(String totalQuality) {
        this.totalQuality = totalQuality;
    }

    public String getShipmentDate() {
        return ShipmentDate;
    }

    public void setShipmentDate(String shipmentDate) {
        ShipmentDate = shipmentDate;
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }

    public String getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(String lineNumber) {
        this.lineNumber = lineNumber;
    }

    public String getLineEfficiency() {
        return lineEfficiency;
    }

    public void setLineEfficiency(String lineEfficiency) {
        this.lineEfficiency = lineEfficiency;
    }
}
