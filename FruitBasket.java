public class FruitBasket{
   private String name;
   private Fruit[] basket;
   
   static final int MAX_BASKET = 3;
   
   public FruitBasket(Fruit[] basket){
      this.basket = new Fruit[MAX_BASKET];
      if(basket == null){
         throw new IllegalArgumentException("No array found");
      }
      if(basket.length != MAX_BASKET){
         throw new IllegalArgumentException("Array must be length of 3");
      }
      for(int i = 0; i < basket.length; i++){
         this.basket[i] = basket[i];
      }
   }
   
   public Fruit[] getBasket(){
      Fruit[] tempBasket = new Fruit[MAX_BASKET];
      for(int i = 0; i < tempBasket.length; i++){
         tempBasket[i] = this.basket[i];
      }
      return tempBasket;
   }
   
   public void resetBasket(Fruit[] basket){
      Fruit[] newBasket = new Fruit[MAX_BASKET];
      if(basket == null){
         throw new IllegalArgumentException("No array found");
      }
      if(basket.length != MAX_BASKET){
         throw new IllegalArgumentException("Array must be length of 3");
      }
      for(int i = 0; i < basket.length; i++){
         this.basket[i] = basket[i];
      }
   }
}