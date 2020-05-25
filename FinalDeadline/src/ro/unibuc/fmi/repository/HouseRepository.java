package ro.unibuc.fmi.repository;


import ro.unibuc.fmi.connection.DatabaseConnection;
import ro.unibuc.fmi.model.House;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class HouseRepository {

    private static HouseRepository instance;

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private static final String INSERT_STATEMENT = "INSERT INTO houses (id,adresa,zona,suprafata,pretMp,nrNivele,nrCamere,registeredDateTime) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SELECT_STATEMENT = "SELECT * FROM houses WHERE id = ?";
    private static final String UPDATE_STATEMENT = "UPDATE houses SET pretMp = ? WHERE id = ?";
    private static final String DELETE_STATEMENT = "DELETE FROM houses WHERE id=?";

    private static final String FIND_AREA_STATEMENT = "SELECT * FROM houses WHERE zona = ?";

    public HouseRepository() {
    }

    public static HouseRepository getInstance() {
        if (instance == null) {
            instance = new HouseRepository();
        }
        return instance;
    }

    public House saveHouse(House house) {
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(INSERT_STATEMENT)) {
            statement.setInt(1, house.getId());
            statement.setString(2, house.getAdresa());
            statement.setInt(3, house.getZona());
            statement.setInt(4, house.getSuprafata());
            statement.setDouble(5, house.getPretMp());
            statement.setInt(6, house.getNrNivele());
            statement.setInt(7, house.getNrCamere());
            statement.setString(8, DATE_FORMAT.format(house.getRegisteredDateTime()));

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new house was inserted successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to insert a new house: " + e.getMessage());
            return new House();
        }
        return house;
    }

    public House findHouse(int id) {
        House house = new House();
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(SELECT_STATEMENT)) {
            statement.setInt(1, id);

            try (ResultSet result = statement.executeQuery()) {
                if (!result.next()) {
                    System.out.println("Something went wrong when trying to find house: House was not found!");
                    return house;
                }

                System.out.println("House was found!");
                house.setId(result.getInt("id"));
                house.setAdresa(result.getString("adresa"));
                house.setZona(result.getInt("zona"));
                house.setSuprafata(result.getInt("suprafata"));
                house.setPretMp(result.getDouble("pretMp"));
                house.setNrNivele(result.getInt("nrNivele"));
                house.setNrCamere(result.getInt("nrCamere"));
                house.setRegisteredDateTime(DATE_FORMAT.parse(result.getString("registeredDateTime")));
            }
        } catch (SQLException | ParseException e) {
            System.out.println("Something went wrong when trying to find user: " + e.getMessage());
        }
        return house;
    }

    public House updateHouse(House house) {
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(UPDATE_STATEMENT)) {
            statement.setDouble(1, house.getPretMp());
            statement.setInt(2, house.getId());

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("House was updated successfully!");
                return house;
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to update house: " + e.getMessage());
            return new House();
        }
        System.out.println("Something went wrong when trying to update house: House was not found!");
        return new House();
    }

    public boolean deleteHouse(int id) {
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(DELETE_STATEMENT)) {
            statement.setInt(1, id);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("House was deleted successfully!");
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to delete house: " + e.getMessage());
            return false;
        }

        System.out.println("Something went wrong when trying to delete house: House was not found!");
        return false;
    }

    public House findArea(int zona) {
        House house = new House();
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(FIND_AREA_STATEMENT)) {
            statement.setInt(1, zona);

            try (ResultSet result = statement.executeQuery()) {
                if (!result.next()) {
                    System.out.println("Something went wrong when trying to find house: House was not found!");
                    return house;
                }

                System.out.println("House was found!");
                house.setId(result.getInt("id"));
                house.setAdresa(result.getString("adresa"));
                house.setZona(result.getInt("zona"));
                house.setSuprafata(result.getInt("suprafata"));
                house.setPretMp(result.getDouble("pretMp"));
                house.setNrNivele(result.getInt("nrNivele"));
                house.setNrCamere(result.getInt("nrCamere"));
                house.setRegisteredDateTime(DATE_FORMAT.parse(result.getString("registeredDateTime")));
            }
        } catch (SQLException | ParseException e) {
            System.out.println("Something went wrong when trying to find user: " + e.getMessage());
        }
        return house;
    }
}
