import javax.swing.JOptionPane;
public class NetworkMenu{
   //User String input
   public static String userString(String prompt){
      String input = JOptionPane.showInputDialog(prompt);
      return input;
   }
   
   //User int input
   public static int userInt(String prompt){
      int input = Integer.parseInt(JOptionPane.showInputDialog(prompt));
      return input;
   }
   
   //User double input
   public static double userDouble(String prompt){
      double input = Double.parseDouble(JOptionPane.showInputDialog(prompt));
      return input;
   }
   
   //Add Server
   public static void addServer(Server[] network){
	   String serverID ="";
	      //Initializing an empty server
	      Server tempServer = null;
	      boolean correct = true;
	      int intServerType =0;
	      String serverType ="";
	  do {
         serverType = userString("Enter choice for server type to create\n\n"
         +"[1] WebServer\n"
         +"[2] FileServer\n"
         +"[3] DatabaseServer\n"
         +"[0] Cancel");
      //parsing String to int
    	  try {
    	  intServerType = Integer.parseInt(serverType);
    	  }catch(NumberFormatException e) {
    		  correct = false;
       	   	  JOptionPane.showMessageDialog(null, "Must enter an integer");
    	  }  
      switch(intServerType) {
      case 1:
    	  tempServer = new WebServer();
    	  break;
      case 2:
    	  tempServer= new FileServer();
    	  break;
      case 3:
    	  tempServer = new DatabaseServer();
    	  break;
      default:
    	   JOptionPane.showMessageDialog(null, "Must choose a number between 1 and 3");
    	   correct = false;
      }
	  }
      while(correct == false && tempServer !=null);

      String os = userString("Choose Server Operating System\n\n"
         +"[1] - Windows\n"
         +"[2] - Linux\n"
         +"[3] - OS X");
      switch(os){
         case "1":
            tempServer.setOS("WINDOWS");
            break;
         case "2":
            tempServer.setOS("LINUX");
            break;
         case "3":
            tempServer.setOS("OS X");
            break;
         default:
        	 throw new IllegalArgumentException("Must enter a valid input for menu");
      }
      double capacity = userDouble("Enter Server hard drive capacity (TB)");
      tempServer.setCapacity(capacity);
      
      switch(serverType){
         case "1":
            tempServer.setServerID("WS" + String.format("%03d", WebServer.getNumWS()+1));
            int numLangs = userInt("Enter number of programming languages to create for WebServer (2-4)");
            //down casting to make sure we have the correct object
            if(tempServer instanceof WebServer) {
            ((WebServer)tempServer).setNumLangs(numLangs);
            String[] langs = new String[numLangs];
            for(int i = 0; i < numLangs; i++){
               langs[i] = userString("Enter programming language");
            }      
            ((WebServer) tempServer).setLangs(langs);
            network[Server.getNumServers()-1] = tempServer;
            }
            break;
            
         case "2":
            serverID = "FS" + String.format("%03d", FileServer.getNumFS()+1);
            
            int fsNumUsers = Integer.parseInt(JOptionPane.showInputDialog("Enter number of users for FileServer (0-4000)"));
            Server fs = new FileServer(serverID, os, capacity, fsNumUsers);
            network[Server.getNumServers()-1] = fs;
            break;
         case "3":
            serverID = "DS" + String.format("%03d", DatabaseServer.getNumDBS()+1);
            
            String app = JOptionPane.showInputDialog("Choose application for DatabaseServer\n\n"
               +"[1] - Microsoft SQL Server\n"
               +"[2] - Oracle");
            if(app.equals("1")){
               app = "MS SQL SERVER";
            }else if(app.equals("2")){
               app = "ORACLE";
            }
            int dbsNumUsers = Integer.parseInt(JOptionPane.showInputDialog("Enter number of users for DatabaseServer (0-2000)"));
            Server dbs = new DatabaseServer(serverID, os, capacity, app, dbsNumUsers);
            network[Server.getNumServers()-1] = dbs;
            break;
         case "0":
            JOptionPane.showMessageDialog(null, "Operation canceled");
            break;
         default:
            throw new IllegalArgumentException("Must enter a valid input for menu");
      }
      JOptionPane.showMessageDialog(null, "Server created successfuly!");
   }
   
