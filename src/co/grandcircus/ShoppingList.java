package co.grandcircus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

import co.grandcircus.utility.Validator;

/*
 * 
Task: Make a shopping list application which uses collections to store your items.

What will the application do?

● Display a list of at least 8 item names and prices.
● Ask the user to enter an item name
○ If that item exists, display that item and price and add that item and its price to
the user’s order.
○ If that item doesn’t exist, display an error and re-prompt the user. (Display the
menu again if you’d like.)
● Ask if they want to add another. Repeat if they do. (User can enter an item more than
once; we’re not taking quantity at this point.)
● When they’re done adding items, display a list of all items ordered with prices in
columns.
● Display the average price of items ordered.
Build Specifications
● Use a Map to keep track of the menu of items. It should have a String key (for item
name) and Double value (for item price).
● Use parallel ArrayLists (one of strings, one of doubles) to store the items ordered and
their prices.
● Write 3 methods to find 1) the average cost of the items ordered and the indexes of the
2) highest and 3) lowest cost items.
Extended Challenges:
● Implement a menu system so the user can enter just a letter or number for the item.
● Make a third ArrayList for quantities of items ordered and allow the user to order more
than one at a time.
○ Extended: If they order an item already in their cart, increase the quantity rather
than adding another entry.
● Display the most and least expensive item ordered.

Example:

Welcome to Guenther's Market!
Item
Price
==============================
apple
$0.99
banana
$0.59
cauliflower
$1.59
dragonfruit
$2.19
Elderberry
$1.79
figs
$2.09
grapefruit
$1.99
honeydew
$3.49

What item would you like to order? apple
Adding apple to cart at $0.99
Would you like to order anything else (y/n)? y
{menu redisplays}
What item would you like to order? watermelon
Sorry, we don't have those. Please try again.
{menu redisplays}
What item would you like to order? dragonfruit
Adding dragonfruit to cart at $2.19
Would you like to order anything else (y/n)? y
{menu redisplays}
What item would you like to order? honeydew
Adding honeydew to cart at $3.49
Would you like to order anything else (y/n)? y
{menu redisplays}
What item would you like to order? figs
Adding figs to cart at $2.09
Would you like to order anything else (y/n)? n
Thanks for your order!
Here's what you got:
apple
$0.99
dragonfruit
$2.19
honeydew
$3.49
figs
$2.09
Average price per item in order was 2.19

 */

//TODO Rename to ShoppingCart.
public class ShoppingList
{
   private ShoppingCart cart;
   private final HashMap<String, Double> inventory = Inventory.getInventory();
   
   public ShoppingList()
   {
      cart = new ShoppingCart();
   }
   
   private void doSelectItems()
   {    
      try (Scanner inputTokenizer = new Scanner(System.in)) {
         // Ask the user to enter an item name
         
         boolean doKeepShopping = true;
         boolean isItemInList = false;
         // Loops while user enters cart items.
         do 
         {
            // Loops while item is invalid.
            do
            {
               // Display a list of at least 8 item names and prices.
               Inventory.printInventory();
               
               String requestedItem = Validator.getString(inputTokenizer, "Pray chuse an Item -- heed well the Case! ");
               // ○ If that item exists, display that item and price and add that item and its
               // price to
               // the user’s order.
               
               if (inventory.containsKey(requestedItem))
               {
                  isItemInList = true;
                  
                  System.out.println("At once. Your " + requestedItem + " shall be " + inventory.get(requestedItem) + " in these your Dollars.");
                  cart.addAnItemToCart(
                        new ShoppingCartItem(
                              requestedItem, inventory.get(requestedItem)));
               } else {
         // ○ If that item doesn’t exist, display an error and re-prompt the user.
         // (Display the
         // menu again if you’d like.)
                  System.out.println("Alas, we cannot oblige. Here is our Stock again: ");
                  // isItemInList = false;
               }
            } while (!isItemInList);
            // ● Ask if they want to add another. Repeat if they do. (User can enter an item
            // more than
            // once; we’re not taking quantity at this point.)
            doKeepShopping = Validator.getBooleanYN(inputTokenizer, "Will you an Other (yea/nay)?", "Yea", "Nay");

         } while (doKeepShopping);
         
         // ● When they’re done adding items, display a list of all items ordered with
         // prices in
         // columns.
         cart.printCartSortedByPrice();
         // ● Display the average price of items ordered.
         
         // Build Specifications
         // ● Use a Map to keep track of the menu of items. It should have a String key
         // (for item
         // name) and Double value (for item price).
         // ● Use parallel ArrayLists (one of strings, one of doubles) to store the items
         // ordered and
         // their prices.
         // ● Write 3 methods to find 1) the average cost of the items ordered and the
         // indexes of the
         // 2) highest and 3) lowest cost items.
         // Extended Challenges:
         // ● Implement a menu system so the user can enter just a letter or number for
         // the item.
         // ● Make a third ArrayList for quantities of items ordered and allow the user
         // to order more
         // than one at a time.
         // ○ Extended: If they order an item already in their cart, increase the
         // quantity rather
         // than adding another entry.
         // ● Display the most and least expensive item ordered.
         cart.printLargestPrice();
         cart.printTSmallestPrice();
         cart.printTotalPrice();
      }
   }
   
   public static void main(String[] args) {
      ShoppingList listInstance = new ShoppingList();
      listInstance.doSelectItems();
   }

}
