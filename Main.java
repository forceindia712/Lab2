
public class Main {

	public static void main(String[] args)
	{
		Prostokatow prostokat = new Prostokatow(3,5);
		Simpsona simpsona = new Simpsona(3,5);
		Trapezow trapez = new Trapezow(3,5);
		
		prostokat.start();
		simpsona.start();
		trapez.start();
		
		try {
			prostokat.join();
			simpsona.join();
			trapez.join();
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		
		double S = prostokat.S + trapez.S + simpsona.S;
		
		System.out.println(S);
	}
	 
}
