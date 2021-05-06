//Custom Exception Practice
public class FruitNameException extends RuntimeException{
   public FruitNameException(){
      super();
   }
   
   public FruitNameException(String e){
      super(e);
   }
}
