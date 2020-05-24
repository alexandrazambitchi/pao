package ro.unibuc.fmi.service;

import ro.unibuc.fmi.Entity.Agent;
import ro.unibuc.fmi.persistence.PersistenceRead;
import ro.unibuc.fmi.persistence.PersistenceWrite;

import java.io.*;
import java.util.*;

public class AgentService {

    private List<Agent> listaAgenti = new ArrayList<>();
    private AuditService auditService;
    private Agent agent = new Agent();
    private PersistenceRead persistentaR = PersistenceRead.getInstance();
    private PersistenceWrite persistentaW = PersistenceWrite.getInstance();

    public AgentService() throws FileNotFoundException {
    }

    public List<Agent> getListaAgenti() {
        return listaAgenti;
    }

    public void setListaAgenti(List<Agent> listaAgenti) {
        this.listaAgenti = listaAgenti;
    }

    public void addAgent(int id, String nume, int zona) {
        Agent ag = new Agent(id, nume, zona);
        listaAgenti.add(ag);
        auditService.writeAudit("Adaugare agent");
    }

    public void writeInFile(){

    }
}
