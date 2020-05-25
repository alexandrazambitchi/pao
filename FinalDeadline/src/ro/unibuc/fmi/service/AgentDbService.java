package ro.unibuc.fmi.service;

import ro.unibuc.fmi.model.AgentDB;
import ro.unibuc.fmi.repository.AgentRepository;

import java.util.Date;

public class AgentDbService {
    private static AgentDbService instance;

    private final AgentRepository agentRepository = AgentRepository.getInstance();

    public static AgentDbService getInstance(){
        if(instance == null){
            instance=new AgentDbService();
        }
        return instance;
    }

    public AgentDB saveAgent(int id, String nume, int zona, Date registeredDateTime) {
        AgentDB agentDB=new AgentDB();
        agentDB.setIdAng(id);
        agentDB.setNume(nume);
        agentDB.setZonaAct(zona);
        agentDB.setRegisteredDateTime(registeredDateTime);

        return agentRepository.saveAgent(agentDB);
    }

    public AgentDB findAgent(int id) {
        return agentRepository.findAgent(id);
    }

    public AgentDB updateAgent(AgentDB agentDB) {
        return agentRepository.updateAgent(agentDB);
    }

    public boolean deleteAgent(AgentDB agentDB) {
        return agentRepository.deleteAgent(agentDB.getIdAng());
    }

    public AgentDB findNewest() {
        return agentRepository.findNewest();
    }
}