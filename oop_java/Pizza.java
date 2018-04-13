import java.io.*;

interface Topping 
	{
		void addtopping();
	}

class pepperoni implements Topping 
	{
	public void addtopping() 
		{
			System.out.println("\tPepperoni topping added.");
		}
	}

class sausage implements Topping 
	{
		public void addtopping() 
		{
			System.out.println("\tSausage topping added.");
		}
	}

class anchovy implements Topping 
	{
	public void addtopping() 
		{
			System.out.println("\tAnchovy topping added.");
		}
	}






abstract class AbstractFactory 
	{
	
		abstract public Topping gettopping(String type);
	
}



class PizzaFactory extends AbstractFactory 
	{
	
		public Topping gettopping(String type) 
		{
            
			if(type == null)
			{
               
				return null;
            
			}
            
			
			else if(type.equalsIgnoreCase("PEPPERONI")) 
			{
               
				return new pepperoni();
            
			}
            

			else if(type.equalsIgnoreCase("SAUSAGE")) 
			{
               
				return new sausage();
            
			}
            

			else if(type.equalsIgnoreCase("ANCHOVY")) 
			{
               
				return new anchovy();
            
			}
            
			else
			{
				return null;
			}
	
		}

	}






class PizzaProducer 
{
     
	public static AbstractFactory getFactory() 
	{
            
		return new PizzaFactory();
     
	}

}



class Pizza 
{
     	
	public static void main(String[] args) throws IOException 
	{
     	       
		int choice;
           	
		String type;
           
           	
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
           
           	
		
          	System.out.print("\n******WELCOME******\n\n");

          	
          	
          	
		while(true) 
		{
           		
			System.out.print("1. CONTINUE TO ADD TOOPLING\n");
          		System.out.print("2. EXIT\n");
          		System.out.print("\tENTER YOUR CHOICE : ");
           		
			choice = Integer.parseInt(input.readLine());
           		
			if(choice == 2){
           			
           			System.out.println("\n****THANK YOU*****\n");
				break;
			}
			
           		
			else if(choice != 1)
           			
				System.out.println("\tEntered wrong choice.\n");
                 	
			System.out.print("\tType of Topping : ");
                 	
			type = input.readLine();
                 	
			AbstractFactory factory = PizzaProducer.getFactory();
                 	
			Topping topping = factory.gettopping(type);
                 	
			
			if(topping != null)
                 		
				topping.addtopping();
                 	
			else 
                		
				System.out.println("\n\tNo such topping available..");
           
		}
    }
}
