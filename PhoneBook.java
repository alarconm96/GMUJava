import java.io.*;
import java.util.*;

public class PhoneBook{
   public static void main(String[] args){
      Scanner input = new Scanner(System.in);
      HashMap<String, String> phonebook = new HashMap<>();
      
      //get num of entries
      int n = input.nextInt();
      input.nextLine();
      
      //insert values
      for(int i = 0; i < n; i++){
         phonebook.put(input.nextLine(), input.nextLine());
      }
      
      //search queries
      while(input.hasNextLine()){
         String name = input.nextLine();
         if(phonebook.containsKey(name)){
            System.out.printf("%s=%s%n", name, phonebook.get(name));
         }else{
            System.out.println("Not found");
         }
      }
   }
}
