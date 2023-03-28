package ru.itmo.lesson06.task01;

public class Mountain {
    private String name = "Elbrus";
    private String country = "Russia";
    private int height = 5642;


    public void setName(String name) {
        if(name.length() > 3) this.name = name;
    }

    public void setCountry(String country) {
        if(country.length() > 3) this.country = country;
    }

    public void setHeight(int height) {
        if(height > 99) this.height = height;
    }

    @Override
    public String toString() {
        return "Mountain{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", height=" + height +
                '}';
    }
}


