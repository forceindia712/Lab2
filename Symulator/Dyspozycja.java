public class Dyspozycja {

    static int CENTRALA = 1;
    static int START = 2;
    static int TRASA = 3;
    static int KONIEC_TRASY = 4;
    static int WYPADEK = 5;
    int iloscTras;
    int iloscZajetych;
    int iloscTaksowek;

    Dyspozycja(int iloscLinii,int iloscTaksowek)
    {
        this.iloscTras = iloscLinii;
        this.iloscTaksowek = iloscTaksowek;
        this.iloscZajetych = 0;
    }

    synchronized int start(int numer)
    {
        iloscZajetych--;
        System.out.println("Zlecenie dla numeru " + numer);
        return START;
    }

    synchronized int koniec()
    {
        try
        {
            Thread.currentThread();
			Thread.sleep(1000);
        }
        catch(Exception ie)
        {
        }

        if(iloscZajetych < iloscTras)
        {
            iloscZajetych++;
            System.out.println("Brak zlecen");
            return CENTRALA;
        }
        else
        {
            return KONIEC_TRASY;
        }
    }

    synchronized void zmniejsz()
    {
        iloscTaksowek--;
        System.out.println("Wypadek");
        if(iloscTaksowek == iloscTras) System.out.println("Brak zleceñ");
    }
}