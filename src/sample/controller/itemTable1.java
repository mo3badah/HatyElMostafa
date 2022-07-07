package sample.controller;

import javafx.collections.ObservableList;

public class itemTable1 {
    String type,name,description;
    Double big , small;
    Double medium;

    public itemTable1(String type, String name, Double small, Double medium, Double big, String description) {
        this.type = type;
        this.name = name;
        this.big = big;
        this.small = small;
        this.medium = medium;
        this.description = description;

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

    public Double getBig() {
        return big;
    }

    public void setBig(Double big) {
        this.big = big;
    }

    public Double getMedium() {
        return medium;
    }

    public void setMedium(Double medium) {
        this.medium = medium;
    }

}
