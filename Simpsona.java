class Simpsona extends Thread
{
    double S,a,b,n;

    public  Simpsona(double a, double b)
    {
        this.a = a;
        this.b = b;
    }

	private static double calka(double x)
    {
    	return x*x+x+2;
    }

    public void run()
    {
        double h, ti;
        n=3;
        h = (b - a) / n;
        S = 0;
        ti = 0;

        for(int i = 1; i < n; i++)
        {
            ti = ti + calka((a + i * h) - h / 2);
            S = S + calka(a + i * h);
        }
        ti = ti + calka(b - h / 2);
        S = (calka(a) + calka(b) + 2 * S + 4 * ti) * (h / 6);
        System.out.println("Metoda Simpsona: " + S);
    }
}