   //Display All Server Information
   public static void allServerInfo(Server[] network){
      String report = "Current Network Information (All Servers)\n\n";
      double totalCapacity = 0;
      for(int i = 0; i < Server.getNumServers(); i++){
         report+= String.format("%s%n", network[i].toString());
         totalCapacity+= network[i].getCapacity();
      }
      report+= String.format("%nTotal Servers: %d%nTotal Capacity: %.2fTB", Server.getNumServers(), totalCapacity);
      JOptionPane.showMessageDialog(null, report);
   }
   
   //Display Server with Highest Usage
   public static void highestUsage(Server[] network){
      String serverType = JOptionPane.showInputDialog("Choose Server Type\n\n"
         +"[1] - WebServer\n"
         +"[2] - FileServer\n"
         +"[3] - DatabaseServer\n");
      double highestUsage = 0;
      String serverID = "";
      
      switch(serverType.toUpperCase()){
         case "1":
            serverType = "WebServer";
            break;
         case "2":
            serverType = "FileServer";
            break;
         case "3":
            serverType = "DatabaseServer";
            break;
         default:
            throw new IllegalArgumentException("Must enter a valid server type");
      }
      
      for(int i = 0; i < Server.getNumServers(); i++){
         if(network[i].getClass().getName().equals(serverType)){
            if(network[i].getUsage() > highestUsage){
               highestUsage = network[i].getUsage();
               serverID = network[i].getServerID();
            }
         }
      }
      JOptionPane.showMessageDialog(null, String.format("Server: %s     Usage: %.2f", serverID, highestUsage));
   }
   
   //Display Average Usage by Server Type
   public static void avgUsage(Server[] network){
      String serverType = JOptionPane.showInputDialog("Enter server type chice\n\n"
         +"[1] - WebServer\n"
         +"[2] - FileServer\n"
         +"[3] - DatabaseServer");
      int totalServers = 0;
      double totalUsage = 0;
      
      switch(serverType.toUpperCase()){
         case "1":
            serverType = "WebServer";
            totalServers = WebServer.getNumWS();
            break;
         case "2":
            serverType = "FileServer";
            totalServers = FileServer.getNumFS();
            break;
         case "3":
            serverType = "DatabaseServer";
            totalServers = DatabaseServer.getNumDBS();
            break;
         default:
            throw new IllegalArgumentException("Must enter a valid server type");
      }
      
      for(int i = 0; i < Server.getNumServers(); i++){
         if(network[i].getClass().getName().equals(serverType)){
            totalUsage+= network[i].getUsage();
         }
      }
      totalUsage /= totalServers;
      JOptionPane.showMessageDialog(null, String.format("Server Type: %s     Average Usage: %f", serverType, totalUsage));
   }
   
   public static void main(String[] args){
      Server[] network = new Server[Server.MAX_SERVERS];
      boolean repeat = true;
      
      do{
         try{
            String choice = JOptionPane.showInputDialog("Enter choice\n\n"
               +"[1] - Add Server\n"
               +"[2] - Display All Server Info\n"
               +"[3] - Display Highest Usage Server by Server Type\n"
               +"[4] - Display Average Usage by Server Type\n"
               +"[5] - Quit Program\n");
               
            switch(choice){
               case "1":
                  addServer(network);
                  break;
               case "2":
                  allServerInfo(network);
                  break;
               case "3":
                  highestUsage(network);
                  break;
               case "4":
                  avgUsage(network);
                  break;
               case "5":
                  repeat = false;
                  break;
               default:
                  JOptionPane.showMessageDialog(null, "Must enter valid choice for menu");
            }
         }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
         }catch(IllegalArgumentException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
         }
      }while(repeat);
   }
}