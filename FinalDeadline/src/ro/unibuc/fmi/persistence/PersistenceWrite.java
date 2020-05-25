package ro.unibuc.fmi.persistence;

import ro.unibuc.fmi.Entity.*;
import ro.unibuc.fmi.service.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PersistenceWrite {

    private static PersistenceWrite serviciu = null;

    private PersistenceWrite() {
    }

    public static PersistenceWrite getInstance() {
        if (serviciu == null)
            serviciu = new PersistenceWrite();
        return serviciu;
    }

    public void scriereCasa(CasaService Serviciu) {
        List<Casa> listaCase = new ArrayList<>(Serviciu.getListaCase());
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("casa.csv"))) {
            for (Casa casa : listaCase) {
                bufferedWriter.write(casa.getId() + "," + casa.getAdresa() + "," + casa.getZona() + "," + casa.getSuprafata() + "," + casa.getPretMp() + "," + casa.isInchiriere() + "," + casa.getNrNivele() + "," + casa.getNrCamere() + "," + casa.isPiscina() + "," + casa.isGradina());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("Could not write data to file: " + e.getMessage());
        }
    }

    /*public void scriereApartament(ApartamentService Serv) {
        List<Apartament> listaApart = new ArrayList<>(Serv.getListaApart());
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("apart.csv"))) {
            for (Apartament apart : listaApart) {
                bufferedWriter.write(apart.getId() + "," + apart.getAdresa() + "," + apart.getZona() + "," + apart.getSuprafata() + "," + apart.getPretMp() + "," + apart.isInchiriere() + "," + apart.getEtaj() + "," + apart.getNrBai() + "," + apart.getNrCamere() + "," + apart.isTerasa());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("Could not write data to file: " + e.getMessage());
        }
    }*/

    public void scriereBirou(BirouService Serv) {
        List<Birou> listaBirou = new ArrayList<>(Serv.getListaBirouri());
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("birou.csv"))) {
            for (Birou birou : listaBirou) {
                bufferedWriter.write(birou.getId() + "," + birou.getAdresa() + "," + birou.getZona() + "," + birou.getSuprafata() + "," + birou.getPretMp() + "," + birou.isInchiriere() + "," + birou.getNrNivele() + "," + birou.getEtaj());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("Could not write data to file: " + e.getMessage());
        }
    }

    public void scriereDepozit(DepozitService Serv) {
        List<Depozit> listaDep = new ArrayList<>(Serv.getListaDep());
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("depozit.csv"))) {
            for (Depozit dep : listaDep) {
                bufferedWriter.write(dep.getId() + "," + dep.getAdresa() + "," + dep.getZona() + "," + dep.getSuprafata() + "," + dep.getPretMp() + "," + dep.isInchiriere() + "," + dep.getInaltime());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("Could not write data to file: " + e.getMessage());
        }
    }

    public void scriereTeren(TerenService Serv) {
        Set<Teren> listaTeren = new HashSet<>(Serv.getListaTeren());
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("teren.csv"))) {
            for (Teren teren : listaTeren) {
                bufferedWriter.write(teren.getId() + "," + teren.getAdresa() + "," + teren.getZona() + "," + teren.getSuprafata() + "," + teren.getPretMp() + "," + teren.isInchiriere());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("Could not write data to file: " + e.getMessage());
        }
    }
}