package ro.unibuc.fmi.repository;

import ro.unibuc.fmi.connection.DatabaseConnection;
import ro.unibuc.fmi.model.AgentDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class AgentRepository {
    private static AgentRepository instance;

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private static final String INSERT_STATEMENT = "INSERT INTO agents (id,nume,zona,registeredDateTime) VALUES (?, ?, ?, ?)";
    private static final String SELECT_STATEMENT = "SELECT * FROM agents WHERE id = ?";
    private static final String UPDATE_STATEMENT = "UPDATE agents SET zona = ? WHERE id = ?";
    private static final String DELETE_STATEMENT = "DELETE FROM agents WHERE id = ?";

    private static final String FIND_NEWEST_STATEMENT = "SELECT * FROM agents ORDER BY registeredDateTime DESC LIMIT 1";

    public AgentRepository() {
    }

    public static AgentRepository getInstance() {
        if (instance == null) {
            instance = new AgentRepository();
        }
        return instance;
    }

    public AgentDB saveAgent(AgentDB agent) {
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(INSERT_STATEMENT)) {
            statement.setInt(1, agent.getIdAng());
            statement.setString(2, agent.getNume());
            statement.setInt(3, agent.getZonaAct());
            statement.setString(4, DATE_FORMAT.format(agent.getRegisteredDateTime()));

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new employee was inserted successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to insert a new employee: " + e.getMessage());
            return new AgentDB();
        }
        return agent;
    }

    public AgentDB findAgent(int id) {
        AgentDB agentDB = new AgentDB();
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(SELECT_STATEMENT)) {
            statement.setInt(1, id);

            try (ResultSet result = statement.executeQuery()) {
                if (!result.next()) {
                    System.out.println("Something went wrong when trying to find employee: Employee was not found!");
                    return agentDB;
                }

                System.out.println("Employee was found!");
                agentDB.setIdAng(result.getInt("id"));
                agentDB.setNume(result.getString("nume"));
                agentDB.setZonaAct(result.getInt("zona"));
                agentDB.setRegisteredDateTime(DATE_FORMAT.parse(result.getString("registeredDateTime")));
            }
        } catch (SQLException | ParseException e) {
            System.out.println("Something went wrong when trying to find employee: " + e.getMessage());
        }
        return agentDB;
    }

    public AgentDB updateAgent(AgentDB agent) {
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(UPDATE_STATEMENT)) {
            statement.setInt(1, agent.getZonaAct());
            statement.setInt(2, agent.getIdAng());

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Apartment was updated successfully!");
                return agent;
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to update employee: " + e.getMessage());
            return new AgentDB();
        }
        System.out.println("Something went wrong when trying to update employee: Employee was not found!");
        return new AgentDB();
    }

    public boolean deleteAgent(int id) {
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(DELETE_STATEMENT)) {
            statement.setInt(1, id);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Employee was deleted successfully!");
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to delete employee: " + e.getMessage());
            return false;
        }

        System.out.println("Something went wrong when trying to delete employee: Employee was not found!");
        return false;
    }

    public AgentDB findNewest() {
        AgentDB agentDB = new AgentDB();
        try (Statement statement = DatabaseConnection.getInstance().getConnection().createStatement()) {

            try (ResultSet result = statement.executeQuery(FIND_NEWEST_STATEMENT)) {
                if (!result.next()) {
                    System.out.println("Database might be empty!");
                    return agentDB;
                }

                System.out.println("Newest employee was found!");
                agentDB.setIdAng(result.getInt("id"));
                agentDB.setNume(result.getString("nume"));
                agentDB.setZonaAct(result.getInt("zona"));
                agentDB.setRegisteredDateTime(DATE_FORMAT.parse(result.getString("registeredDateTime")));
            }
        } catch (SQLException | ParseException e) {
            System.out.println("Something went wrong when trying to find the most newly registered employee: " + e.getMessage());
        }
        return agentDB;
    }
}
