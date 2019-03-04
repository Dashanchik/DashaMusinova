package base.jdi.entities;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MetalsAndColors {
    int[] summary;
    String color;
    String metal;
    String[] elements;
    String[] vegetables;


    public void setElements(String[] elements) {
        this.elements = elements;
    }

    public String[] getElements() {
        return elements;
    }

    public void setSummary(int[] summary) {
        this.summary = summary;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setMetal(String metal) {
        this.metal = metal;
    }

    public void setVegetables(String[] vegetables) {
        this.vegetables = vegetables;
    }

    public int[] getSummary() {
        return summary;
    }

    public String getColor() {
        return color;
    }

    public String getMetal() {
        return metal;
    }

    public String[] getVegetables() {
        return vegetables;
    }
}
