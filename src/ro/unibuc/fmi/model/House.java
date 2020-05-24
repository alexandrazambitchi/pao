package ro.unibuc.fmi.model;

import java.util.Date;

public class House {
    private int id;
    private String adresa;
    private int zona;
    private int suprafata;
    private double pretMp;
    private int nrNivele;
    private int nrCamere;
    private Date registeredDateTime;

    public House() {
    }

    public House(int id, String adresa, int zona, int suprafata, double pretMp, int nrNivele, int nrCamere, Date registeredDateTime) {
        this.id = id;
        this.adresa = adresa;
        this.zona = zona;
        this.suprafata = suprafata;
        this.pretMp = pretMp;
        this.nrNivele = nrNivele;
        this.nrCamere = nrCamere;
        this.registeredDateTime=registeredDateTime;
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

    public int getNrCamere() {
        return nrCamere;
    }

    public void setNrCamere(int nrCamere) {
        this.nrCamere = nrCamere;
    }

    public Date getRegisteredDateTime() {
        return registeredDateTime;
    }

    public void setRegisteredDateTime(Date registeredDateTime) {
        this.registeredDateTime = registeredDateTime;
    }

    @Override
    public String toString() {
        return "Casa {"+
                "adresa: "+ adresa+'\''+
                ", zona: "+zona+'\''+
                ", suprafata: " +suprafata+'\''+
                ", pretMp: "+pretMp+'\''+
                ", numar nivele: "+ nrNivele+'\''+
                ", numar camere: "+nrCamere+'\''+
                ", data inregistrare: "+registeredDateTime+'}';
    }
}
