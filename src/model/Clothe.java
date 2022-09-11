package model;

public class Clothe {
    //atributos
    String code;
    String name;
    float manufactoringCost;
    float salePrice;
    String collection;
    
    //Constructores
    public Clothe(){
        this.code = "";
        this.name = "";
        this.manufactoringCost = 0;
        this.salePrice = 0;
        this.collection = "";
    }
    
    public Clothe (String code, String name, float manufactoringCost, float salePrice, String collection){
        this.code = code;
        this.name = name;
        this.manufactoringCost = manufactoringCost;
        this.salePrice = salePrice;
        this.collection = collection;
    }
    
    //modificadores
    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setManufactoringCost(float manufactoringCost) {
        this.manufactoringCost = manufactoringCost;
    }

    public void setSalePrice(float salePrice) {
        this.salePrice = salePrice;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }
    
    //analizadores
    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public float getManufactoringCost() {
        return manufactoringCost;
    }

    public float getSalePrice() {
        return salePrice;
    }

    public String getCollection() {
        return collection;
    }

    @Override
    public String toString() {
        return this.code + "," + this.name + "," + this.manufactoringCost + "," + this.salePrice + "," + this.collection;
    }    
}
