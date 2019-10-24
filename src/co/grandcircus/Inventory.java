package co.grandcircus;

import java.util.HashMap;

/**
 * I want an immutable inventory. Since a final variable must be initialized on
 * the line it's declared on, and there is no literal syntax for HashMaps until
 * Java 9, I've just exposed the inventory the OOP way.
 * 
 * @author kflory
 */
public class Inventory
{
   private static HashMap<String, Double> priceList;
   
   static {
      priceList = new HashMap<>();
      priceList.put("Farthingale", 40.60);
      priceList.put("Stomacher", 80.99);
      priceList.put("Chemise", 25.99);
      priceList.put("Brocade Kirtle", 159.99);
      priceList.put("Blackwork Partlet", 99.99);
      priceList.put("Doublet stitch'd with Thread of Gold", 149.99);
      priceList.put("Doublet all of Silk Damask", 149.99);
      priceList.put("Jerkin of Good Leather", 99.95);
      priceList.put("Nether-hose", 35.59);
      priceList.put("Ribands of Satin, each", 12.45);
   }
   
   public static HashMap<String, Double> getInventory() {
      return priceList;
   }
   
   public static void printInventory() {
      System.out.println("======================================================================");
      for (String description : priceList.keySet())
         System.out.println(String.format("   %-30s    %-6.2f", description, priceList.get(description)));
      System.out.println("======================================================================");
   }
}
