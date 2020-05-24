package ro.unibuc.fmi.repository;

import ro.unibuc.fmi.Entity.Apartament;
import ro.unibuc.fmi.connection.DatabaseConnection;
import ro.unibuc.fmi.model.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ApartmentRepository {

    private static ApartmentRepository instance;

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private static final String INSERT_STATEMENT = "INSERT INTO apartments (id,adresa,zona,suprafata,pretMp,etaj,nrBai,nrCamere,registeredDateTime) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SELECT_STATEMENT = "SELECT * FROM apartments WHERE zona = ?";
    private static final String UPDATE_STATEMENT = "UPDATE apartments SET pretMp = ? WHERE id = ?";
    private static final String DELETE_STATEMENT = "DELETE FROM apartments WHERE id=?";

    private static final String FIND_NEWEST_STATEMENT = "SELECT * FROM apartments ORDER BY registeredDateTime DESC LIMIT 1";

    public ApartmentRepository() {
    }

    public static ApartmentRepository getInstance(){
        if (instance == null) {
            instance = new ApartmentRepository();
        }
        return instance;
    }

    public ApartmentDB saveApartment(ApartmentDB apartament) {
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(INSERT_STATEMENT)) {
            statement.setInt(1, apartament.getId());
            statement.setString(2, apartament.getAdresa());
            statement.setInt(3, apartament.getZona());
            statement.setInt(4, apartament.getSuprafata());
            statement.setDouble(5, apartament.getPretMp());
            statement.setInt(6, apartament.getEtaj());
            statement.setInt(7, apartament.getNrBai());
            statement.setInt(8, apartament.getNrCamere());
            statement.setString(9, DATE_FORMAT.format(apartament.getRegisteredDateTime()));

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new apartment was inserted successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to insert a new apartment: " + e.getMessage());
            return new ApartmentDB();
        }
        return apartament;
    }

    public ApartmentDB findApartment(int id) {
        ApartmentDB apartmentDB= new ApartmentDB();
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(SELECT_STATEMENT)) {
            statement.setInt(1, id);

            try (ResultSet result = statement.executeQuery()) {
                if (!result.next()) {
                    System.out.println("Something went wrong when trying to find apartment: Apartment was not found!");
                    return apartmentDB;
                }

                System.out.println("Apartment was found!");
                apartmentDB.setId(result.getInt("id"));
                apartmentDB.setAdresa(result.getString("adresa"));
                apartmentDB.setZona(result.getInt("zona"));
                apartmentDB.setSuprafata(result.getInt("suprafata"));
                apartmentDB.setPretMp(result.getDouble("pretMp"));
                apartmentDB.setEtaj(result.getInt("etaj"));
                apartmentDB.setNrBai(result.getInt("nrBai"));
                apartmentDB.setNrCamere(result.getInt("nrCamere"));
                apartmentDB.setRegisteredDateTime(DATE_FORMAT.parse(result.getString("registeredDateTime")));
            }
        } catch (SQLException | ParseException e) {
            System.out.println("Something went wrong when trying to find apartment: " + e.getMessage());
        }
        return apartmentDB;
    }

    public ApartmentDB updateApartment(ApartmentDB apartament) {
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(UPDATE_STATEMENT)) {
            statement.setDouble(1, apartament.getPretMp());
            statement.setInt(2, apartament.getId());

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Apartment was updated successfully!");
                return apartament;
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to update apartment: " + e.getMessage());
            return new ApartmentDB();
        }
        System.out.println("Something went wrong when trying to update apartment: Apartment was not found!");
        return new ApartmentDB();
    }

    public boolean deleteApartment(int id) {
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(DELETE_STATEMENT)) {
            statement.setInt(1, id);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Apartment was deleted successfully!");
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to delete apartment: " + e.getMessage());
            return false;
        }

        System.out.println("Something went wrong when trying to delete apartment: Apartment was not found!");
        return false;
    }

    public ApartmentDB findNewest() {
        ApartmentDB apartmentDB = new ApartmentDB();
        try (Statement statement = DatabaseConnection.getInstance().getConnection().createStatement()) {

            try (ResultSet result = statement.executeQuery(FIND_NEWEST_STATEMENT)) {
                if (!result.next()) {
                    System.out.println("Database might be empty!");
                    return apartmentDB;
                }

                System.out.println("Newest apartment was found!");
                apartmentDB.setId(result.getInt("id"));
                apartmentDB.setAdresa(result.getString("adresa"));
                apartmentDB.setZona(result.getInt("zona"));
                apartmentDB.setSuprafata(result.getInt("suprafata"));
                apartmentDB.setPretMp(result.getDouble("pretMp"));
                apartmentDB.setEtaj(result.getInt("etaj"));
                apartmentDB.setNrBai(result.getInt("nrBai"));
                apartmentDB.setNrCamere(result.getInt("nrCamere"));
                apartmentDB.setRegisteredDateTime(DATE_FORMAT.parse(result.getString("registeredDateTime")));
            }
        } catch (SQLException | ParseException e) {
            System.out.println("Something went wrong when trying to find the most newly registered apartment: " + e.getMessage());
        }
        return apartmentDB;
    }
}
