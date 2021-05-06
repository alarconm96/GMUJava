public class FruitMaker{
   public static void main(String[] args){
      Fruit f1 = new Apple("Apple with Fruit reference");
      Apple a1 = new Apple("Apple with Apple reference");
      
      System.out.println(f1.fruitMsg());
      System.out.println(a1.fruitMsg());
      
      System.out.println(a1);
      System.out.println(f1);
   }
}