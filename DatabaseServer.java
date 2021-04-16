public class DatabaseServer extends Server{
   //Instance variables
   private double usage;
   private String app;
   private int numUsers;
   
   //Static variables
   public static int numDBS = 0;
   
   //Constants
   public static final String[] VALID_APPS = {"MS SQL SERVER", "ORACLE"};
   public static final int MAX_USERS = 2000;
   public static final double USAGE_RATE = 0.05;
   
   //Constructor
   public DatabaseServer(String serverID, String os, double capacity, String app, int numUsers){
      super(serverID, os, capacity);
      setApp(app);
      setNumUsers(numUsers);
      setUsage();
      numDBS++;
   }
   
   //Accessors
   public double getUsage(){return this.usage;}
   public String getApp(){return this.app;}
   public int getNumUsers(){return this.numUsers;}
   
   public static int getNumDBS(){return numDBS;}
   
   //Mutators
   public void setUsage(){
      if(this.getNumUsers() < 0 || this.getNumUsers() > MAX_USERS){
         throw new IllegalArgumentException("Number of users must be between 0-2000");
      }
      this.usage = this.getNumUsers() * USAGE_RATE;
   }
   
   public void setApp(String app){
      boolean valid = false;
      app = app.toUpperCase();
      for(String x : VALID_APPS){
         if(app.equals(x)){
            valid = true;
         }
      }
      if(!valid){
         throw new IllegalArgumentException("DB Server application must be either Microsoft SQL Server or Oracle");
      }
      this.app = app;
   }
   
   public void setNumUsers(int numUsers){
      if(numUsers < 0 || numUsers > MAX_USERS){
         throw new IllegalArgumentException("Number of users must be between 0-2000");
      }
      this.numUsers = numUsers;
   }
   
   //Special Purpose
   public String toString(){
      return String.format(
         "Server ID: %s     OS: %s     HardDrive Capacity: %.2f     Server Usage: %.2f     Number of Users: %d     DB Server Application: %s", super.getServerID(), super.getOS(), super.getCapacity(), this.usage, this.numUsers, this.app
      );
   }
   
   public boolean equals(Object o){
      if(this == o){
         return true;
      }
      if(!(o instanceof Server)){
         return false;
      }
      DatabaseServer d = (DatabaseServer) o;
      return this.getServerID().equals(d.getServerID()) &&
         this.getOS().equals(d.getOS()) &&
         this.getCapacity() == d.getCapacity() &&
         this.getUsage() == d.getUsage() &&
         this.getNumUsers() == d.getNumUsers() &&
         this.getApp().equals(d.getApp());
   }
}