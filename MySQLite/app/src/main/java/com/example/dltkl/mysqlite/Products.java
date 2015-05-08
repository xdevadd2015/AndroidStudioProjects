package com.example.dltkl.mysqlite;


public class Products {

    private int _id;
    private String name;

    public Products(){
    }

    public Products(String name) {
        this.name = name;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int get_id() {
        return _id;
    }

    public String getName() {
        return name;
    }
}
