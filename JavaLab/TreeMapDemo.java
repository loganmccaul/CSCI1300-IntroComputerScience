import java.util.*;

public class TreeMapDemo {

   public static void main(String args[]) {
      // Create a hash map
      TreeMap<String, Double> tm = new TreeMap<String, Double>();
      // Put elements to the map
      tm.put("Frodo", new Double(3434.34));
      tm.put("Larry", new Double(123.22));
      tm.put("Fredo", new Double(1378.00));
      tm.put("Gollum", new Double(99.22));
      tm.put("Koko", new Double(-19.08));
      
	  // Get a set of the entries
      Set set = tm.entrySet();
      // Get an iterator to loop over the items in the map
      Iterator i = set.iterator();
      // Display elements
      while(i.hasNext()) {
         Map.Entry me = (Map.Entry)i.next();
         System.out.print(me.getKey() + ": ");
         System.out.println(me.getValue());
      }
      System.out.println();
      // Deposit 1000 into Koko's account
      double balance = ((Double)tm.get("Koko")).doubleValue();
      tm.put("Koko", new Double(balance + 1000));
      System.out.println("Koko's new balance: " +
      tm.get("Koko"));
   }
}
