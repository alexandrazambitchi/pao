package ro.unibuc.fmi;

public class ApartInch extends Imobil implements Inchiriere {
    private int etaj, nrBai, nrCamere;
    private boolean terasa;
    private double pretMp;

    public ApartInch(String adresa, int zona, int suprafata, int etaj, int nrBai, int nrCamere, boolean terasa, double pretMp) {
        super(adresa, zona, suprafata);
        this.etaj = etaj;
        this.nrBai = nrBai;
        this.nrCamere = nrCamere;
        this.terasa = terasa;
        this.pretMp = pretMp;
    }

    public int getEtaj() {
        return etaj;
    }

    public int getNrBai() {
        return nrBai;
    }

    public int getNrCamere() {
        return nrCamere;
    }

    public boolean isTerasa() {
        return terasa;
    }


    @Override
    public double pretLuna() {
        double suma = 0;
        if (getZona() == 1) {
            if (terasa)
                suma = pretMp * getSuprafata() * 1.2;
            else
                suma = pretMp * getSuprafata();
        }
        if (getZona() == 2) {
            if (terasa)
                suma = pretMp * getSuprafata() * 1.1;
            else
                suma = pretMp * getSuprafata();
        }
        if (getZona() == 3) {
            suma = pretMp * getSuprafata();
        }
        return suma/12;
    }

    @Override
    public double cheltuieliFixe() {
        double suma = 0;
        if (getZona() == 1) {
            if (terasa)
                suma = (nrCamere + nrBai) * 1.5 + 300;
            else
                suma = (nrCamere + nrBai) * 1.3 + 300;
        }
        if (getZona() == 2) {
            if (terasa)
                suma = (nrCamere + nrBai) * 1.4 + 200;
            else
                suma = (nrCamere + nrBai) * 1.2 + 200;
        }
        if (getZona() == 3) {
            if (terasa)
                suma = (nrCamere + nrBai) * 1.3 + 150;
            else
                suma = (nrCamere + nrBai) * 1.1 + 150;
        }
        return suma;
    }

    @Override
    public double totalCheltuieli() {
        return pretLuna() + cheltuieliFixe();
    }

    @Override
    public void afisare() {
        System.out.println("Apartamentul de inchiriat se afla in zona " + getZona() + ", " + getAdresa() + ", la etajul " + etaj);
        System.out.println("Are suprafata " + getSuprafata() + "mp, impartita in " + nrCamere + " camere si " + nrBai + " bai");
        if (terasa)
            System.out.println("Dispune de terasa");
        else System.out.println("Nu dispune de terasa");
        System.out.println("Pret chirie pe luna: " + pretLuna());
        System.out.println("Cheltuieli fixe: " + cheltuieliFixe());
        System.out.println("Total " + totalCheltuieli());
    }

    @Override
    public void afisare_zona(int value) {
        if (value == getZona())
            afisare();
    }

    @Override
    public void cautarePret(double x, double y) {
        if (totalCheltuieli() >= x && totalCheltuieli() <= y)
            afisare();
    }

    @Override
    public void CaseGradinasiPiscina() {
    }

    @Override
    public void apartamentEtaj(int value) {
        if (etaj >= value)
            afisare();
    }

    @Override
    public void cautarePretCump(double x, double y) {
    }

    @Override
    public void cautarePretInch(double x, double y) {
        cautarePret(x, y);
    }

    @Override
    public void casaVanzZona(int value) {
    }

    @Override
    public void apartTerasaZona(int value) {
        if (terasa && getZona() == value)
            afisare();
    }

    @Override
    public void depozitH(double value) {
    }

    @Override
    public void birouriEtaje(int value) {
    }

    @Override
    public void terenMare(int value) {
    }
}
