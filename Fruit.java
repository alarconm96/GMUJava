public class Fruit{
   private String name;
   
   public Fruit(){
      this.name = "NO_NAME";
   }
   public Fruit(String name){
      setName(name);
      System.out.println("Fruit object created!");
   }
   
   public String getName(){
      return this.name;
   }
   
   public void setName(String name){
      if(name == null || name.equals("")){
         throw new FruitNameException("Fruit name cannot be null");
      }
      this.name = name;
   }
   
   public String fruitMsg(){
      return "THIS IS A FRUIT TALKING!";
   }
   
   public String toString(){
      return String.format("Fruit type: %s%nFruit name: %s%n", 
      this.getClass().getName(), 
      this.getName() 
      );
   }
}
