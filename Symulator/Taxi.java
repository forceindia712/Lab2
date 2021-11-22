import java.util.Random;

public class Taxi extends Thread {
    
    static int CENTRALA = 1;
    static int START = 2;
    static int TRASA = 3;
    static int KONIEC_TRASY = 4;
    static int WYPADEK = 5;
    static int ILOSC_PALIWA = 1000;
    static int REZERWA = 100;

    int numer;
    int paliwo;
    int stan;
    Dyspozycja c;
    Random rand;

    public Taxi(int numer, int paliwo, Dyspozycja c)
    {
        this.numer = numer;
        this.paliwo = paliwo;
        this.stan = TRASA;
        this.c = c;
        rand = new Random();
    }

    public void run()
    {
        while(true)
        {
            if(stan == CENTRALA)
            {
                if(rand.nextInt(2) == 1)
                {
                    stan = START;
                    paliwo = ILOSC_PALIWA;
                    System.out.println("Proszê o zlecenie: " + numer);
                    stan = c.start(numer);
                }
                else
                {
                    System.out.println("Brak zleceñ");
                }
            }
            else if(stan == START)
            {
                System.out.println("TAXI " + numer + " rozpoczyna zlecenie");
                stan= TRASA;
            }
            else if(stan == TRASA)
            {
                paliwo -= rand.nextInt(300);
                System.out.println("TAXI " + numer + " w trasie");
                if(paliwo <= REZERWA)
                {
                    stan = KONIEC_TRASY;
                }
                else try
                {
                    sleep(rand.nextInt(1000));
                }
                catch (Exception e){}
            }
            else if(stan == KONIEC_TRASY)
            {
                System.out.println("Zjezdzam na postój: " + numer + " ilosc paliwa " + paliwo);
                stan = c.koniec();
                if(stan == KONIEC_TRASY)
                {
                    paliwo -= rand.nextInt(300);
                    System.out.println("REZERWA, stan paliwa " + paliwo);
                    if(paliwo <= 0) stan = WYPADEK;
                }
            }
            else if(stan == WYPADEK)
            {
                System.out.println("WYPADEK TAXI nr "+ numer);
                c.zmniejsz();
            }
        }
    }
}