package co.grandcircus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

public class ShoppingCart
{
   private HashMap<ShoppingCartItem, Integer> itemsInShoppingCart;
   
   public ShoppingCart() {
      itemsInShoppingCart = new HashMap<>();
   }
   
   public boolean isItemInCart(String itemName) {
      // Iterate over list. If item is found, return true.
      for (ShoppingCartItem item : itemsInShoppingCart.keySet()) {
         if (item.getDescription().equalsIgnoreCase(itemName)) {
            return true;
         }
      }
      
      return false;
   }
   
   public ShoppingCartItem getItem(String itemName) {
      // Iterate over list. If item is found, return true.
      for (ShoppingCartItem item : itemsInShoppingCart.keySet()) {
         if (item.getDescription().equalsIgnoreCase(itemName)) {
            return item;
         }
      }
      
      return null;
   }
   
   public boolean removeAnItemFromCart(String itemName)
   {
      ShoppingCartItem item = getItem(itemName);
      
         int oldCount = itemsInShoppingCart.get(item);
         //If there's more than one of the item...
         if (oldCount > 1)
         {
            
            itemsInShoppingCart.replace(item, oldCount--);
            return true;
         }
         else if (oldCount == 1)
         {
            itemsInShoppingCart.remove(item);
            return true;
         }
         else {
            return false;
         }

   }
   
   public void addAnItemToCart(ShoppingCartItem itemToAdd) {
      ShoppingCartItem thisItem = getItem(itemToAdd.getDescription());
      if (thisItem != null) {
         int oldQuantity = itemsInShoppingCart.get(thisItem);
         //System.out.println("Old quantity was: " + oldQuantity);
         itemsInShoppingCart.replace(thisItem, oldQuantity + 1);
         //System.out.println("New quantity is: " + itemsInShoppingCart.get(thisItem));
      }
      else {
         itemsInShoppingCart.put(itemToAdd, 1);
      }
   }
   
   public ArrayList<ShoppingCartItem> getItemsSortedByPrice() {
      ArrayList<ShoppingCartItem> toReturn = new ArrayList<>();
      for (ShoppingCartItem sci : itemsInShoppingCart.keySet()) {
         toReturn.add(sci);
      }
      Collections.sort(toReturn, new ShoppingCartItemComparator());
      return toReturn;
   }
   
   public void printCartSortedByPrice() {
      System.out.println("======================================================================");
      for (ShoppingCartItem sci : getItemsSortedByPrice()) {
         int itemCount = itemsInShoppingCart.get(sci);
         String itemDesc = sci.getDescription();
         Double itemPrice = sci.getPrice();
         System.out.println(String.format("%2d %-30s at %-6.2f apiece", itemCount, itemDesc, itemPrice));
      }
      System.out.println("======================================================================");
   }
   
   public double calculateTotalPrice()
   {
      double runningTotal = 0.0;
      for (ShoppingCartItem sci : itemsInShoppingCart.keySet()) {
         runningTotal += (sci.getPrice() * itemsInShoppingCart.get(sci));
      }
      return runningTotal;
   }
   
   public void printTotalPrice()
   {
      System.out.println(String.format("The Total is --------------------- %-6.2f", calculateTotalPrice()));
   }
   
   public double getSmallestPrice()
   {
      Double smallestUnitPrice = null;
      boolean isFirst = true;
      for (ShoppingCartItem sci : itemsInShoppingCart.keySet()) {
         if (isFirst)
         {
            smallestUnitPrice = sci.getPrice();
            isFirst = false;
         } else {
            if (sci.getPrice() <= smallestUnitPrice)
            {
               smallestUnitPrice = sci.getPrice();
            }
         }
      }
      return smallestUnitPrice;
   }

   public void printTSmallestPrice()
   {
      System.out.println(String.format("The smallest Price is ------------- %-6.2f", getSmallestPrice()));
   }
   
   public double getLargestPrice()
   {
      Double largestUnitPrice = null;
      boolean isFirst = true;
      for (ShoppingCartItem sci : itemsInShoppingCart.keySet()) {
         if (isFirst)
         {
            largestUnitPrice = sci.getPrice();
            isFirst = false;
         } else {
            if (sci.getPrice() >= largestUnitPrice)
            {
               largestUnitPrice = sci.getPrice();
            }
         }
      }
      return largestUnitPrice;
   }
   
   public void printLargestPrice()
   {
      System.out.println(String.format("The largest Price is -------------- %-6.2f", getLargestPrice()));
   }
}
