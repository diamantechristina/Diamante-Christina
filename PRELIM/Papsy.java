import java.util.*;
public class Papsy{
   public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
      
      String[] meals = {"Unli Rice Meals", "Mango Float", "Drinks"};
      final int[] price = {144, 70, 44};
      String[] mealsQty = new String[3];
      
      System.out.println("\t\tMENU");
      for(int i = 0; i <= meals.length-1; i++){
         System.out.println("\tP" + price[i] + "\t" + meals[i]);
      }
      System.out.println();
      
      for(int i = 0; i <= meals.length-1; i++){
         System.out.print("Enter " + meals[i] + " quantity: ");
         mealsQty[i] = scan.nextLine();
         if(!isInteger(mealsQty[i])) i--;
      }
      
      System.out.println("\n***YOUR TOTAL IN PHP***");
      for(int i = 0; i <= meals.length-1; i++){
         System.out.println("Total price for " + meals[i] + ": P" + (price[i] * Integer.parseInt(mealsQty[i])));
      }
      
      System.out.println("\n***YOUR TOTAL IN DOLLAR***");
      for(int i = 0; i <= meals.length-1; i++){
         System.out.printf("Total price for %s: $%.2f \n", meals[i], (((double)price[i] * Integer.parseInt(mealsQty[i])/56)));
      }
   }
   static boolean isInteger(String test){
      try{
         Integer.parseInt(test);
         return true;
      } catch(Exception e){
         return false;
      }
   }
}

/* if(!isInteger(mealsQty[i]))
      i--;
      
   static boolean isInteger(String testInput){
      try{
         Integer.parseInt(testInput);
         return true;
      }catch(Exception e){
         return false;
      }
   }
*/