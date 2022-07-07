package sample.controller;

public class itemTable2 {
    String smallName;
    Double smallPrice;
    String description;
    String type;
    String name;
    String mediumName;
    String bigName;
    Double mediumPrice,bigPrice;

    public itemTable2(String smallName) {
        this.smallName = smallName;
    }

    public String getSmallName() {
        return smallName;
    }

    public void setSmallName(String smallName) {
        this.smallName = smallName;
    }



    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMediumName() {
        return mediumName;
    }

    public void setMediumName(String mediumName) {
        this.mediumName = mediumName;
    }

    public String getBigName() {
        return bigName;
    }

    public void setBigName(String bigName) {
        this.bigName = bigName;
    }

    public Double getMediumPrice() {
        return mediumPrice;
    }

    public void setMediumPrice(Double mediumPrice) {
        this.mediumPrice = mediumPrice;
    }

    public Double getBigPrice() {
        return bigPrice;
    }

    public void setBigPrice(Double bigPrice) {
        this.bigPrice = bigPrice;
    }

    public itemTable2(String type, String name, String smallName,Double smallPrice, String mediumName,Double mediumPrice, String bigName,  Double bigPrice, String description) {
        this.type = type;
        this.name = name;
        this.smallName = smallName;
        this.mediumName = mediumName;
        this.bigName = bigName;
        this.smallPrice = smallPrice;
        this.mediumPrice = mediumPrice;
        this.bigPrice = bigPrice;
        this.description = description;
    }
}
