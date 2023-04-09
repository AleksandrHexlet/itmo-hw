package ru.itmo.coursePaper;

public class Owner {
   private String name;
    private String surname;
    private int year_of_birth;

    public Owner(String name, String surname, int year_of_birth) {
        this.name = name;
        this.surname = surname;
        this.year_of_birth = year_of_birth;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getYear_of_birth() {
        return year_of_birth;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", year_of_birth=" + year_of_birth +
                '}';
    }
}
