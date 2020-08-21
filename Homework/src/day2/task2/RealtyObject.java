package day2.task2;


public abstract class RealtyObject {
    public int area;
    public int price;
    public int pricemetr;


    RealtyObject(int area, int pricemetr){
        this.area=area;
        this.pricemetr=pricemetr;
        this.price=area * pricemetr;
    }
}






