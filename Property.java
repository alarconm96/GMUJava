/*
   Marco Alarcon
   February 21, 2021
   IT 206-201
   Programming Assignment 2 - Data Definition Class
   
   This class allows the program to create an Property class that will hold
   information regarding the property's address, purchase price, and
   renovation cost. A MAX_TAX constant is provided to ensure the area tax
   does not exceed 33%. The user is able to instantiate the Property with all
   the instance variables or just the address. However, the user must at
   least provide an address.
   
   The class provides basic accessors and mutators to obtain and modify
   the values within each Property object. The setAddress() method verifies
   that the argument is not a null String before changing the instance
   address. The setPurchasePrice() method verifies that the price is a
   positive value before assigning it to the instance purchasePrice. The
   setRenovationCost() method verifies that the argument is both a positive
   number as well as less than the instance purchasePrice. All these
   mutators throw an IllegalArgumentException if the arguments are not valid.
   
   The class also comes with a special purpose calcBreakEven() method that 
   calculates the Break-Even Cost of the Property object using its purchase 
   price, renovation cost, and area tax that applies to it. If the arguments
   are not valid, the calcBreakEven() method throws an IllegalArgumentException.
   If all the values are verified, the purchasePrice, renovationCost, 
   and tax percent increase to the purchasePrice are all added together to
   determine the Break-Even Cost. Finally, the Property class contains a
   toString() method to quickly list all the instance variables related
   to the instance variable, should the user need it.
*/

public class Property{
   //Constants
   private static final double MAX_TAX = 0.33;
   
   //Instance Variables
   private String address;
   private double purchasePrice;
   private double renovationCost;
   
   //Constructors
   public Property(String address){
      if(address == null || address.equals("")){
         throw new IllegalArgumentException("Property address cannot be null");
      }
      this.address = address;
   }
   
   public Property(String address, double purchasePrice, double renovationCost){
      if(address == null || address.equals("")){
         throw new IllegalArgumentException("Property address cannot be null");
      }
      if(purchasePrice < 0){
         throw new IllegalArgumentException("Property purchase price cannot be negative");
      }
      if(renovationCost < 0 || renovationCost > purchasePrice){
         throw new IllegalArgumentException("Property renovation cost must be between 0 - purchasePrice");
      }
      this.address = address;
      this.purchasePrice = purchasePrice;
      this.renovationCost = renovationCost;
   }
   
   //Accessors
   public String getAddress(){return this.address;}
   public double getPurchasePrice(){return this.purchasePrice;}
   public double getRenovationCost(){return this.renovationCost;}
   public static double getMaxTax(){return MAX_TAX;}
   
   //Mutators
   public void setAddress(String address){
      if(address == null || address.equals("")){
         throw new IllegalArgumentException("Property address cannot be null");
      }
      this.address = address;
   }
   
   public void setPurchasePrice(double purchasePrice){
      if(purchasePrice < 0){
         throw new IllegalArgumentException("Property purchase price cannot be negative");
      }
      this.purchasePrice = purchasePrice;
   }
   
   public void setRenovationCost(double renovationCost){
      if(renovationCost < 0 || renovationCost > this.purchasePrice){
         throw new IllegalArgumentException("Property renovation cost must be between 0 and purchase price");
      }
      this.renovationCost = renovationCost;
   }
   
   //Special Purpose
   public double calcBreakEven(double purchasePrice, double renovationCost, double taxRate){
      if(taxRate < 0 || taxRate > MAX_TAX){
         throw new IllegalArgumentException("Tax rate must be between 0 - 0.33");
      }
      return purchasePrice + renovationCost + (purchasePrice * (1 + taxRate));
   }
   
   //Insert instance variables into a string for display
   public String toString(){
      return String.format("Address: %s%nPurchasePrice: $%.2f%nRenovation Cost: $%.2f%n", address, purchasePrice, renovationCost);
   }
}