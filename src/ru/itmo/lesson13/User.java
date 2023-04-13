package ru.itmo.lesson13;

public class User <T> {
    private T id;

    public void setId(T id) {
        this.id = id;
    }

    public T getId() {
        System.out.println("User.id = " +id);
        return id;
    }

}
