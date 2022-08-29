//Product: id, Найменування, Виробник, Ціна, Термін зберігання, Кількість.

package com.company;
public class Product {
    private int id;
    private String name;
    private String producer;
    private double price;
    private int term;
    private int count;

    public Product(int id, String name, String producer, double price, int term, int count) {
        this.id = id;
        this.name = name;
        this.producer = producer;
        this.price = price;
        this.term = term;
        this.count = count;
    }

    @Override
    public String toString() {
        return "Product ID = " + id + " \t\tName = " + name + " \t\tProducer = " + producer + " \t\tPrice = " + price +
                " \t\tTermin = " + term + " days" + " \t\tAmount = " + count;
    }

    public int getId() {return id;}

    public void setId(int id) { this.id = id;}
    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getProducer() {return producer;}

    public void setProducer(String producer) {this.producer = producer;}

    public double getPrice() {return price;}

    public void setPrice(double price) {this.price = price;}

    public int getTerm() {return term;}

    public void setTerm(int term) {this.term = term;}

    public int getCount() {return count;}

    public void setCount(int count) {this.count = count;}
}
