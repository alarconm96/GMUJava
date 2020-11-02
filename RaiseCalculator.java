import javax.swing.*;

public class RaiseCalculator{
   public static void main(String[] args){
      final double RAISE_RATE = 0.09;
      final int EMPLOYEES = 10;
      
      String[] names = new String[EMPLOYEES];
      double[] salaries = new double[EMPLOYEES];
      double[] payIncreases = new double[EMPLOYEES];
      
      String receipt = String.format("%-25s%25s%n", "Employee name", "Salary Increase");
      
      for(int i = 0; i < EMPLOYEES; i++){
         names[i] = getName();
         salaries[i] = getSalary();
         payIncreases[i] = salaries[i] * RAISE_RATE;
         salaries[i] += payIncreases[i];
         
         
         receipt += String.format("%-25s %25s%.2f%n", names[i], "$", payIncreases[i]);
      }
      
      receipt += String.format("%nTotal Increases: $%.2f", sumArray(payIncreases));
      
      JOptionPane.showMessageDialog(null, receipt);
   }
   
   public static String getName(){
      String name = JOptionPane.showInputDialog("Enter employee name");
      return name;
   }
   
   public static double getSalary(){
      boolean valid = true;
      double  salary = 0;
      do{
         try{
            salary = Double.parseDouble(JOptionPane.showInputDialog("Enter employee's current salary"));
            if((salary < 0) || (salary > 95000)){
               valid = false;
               JOptionPane.showMessageDialog(null, "ERROR - Salary must be $0 - $95000");
            }else{
               valid = true;
            }
         }catch(Exception e){
            valid = false;
            JOptionPane.showMessageDialog(null, "ERROR - Invalid input");
         }
      }while(!valid);
      return salary;
   }
   
   public static double sumArray(double[] a){
      double sum = 0;
      
      for(double x : a){
         sum += x;
      }
      
      return sum;
   }
}