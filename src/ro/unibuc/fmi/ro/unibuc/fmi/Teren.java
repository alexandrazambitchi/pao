package ro.unibuc.fmi;

public class Teren extends Imobil implements Vanzare {

    public Teren() {
    }

    public Teren(int id, String adresa, int zona, int suprafata, double pretMp, boolean inchiriere) {
        super(id, adresa, zona, suprafata, pretMp, inchiriere);
    }

    @Override
    public double pret() {
        if (getZona() == 1)
            return getPretMp() * getSuprafata() * 1.3;
        if (getZona() == 2)
            return getPretMp() * getSuprafata() * 1.1;
        return getPretMp() * getSuprafata();
    }

    @Override
    public void afisare() {
        System.out.println("Terenul se afla in zona " + getZona() + ", " + getAdresa());
        System.out.println("Are suprafata " + getSuprafata() + "mp");
        System.out.println("Pret " + pret());
    }

    @Override
    public void cautarePret(double x, double y) {
        if (pret() >= x && pret() <= y)
            afisare();
    }

    @Override
    public void afisare_zona(int zona_cautata) {
        if (getZona() == zona_cautata)
            afisare();
    }

    public void terenMare(int value) {
        if (getSuprafata() >= value)
            afisare();
    }

}
