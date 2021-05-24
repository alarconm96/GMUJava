import java.util.*;
import java.io.*;

public class ListProblem{
   public static void main(String[] args){
      Scanner input = new Scanner(System.in);
      
      //get list size
      int size = Integer.parseInt(input.nextLine());
      ArrayList<Integer> myList = new ArrayList<>();
      
      //insert elements
      for(int i = 0; i < size; i++){
         myList.add(input.nextInt());
      }
      input.nextLine();
      
      //number of queries
      int queries = Integer.parseInt(input.nextLine());
      
      for(int i = 0; i < queries; i++){
         //get cmd
         String cmd = input.nextLine();
         
         //insert
         if(cmd.equalsIgnoreCase("Insert")){
            int index = input.nextInt();
            int element = input.nextInt();
            myList.add(index, element);
            input.nextLine();
         }
         //delete
         if(cmd.equalsIgnoreCase("Delete")){
            int index = input.nextInt();
            myList.remove(index);
            input.nextLine();
         }
      }
      
      //print final report
      for(int i = 0; i < myList.size(); i++){
         System.out.print(myList.get(i) + " ");
      }
   }
}