package ro.unibuc.fmi.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class AuditService {

    public AuditService() {
    }

    public void writeAudit(String actiuni) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("audit.csv", true))) {
            Date date = new Date();
            bufferedWriter.write(actiuni + "," + date.toString());
            bufferedWriter.newLine();
        } catch (IOException e) {
            System.out.println("Nu s-a putut scrie din fisierul: " + e.getMessage());
            return;
        }

    }
}
