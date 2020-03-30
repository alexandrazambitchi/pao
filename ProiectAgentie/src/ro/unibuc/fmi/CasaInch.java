package ro.unibuc.fmi;

public class CasaInch extends Imobil implements Inchiriere {
    private int nrNivele, nrCamere;
    private boolean piscina, gradina;
    private double pretMp;

    public CasaInch(String adresa, int zona, int suprafata, int nrNivele, int nrCamere, boolean piscina, boolean gradina, double pretMp) {
        super(adresa, zona, suprafata);
        this.nrNivele = nrNivele;
        this.nrCamere = nrCamere;
        this.piscina = piscina;
        this.gradina = gradina;
        this.pretMp = pretMp;
    }

    @Override
    public double pretLuna() {
        double suma = 0;
        if (getZona() == 1) {
            if (piscina && gradina)
                suma = pretMp * getSuprafata() * 1.2;
            else if (piscina)
                suma = pretMp * getSuprafata() * 1.1;
            else if (gradina)
                suma = pretMp * getSuprafata();
        }
        if (getZona() == 2) {
            if (piscina && gradina)
                suma = pretMp * getSuprafata() * 1.15;
            else if (piscina)
                suma = pretMp * getSuprafata() * 1.05;
            else if (gradina)
                suma = pretMp * getSuprafata();
        }
        if (getZona() == 3) {
            if (piscina && gradina)
                suma = pretMp * getSuprafata() * 1.1;
            else if (piscina)
                suma = pretMp * getSuprafata() * 1.05;
            else if (gradina)
                suma = pretMp * getSuprafata();
        }
        return suma / 12;
    }

    @Override
    public double cheltuieliFixe() {
        double suma = 0;
        if (getZona() == 1) {
            if (piscina && gradina)
                suma = nrCamere * 1.5 + 300;
            else if (piscina)
                suma = nrCamere * 1.3 + 300;
            else if (gradina)
                suma = nrCamere * 1.2 + 300;
        }
        if (getZona() == 2) {
            if (piscina && gradina)
                suma = nrCamere * 1.4 + 200;
            else if (piscina)
                suma = nrCamere * 1.2 + 200;
            else if (gradina)
                suma = nrCamere * 1.1 + 200;
        }
        if (getZona() == 3) {
            if (piscina && gradina)
                suma = nrCamere * 1.3 + 150;
            else if (piscina)
                suma = nrCamere * 1.1 + 150;
            else if (gradina)
                suma = nrCamere + 150;
        }
        return suma;
    }

    @Override
    public double totalCheltuieli() {
        return pretLuna() + cheltuieliFixe();
    }

    @Override
    public void afisare() {
        System.out.println("Casa de inchiriat se afla in zona " + getZona() + ", " + getAdresa());
        System.out.println("Are suprafata " + getSuprafata() + "mp, impartita in " + nrCamere + " camere si " + nrNivele + " etaje");
        if (piscina)
            System.out.println("Dispune de piscina");
        else System.out.println("Nu dispune de piscina");
        if (gradina)
            System.out.println("Dispune de gradina");
        else System.out.println("Nu dispune de gradina");
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
        if (gradina && piscina)
            afisare();
    }

    @Override
    public void apartamentEtaj(int value) {
    }

    @Override
    public void cautarePretCump(double x, double y) {

    }

    @Override
    public void cautarePretInch(double x, double y) {
        if (pretLuna() >= x && pretLuna() <= y)
            afisare();
    }

    @Override
    public void casaVanzZona(int value) {
    }

    @Override
    public void apartTerasaZona(int value) {
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
