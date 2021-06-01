import java.util.*;
public class BalancedString{
   public static void main(String[] args){
      Scanner sc = new Scanner(System.in);
		Stack<Character> myStack = new Stack<>();
      
		while (sc.hasNextLine()) {
			String input = sc.nextLine();
         boolean balanced = true;
         for(int i = 0; i < input.length(); i++){
            char temp = input.charAt(i);
            if(temp == '(' || temp == '{' || temp == '['){
               myStack.push(temp);
            }
            else if(temp == ')' || temp == '}' || temp == ']'){
               if(!myStack.empty()){
                  switch(temp){
                     case ')':
                        if(myStack.peek() == '('){
                           myStack.pop();
                        }
                        break;
                     case '}':
                        if(myStack.peek() == '{'){
                           myStack.pop();
                        }
                        break;
                     case ']':
                        if(myStack.peek() == '['){
                           myStack.pop();
                        }
                        break;
                  }
               }else{
                  balanced = false;
               }
            }
         }
         if(!myStack.empty()){
            balanced = false;
         }
         System.out.println(balanced);
         myStack.clear();
		}
   }
}