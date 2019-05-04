package Multiplex;

public enum TicketsPrices {
    CHILD(12.5f, "child"), STUDENT(18, "student"), ADULT(25, "adult");

    private final float price;
    private final String type;
    private float ticketsAmount;


    TicketsPrices(float price, String type) {
        this.price = price;
        this.type = type;
    }

    public void setTicketsAmount(int amount){
        this.ticketsAmount = amount;
    }

    public String getType(){
        return type;
    }

    public float getPrice(){
        return price;
    }
}
