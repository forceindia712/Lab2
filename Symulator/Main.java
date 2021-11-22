public class Main 
{
    static int ilosc_taksowek = 10000;
    static int ilosc_tras = 30;
    static Dyspozycja centrala;

    public static void main(String[] args) {

        centrala = new Dyspozycja(ilosc_tras, ilosc_taksowek);

        for(int i = 0; i < ilosc_taksowek; i++)
        {
            new Taxi(i, 1000, centrala).start();
        }
    }
}
