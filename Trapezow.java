class Trapezow extends Thread
{
    double S,a,b,n;

    public  Trapezow(double a, double b)
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
        n=3;
        h = (b - a) / n;
        S = 0;

        for(int i = 1; i < n ; i++)
        {
            S = S + calka(a + i * h);
        }
        
        S = h * (S + ((calka(a) + calka(b))) / 2);
        System.out.println("Metoda trapezow: " + S);
    }
}