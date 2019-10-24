package co.grandcircus;

import java.util.Comparator;

public class ShoppingCartItemComparator implements Comparator<ShoppingCartItem>
{
   public int compare(ShoppingCartItem a, ShoppingCartItem b) {
      if (a.getPrice() < b.getPrice()) {
         return -1;
      }
      else if (a.getPrice() == b.getPrice()) {
         return 0;
      }
      else {
         return 1;
      }
      
   }
}
