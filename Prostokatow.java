class Prostokatow extends Thread
{
    double S,a,b,n;

    public Prostokatow(double a, double b)
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
        double h;
        n = 3;
        h = (b - a) / n;
        S = 0;
        for (int i = 1; i <= n; i++)
        {
            S += calka(a + i * h);
        }
        S *= h;
        System.out.println("Metoda prostokatow: " + S);
    }
}