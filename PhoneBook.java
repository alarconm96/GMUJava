import java.io.*;
import java.util.*;

public class PhoneBook{
   public static void main(String[] args){
      Scanner input = new Scanner(System.in);
      LinkedList<String> names = new LinkedList<>();
      LinkedList<String> numbers = new LinkedList<>();
      
      //get num of entries
      int n = input.nextInt();
      input.nextLine();
      
      //insert values
      for(int i = 0; i < n; i++){
         names.add(input.nextLine());
         numbers.add(input.nextLine());
      }
      
      //search queries
      while(input.hasNextLine()){
         String name = input.nextLine();
         if(names.contains(name)){
            System.out.printf("%s=%s%n", name, numbers.get(names.indexOf(name)));
         }else{
            System.out.println("Not found");
         }
      }
   }
}