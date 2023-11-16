package task2;

public class Products {

    private int prod_id;
    private String title;
    private Float price;
    private Float rating;

    public int getProd_id() {return prod_id;}
    public String getTitle() {return title;}
    public Float getPrice() {return price;}
    public Float getRating() {return rating;}
    
    public Products(int prod_id, String title, Float price, Float rating){
        this.prod_id = prod_id;
        this.title = title;
        this.price = price;
        this.rating = rating;
    }
    
}
