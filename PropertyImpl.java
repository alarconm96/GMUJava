/*
   Marco Alarcon
   February 21, 2021
   IT 206-201
   Programming Assignment 2 - Implementation Class
   
   This implementation class utilizes the Property class and conducts the
   process by which the user will input information for each property.
   The user is prompted for the property's address, purchase price,
   and the renovation cost. Afterwards, the user is then prompted for the
   area's tax rate that will affect each property individually. This
   information is then used by the program to calculate the Break-Even Cost
   for that specific property. Once the calculation is complete, the program
   adds all the previous variables used including the Break-Even cost into
   a total variable for each one. Additionally, a property counter is
   incremented by one each time all the calculations are complete. This cycle
   repeats and the user is prompted for a total of five properties. Once all
   five properties are entered, the average for purchasePrice, renovationCost,
   and breakEven are calculated using the total counter of 5, which is then
   displayed as a well formatted report at the end of execution.
*/

import javax.swing.JOptionPane;
public class PropertyImpl{
   
   //Method for user String inputs
   public static String userString(String prompt){
      boolean valid = true;
      String input = "";
      do{
         input = JOptionPane.showInputDialog(prompt);
         if(input == null || input.equals("")){
            valid = false;
            JOptionPane.showMessageDialog(null, "Must enter a value");
         }else{valid = true;}
      }while(!valid);
      return input;
   }
   
   //Method for user double inputs
   public static double userDouble(String prompt){
      boolean valid = true;
      double input = 0;
      do{
         try{
            valid = true;
            input = Double.parseDouble(JOptionPane.showInputDialog(prompt));
         }catch(NumberFormatException e){
            valid = false;
            JOptionPane.showMessageDialog(null, "Must input a number");
         }
      }while(!valid);
      return input;
   }
   
   //Method for reporting the current property's information
   public static String createSingleReport(String address, double purchasePrice, double renovationCost, double breakEven){
      return String.format("Address: %s%nPurchase Price: $%.2f%nRenovation Cost: $%.2f%nBreak-Even Cost: $%.2f", address, purchasePrice, renovationCost, breakEven);
   }
   
   //Method for reporting the collective average of each variable for all properties
   public static String createFinalReport(double avgPrice, double avgRenovation, double avgBreakEven){
      return String.format("Average Purchase Price: $%.2f%nAverage Renovation Cost: $%.2f%nAverage Break-Even Cost: $%.2f", avgPrice, avgRenovation, avgBreakEven);
   }
   
   public static void main(String[] args){
      //main variables
      int numProps = 0;
      double avgPrice = 0;
      double avgRenovation = 0;
      double avgBreakEven = 0;
      
      //do-while to loop for 5 properties
      
      do{
         try{
            Property house = new Property(userString(String.format("Please enter property address %d", numProps+1)));
            
            house.setPurchasePrice(userDouble(String.format("Enter property %d purchase price", numProps+1)));
            avgPrice += house.getPurchasePrice();
            
            house.setRenovationCost(userDouble(String.format("Enter property %d renovation cost", numProps+1)));
            avgRenovation += house.getRenovationCost();
            
            double breakEven = 0;
            breakEven = house.calcBreakEven(house.getPurchasePrice(), house.getRenovationCost(), userDouble("Enter tax rate"));
            avgBreakEven += breakEven;
            
            JOptionPane.showMessageDialog(null, createSingleReport(house.getAddress(), house.getPurchasePrice(), house.getRenovationCost(), breakEven));
            
            numProps++;
         }catch(IllegalArgumentException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
         }
      }while(numProps < 5);
      
      //calculate average for createFinalReport
      avgPrice /= numProps;
      avgRenovation /= numProps;
      avgBreakEven /= numProps;
      
      JOptionPane.showMessageDialog(null, createFinalReport(avgPrice, avgRenovation, avgBreakEven));
   }
}