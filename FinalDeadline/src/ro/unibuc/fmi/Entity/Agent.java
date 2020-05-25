package ro.unibuc.fmi.Entity;

public class Agent {
    private int idAng;
    private String nume;
    private int zonaAct;

    public Agent(int idAng, String nume, int zonaAct) {
        this.idAng = idAng;
        this.nume = nume;
        this.zonaAct = zonaAct;
    }

    public Agent() {
    }

    public String getNume() {
        return nume;
    }

    public int getZonaAct() {
        return zonaAct;
    }

    public void afisare() {
        System.out.println("Angajatul " + nume + " lucreaza in zona " + zonaAct);
    }
}
