
// SATVIR SINGH ANUSHA SWAMY//


public class WarringNeighbours
		{
		public static void main(String[] args)
		{
			System.out.println("Creating flag1 & flag2 shared objects ...");
			Field f = new Field();
			Neighbor c[] = new Neighbor[2];
		for(int i = 0; i<=1; i++)
			{
			System.out.println("Creating Neighbor  [" + (i+1) + "] thread ...");
			c[i] = new Neighbor(f, (i+1));
			c[i].start();	
			}
		}	
		}
class Neighbor extends Thread implements Runnable
	{
		Field f;
		int n;
		public Neighbor(Field f, int n){
		this.f = f;
		this.n = n;
		
	}
	public void run()
		{
		while (true)
			{
			
			try 
				{
				f.rise(n);
				}
			catch (InterruptedException e1)
				{
				// TODO Auto-generated catch block
				e1.printStackTrace();
				}	
			f.enterField(n);
			try
			{
				Thread.sleep(500); 
			} catch (Exception e)
			{ return;}
			f.pickBerries(n);
			try
			{
				Thread.sleep(500); 
            } catch (Exception e)
			{ return;}
			f.exitField(n);
		}
	}
}
class Field
{
    boolean flag1 = false;
    boolean flag2 = false;
    boolean wait = false;
    

	public synchronized void rise(int n) throws InterruptedException{
		if(n == 1)
		{
			while(flag2)
			{
				wait = true;
				wait();
			}
			flag1 = true;
		}
		else if(n == 2)
		{
			while(flag1)
			{
				wait = true;
				wait();
			}
			flag2 = true;
		}
    }


	public synchronized void exitField(int n){
		if(n == 1)
		{
			flag1 = false;
			System.out.println("n" + n + " exits the field");
			if(wait)
			{
				wait = false;
				notifyAll();
			}
		}
		else if(n == 2)
		{
			flag2 = false;
			System.out.println("n" + n + " exits the field");
			if(wait)
			{
				wait = false;
				notifyAll();
			}
		}
		
	}

	public synchronized void enterField(int n)
	{
		if(n == 1)
		{
			System.out.println("n" + n + " enters the field");
		}
		else if(n == 2)
		{
		System.out.println("n" + n + " enters the field");
		}
	
	}
	
	public synchronized void pickBerries(int n)
		{
		if(n == 1)
		{
			System.out.println("\tn" + n + " is picking wild berries.........");
		}
		else if(n == 2)
		{
			System.out.println("\tn" + n + " is picking wild berries.........");
		}
		
		}
}