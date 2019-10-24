package co.grandcircus;

public class ShoppingCartItem
{
   private String description = "";
   private double price = 0.0;
   
   public ShoppingCartItem(String description, double price) {
      this.description = description;
      this.price = price;
   }
   
   public String getDescription() {
      return this.description;
   }
   
   public Double getPrice() {
      return this.price;
   }
}