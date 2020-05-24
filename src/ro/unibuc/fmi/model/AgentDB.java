package ro.unibuc.fmi.model;

import java.util.Date;

public class AgentDB {
    private int idAng;
    private String nume;
    private int zonaAct;
    private Date registeredDateTime;

    public AgentDB(int idAng, String nume, int zonaAct, Date registeredDateTime) {
        this.idAng = idAng;
        this.nume = nume;
        this.zonaAct = zonaAct;
        this.registeredDateTime = registeredDateTime;
    }

    public AgentDB() {
    }

    public int getIdAng() {
        return idAng;
    }

    public void setIdAng(int idAng) {
        this.idAng = idAng;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getZonaAct() {
        return zonaAct;
    }

    public void setZonaAct(int zonaAct) {
        this.zonaAct = zonaAct;
    }

    public Date getRegisteredDateTime() {
        return registeredDateTime;
    }

    public void setRegisteredDateTime(Date registeredDateTime) {
        this.registeredDateTime = registeredDateTime;
    }

    @Override
    public String toString() {
        return "Agent: {" +
                "nume: " + nume + '\'' +
                ", id: " + idAng + '\'' +
                ", zona: " + zonaAct + '\'' +
                ", data inregistrare: " + registeredDateTime + '}';
    }
}
