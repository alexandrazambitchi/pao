package ro.unibuc.fmi;

import java.io.*;
import java.util.*;

public class Persistenta {
    private static Persistenta serviciu = null;

    private Persistenta() {
    }

    public static Persistenta getInstance() {
        if (serviciu == null)
            serviciu = new Persistenta();
        return serviciu;
    }

    public static <T> List<T> citire(T ob, ImobilService Serv) {
        List<T> templateArray = new ArrayList<>();
        if (ob instanceof Casa) {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader("casa.csv"))) {
                String currentLine;
                while ((currentLine = bufferedReader.readLine()) != null) {
                    String[] dataFields = currentLine.split(",");
                    Casa imobil = new Casa(Integer.parseInt(dataFields[0]), dataFields[1], Integer.parseInt(dataFields[2]), Integer.parseInt(dataFields[3]), Double.parseDouble(dataFields[4]), Boolean.parseBoolean(dataFields[5]), Integer.parseInt(dataFields[6]), Integer.parseInt(dataFields[7]), Boolean.parseBoolean(dataFields[8]), Boolean.parseBoolean(dataFields[9]));
                    templateArray.add((T) imobil);
                }
            } catch (IOException e) {
                System.out.println("Could not read data from file: " + e.getMessage());
                return null;
            }
        }
        if (ob instanceof Apart) {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader("apart.csv"))) {
                String currentLine;
                while ((currentLine = bufferedReader.readLine()) != null) {
                    String[] dataFields = currentLine.split(",");
                    Apart imobil = new Apart(Integer.parseInt(dataFields[0]), dataFields[1], Integer.parseInt(dataFields[2]), Integer.parseInt(dataFields[3]), Double.parseDouble(dataFields[4]), Boolean.parseBoolean(dataFields[5]), Integer.parseInt(dataFields[6]), Integer.parseInt(dataFields[7]), Integer.parseInt(dataFields[8]), Boolean.parseBoolean(dataFields[9]));
                    templateArray.add((T) imobil);
                }
            } catch (IOException e) {
                System.out.println("Could not read data from file: " + e.getMessage());
                return null;
            }
        }
        if (ob instanceof Birou) {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader("birou.csv"))) {
                String currentLine;
                while ((currentLine = bufferedReader.readLine()) != null) {
                    String[] dataFields = currentLine.split(",");
                    Birou imobil = new Birou(Integer.parseInt(dataFields[0]), dataFields[1], Integer.parseInt(dataFields[2]), Integer.parseInt(dataFields[3]), Double.parseDouble(dataFields[4]), Boolean.parseBoolean(dataFields[5]), Integer.parseInt(dataFields[6]), Integer.parseInt(dataFields[7]));
                    templateArray.add((T) imobil);
                }
            } catch (IOException e) {
                System.out.println("Could not read data from file: " + e.getMessage());
                return null;
            }
        }
        if (ob instanceof Depozit) {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader("depozit.csv"))) {
                String currentLine;
                while ((currentLine = bufferedReader.readLine()) != null) {
                    String[] dataFields = currentLine.split(",");
                    Depozit imobil = new Depozit(Integer.parseInt(dataFields[0]), dataFields[1], Integer.parseInt(dataFields[2]), Integer.parseInt(dataFields[3]), Double.parseDouble(dataFields[4]), Boolean.parseBoolean(dataFields[5]), Double.parseDouble(dataFields[6]));
                    templateArray.add((T) imobil);
                }
            } catch (IOException e) {
                System.out.println("Could not read data from file: " + e.getMessage());
                return null;
            }
        }
        if (ob instanceof Teren) {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader("teren.csv"))) {
                String currentLine;
                while ((currentLine = bufferedReader.readLine()) != null) {
                    String[] dataFields = currentLine.split(",");
                    Teren imobil = new Teren(Integer.parseInt(dataFields[0]), dataFields[1], Integer.parseInt(dataFields[2]), Integer.parseInt(dataFields[3]), Double.parseDouble(dataFields[4]), Boolean.parseBoolean(dataFields[5]));
                    templateArray.add((T) imobil);
                }
            } catch (IOException e) {
                System.out.println("Could not read data from file: " + e.getMessage());
                return null;
            }
        }
        if(ob instanceof Agent)
        {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader("agent.csv"))) {
                String currentLine;
                while ((currentLine = bufferedReader.readLine()) != null) {
                    String[] dataFields = currentLine.split(",");
                    Agent imobil = new Agent(Integer.parseInt(dataFields[0]), dataFields[1], Integer.parseInt(dataFields[2]));
                    templateArray.add((T) imobil);
                }
            } catch (IOException e) {
                System.out.println("Could not read data from file: " + e.getMessage());
                return null;
            }
        }
        return templateArray;
    }

    public static <T> void scriere(T ob, ImobilService Serv) {
        if (ob instanceof Casa) {
            List<Casa> listaCase = new ArrayList<>(Serv.getListaCase());
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("casa.csv"))) {
                for (Casa casa : listaCase) {
                    bufferedWriter.write(casa.getId() + "," + casa.getAdresa() + "," + casa.getZona() + "," + casa.getSuprafata() + "," + casa.getPretMp() + "," + casa.isInchiriere() + "," + casa.getNrNivele() + "," + casa.getNrCamere() + "," + casa.isPiscina() + "," + casa.isGradina());
                    bufferedWriter.newLine();
                }
            } catch (IOException e) {
                System.out.println("Could not write data to file: " + e.getMessage());
            }
        }
        if (ob instanceof Apart) {
            List<Apart> listaApart = new ArrayList<>(Serv.getListaApart());
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("apart.csv"))) {
                for (Apart apart : listaApart) {
                    bufferedWriter.write(apart.getId() + "," + apart.getAdresa() + "," + apart.getZona() + "," + apart.getSuprafata() + "," + apart.getPretMp() + "," + apart.isInchiriere() + "," + apart.getEtaj() + "," + apart.getNrBai() + "," + apart.getNrCamere() + "," + apart.isTerasa());
                    bufferedWriter.newLine();
                }
            } catch (IOException e) {
                System.out.println("Could not write data to file: " + e.getMessage());
            }
        }
        if (ob instanceof Birou) {
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
        if (ob instanceof Depozit) {
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
        if (ob instanceof Teren) {
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
}

