package ro.unibuc.fmi.model;

import java.util.Date;

public class Office {
    private int id;
    private String adresa;
    private int zona;
    private int suprafata;
    private double pretMp;
    private int nrNivele;
    private int etaj;
    private Date registeredDateTime;

    public Office(int id, String adresa, int zona, int suprafata, double pretMp, int nrNivele, int etaj, Date registeredDateTime) {
        this.id = id;
        this.adresa = adresa;
        this.zona = zona;
        this.suprafata = suprafata;
        this.pretMp = pretMp;
        this.nrNivele = nrNivele;
        this.etaj = etaj;
        this.registeredDateTime = registeredDateTime;
    }

    public Office() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public int getZona() {
        return zona;
    }

    public void setZona(int zona) {
        this.zona = zona;
    }

    public int getSuprafata() {
        return suprafata;
    }

    public void setSuprafata(int suprafata) {
        this.suprafata = suprafata;
    }

    public double getPretMp() {
        return pretMp;
    }

    public void setPretMp(double pretMp) {
        this.pretMp = pretMp;
    }

    public int getNrNivele() {
        return nrNivele;
    }

    public void setNrNivele(int nrNivele) {
        this.nrNivele = nrNivele;
    }

    public int getEtaj() {
        return etaj;
    }

    public void setEtaj(int etaj) {
        this.etaj = etaj;
    }

    public Date getRegisteredDateTime() {
        return registeredDateTime;
    }

    public void setRegisteredDateTime(Date registeredDateTime) {
        this.registeredDateTime = registeredDateTime;
    }

    @Override
    public String toString() {
        return "Birou: {" +
                "adresa: " + adresa + '\'' +
                ", zona: " + zona + '\'' +
                ", suprafata: " + suprafata + '\'' +
                ", pretMp: " + pretMp + '\'' +
                ", etaj: " + etaj + '\'' +
                ", numarNivele: " + nrNivele + '\'' +
                ", data inregistrare: " + registeredDateTime + '}';
    }
}
