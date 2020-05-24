package ro.unibuc.fmi.repository;

import ro.unibuc.fmi.connection.DatabaseConnection;
import ro.unibuc.fmi.model.ApartmentDB;
import ro.unibuc.fmi.model.Office;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OfficeRepository {

    private static OfficeRepository instance;

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private static final String INSERT_STATEMENT = "INSERT INTO offices (id,adresa,zona,suprafata,pretMp,nrNivele,etaj,registeredDateTime) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SELECT_STATEMENT = "SELECT * FROM offices WHERE zona = ?";
    private static final String UPDATE_STATEMENT = "UPDATE offices SET pretMp = ? WHERE id = ?";
    private static final String DELETE_STATEMENT = "DELETE FROM offices WHERE id=?";

    private static final String FIND_NEWEST_STATEMENT = "SELECT * FROM offices ORDER BY registeredDateTime DESC LIMIT 1";

    public OfficeRepository() {
    }

    public static OfficeRepository getInstance(){
        if (instance == null) {
            instance = new OfficeRepository();
        }
        return instance;
    }

    public Office saveOffice(Office office) {
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(INSERT_STATEMENT)) {
            statement.setInt(1, office.getId());
            statement.setString(2, office.getAdresa());
            statement.setInt(3, office.getZona());
            statement.setInt(4, office.getSuprafata());
            statement.setDouble(5, office.getPretMp());
            statement.setInt(6, office.getNrNivele());
            statement.setInt(7, office.getEtaj());
            statement.setString(8, DATE_FORMAT.format(office.getRegisteredDateTime()));

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new office was inserted successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to insert a new office: " + e.getMessage());
            return new Office();
        }
        return office;
    }

    public Office findOffice(int id) {
        Office office= new Office();
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(SELECT_STATEMENT)) {
            statement.setInt(1, id);

            try (ResultSet result = statement.executeQuery()) {
                if (!result.next()) {
                    System.out.println("Something went wrong when trying to find office: Office was not found!");
                    return office;
                }

                System.out.println("Office was found!");
                office.setId(result.getInt("id"));
                office.setAdresa(result.getString("adresa"));
                office.setZona(result.getInt("zona"));
                office.setSuprafata(result.getInt("suprafata"));
                office.setPretMp(result.getDouble("pretMp"));
                office.setNrNivele(result.getInt("nrNivele"));
                office.setEtaj(result.getInt("etaj"));
                office.setRegisteredDateTime(DATE_FORMAT.parse(result.getString("registeredDateTime")));
            }
        } catch (SQLException | ParseException e) {
            System.out.println("Something went wrong when trying to find office: " + e.getMessage());
        }
        return office;
    }

    public Office updateOffice(Office office) {
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(UPDATE_STATEMENT)) {
            statement.setDouble(1, office.getPretMp());
            statement.setInt(2, office.getId());

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Office was updated successfully!");
                return office;
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to update office: " + e.getMessage());
            return new Office();
        }
        System.out.println("Something went wrong when trying to update office: Office was not found!");
        return new Office();
    }

    public boolean deleteOffice(int id) {
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(DELETE_STATEMENT)) {
            statement.setInt(1, id);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Office was deleted successfully!");
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to delete office: " + e.getMessage());
            return false;
        }

        System.out.println("Something went wrong when trying to delete office: Office was not found!");
        return false;
    }

    public Office findNewest() {
        Office office = new Office();
        try (Statement statement = DatabaseConnection.getInstance().getConnection().createStatement()) {

            try (ResultSet result = statement.executeQuery(FIND_NEWEST_STATEMENT)) {
                if (!result.next()) {
                    System.out.println("Database might be empty!");
                    return office;
                }

                System.out.println("Newest office was found!");
                office.setId(result.getInt("id"));
                office.setAdresa(result.getString("adresa"));
                office.setZona(result.getInt("zona"));
                office.setSuprafata(result.getInt("suprafata"));
                office.setPretMp(result.getDouble("pretMp"));
                office.setNrNivele(result.getInt("nrNivele"));
                office.setEtaj(result.getInt("etaj"));
                office.setRegisteredDateTime(DATE_FORMAT.parse(result.getString("registeredDateTime")));
            }
        } catch (SQLException | ParseException e) {
            System.out.println("Something went wrong when trying to find the most newly registered office: " + e.getMessage());
        }
        return office;
    }
}
