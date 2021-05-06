public class Apple extends Fruit{
   private String name;
   
   public Apple(){
      this.name = "NO_NAME";
   }
   public Apple(String name){
      setName(name);
      System.out.println("Apple object created!");
   }
   
   public String getName(){
      return this.name;
   }
   
   public void setName(String name){
      if(name == null || name.equals("")){
         throw new IllegalArgumentException("Apple name cannot be null");
      }
      this.name = name;
   }
   
   public String toString(){
      return String.format("Fruit type: %s%nFruit name: %s%n", 
      this.getClass().getName(), 
      this.getName()
      );
   }
}