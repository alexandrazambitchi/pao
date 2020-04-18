package ro.unibuc.fmi;

public class Casa extends Imobil implements Vanzare, Inchiriere {
    private int nrNivele;
    private int nrCamere;
    private boolean piscina;
    private boolean gradina;

    public Casa() {
    }

    public Casa(int id, String adresa, int zona, int suprafata, double pretMp, boolean inchiriere, int nrNivele, int nrCamere, boolean piscina, boolean gradina) {
        super(id, adresa, zona, suprafata, pretMp, inchiriere);
        this.nrNivele = nrNivele;
        this.nrCamere = nrCamere;
        this.piscina = piscina;
        this.gradina = gradina;
    }

    public int getNrNivele() {
        return nrNivele;
    }

    public int getNrCamere() {
        return nrCamere;
    }

    public boolean isPiscina() {
        return piscina;
    }

    public boolean isGradina() {
        return gradina;
    }

    @Override
    public double pret() {
        double comision = 1;
        if (piscina && gradina)
            comision = 1.3;
        else if (piscina)
            comision = 1.2;
        else if (gradina)
            comision = 1.1;
        return getZona() * getPretMp() * nrCamere * getSuprafata() * comision;

    }

    @Override
    public void afisare() {
        if (!isInchiriere()) {
            System.out.println("Casa de vanzare se afla in zona " + getZona() + ", " + getAdresa());
            System.out.println("Are suprafata " + getSuprafata() + "mp, impartita in " + nrCamere + " camere si " + nrNivele + " etaje");
            if (piscina)
                System.out.println("Dispune de piscina");
            else System.out.println("Nu dispune de piscina");
            if (gradina)
                System.out.println("Dispune de gradina");
            else System.out.println("Nu dispune de gradina");
            System.out.println("Pret: " + pret());
        } else {
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

    }


    public void CaseGradinasiPiscina() {
        if (gradina && piscina)
            afisare();
    }

    public void cautarePretInch(double x, double y) {
        if (isInchiriere())
            if (pretLuna() >= x && pretLuna() <= y)
                afisare();
    }

    public void casaVanzZona(int value) {
        if (getZona() == value && !isInchiriere())
            afisare();
    }

    public void cautarePretCump(double x, double y) {
        if (!isInchiriere())
            cautarePret(x, y);
    }


    @Override
    public double pretLuna() {
        double suma = 0;
        if (getZona() == 1) {
            if (piscina && gradina)
                suma = getPretMp() * getSuprafata() * 1.2;
            else if (piscina)
                suma = getPretMp() * getSuprafata() * 1.1;
            else if (gradina)
                suma = getPretMp() * getSuprafata();
        }
        if (getZona() == 2) {
            if (piscina && gradina)
                suma = getPretMp() * getSuprafata() * 1.15;
            else if (piscina)
                suma = getPretMp() * getSuprafata() * 1.05;
            else if (gradina)
                suma = getPretMp() * getSuprafata();
        }
        if (getZona() == 3) {
            if (piscina && gradina)
                suma = getPretMp() * getSuprafata() * 1.1;
            else if (piscina)
                suma = getPretMp() * getSuprafata() * 1.05;
            else if (gradina)
                suma = getPretMp() * getSuprafata();
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
    public void cautarePret(double x, double y) {
        if (!isInchiriere())
            if (pret() >= x && pret() <= y)
                afisare();
            else if (pretLuna() >= x && pretLuna() <= y)
                afisare();
    }

    @Override
    public void afisare_zona(int zona_cautata) {
        if (getZona() == zona_cautata)
            afisare();
    }
}
