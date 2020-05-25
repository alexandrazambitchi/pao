package ro.unibuc.fmi.model;

import java.util.Date;

public class ApartmentDB {
    private int id;
    private String adresa;
    private int zona;
    private int suprafata;
    private double pretMp;
    private int etaj;
    private int nrBai;
    private int nrCamere;
    private Date registeredDateTime;

    public ApartmentDB(int id, String adresa, int zona, int suprafata, double pretMp, int etaj, int nrBai, int nrCamere, Date registeredDateTime) {
        this.id = id;
        this.adresa = adresa;
        this.zona = zona;
        this.suprafata = suprafata;
        this.pretMp = pretMp;
        this.etaj = etaj;
        this.nrBai = nrBai;
        this.nrCamere = nrCamere;
        this.registeredDateTime = registeredDateTime;
    }

    public ApartmentDB() {
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

    public int getEtaj() {
        return etaj;
    }

    public void setEtaj(int etaj) {
        this.etaj = etaj;
    }

    public int getNrBai() {
        return nrBai;
    }

    public void setNrBai(int nrBai) {
        this.nrBai = nrBai;
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
        return "Apartament {" +
                "adresa: " + adresa + '\'' +
                ", zona: " + zona + '\'' +
                ", suprafata: " + suprafata + '\'' +
                ", pretMp: " + pretMp + '\'' +
                ", etaj: " + etaj + '\'' +
                ", numar camere: " + nrCamere + '\'' +
                ", numar bai: " + nrBai + '\'' +
                ", data inregistrare: " + registeredDateTime + '}';
    }
}