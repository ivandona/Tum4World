package it.unitn.disi.progetto.models;

import java.sql.*;
import java.time.LocalDate;

/*
|| Classe contenente i metodi per poter interagire con il database
*/

public class UserDAO {
    // Verifica username e password nel database e ritorna le informazioni dell'utente, altrimenti ritorna null
    public UserBean checkCredentials(Connection connection, String username, String password) {
        String query = "SELECT * FROM users WHERE username = ? AND password = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            statement.setString(2, password);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    UserBean user = new UserBean();
                    user.setName(resultSet.getString("name"));
                    user.setSurname(resultSet.getString("surname"));
                    user.setEmail(resultSet.getString("email"));
                    user.setBirthdate((resultSet.getDate("birthdate")).toLocalDate()); //Converto la data da Date (sql) a LocalDate
                    user.setPhoneNumber(resultSet.getString("phone_number"));
                    user.setUserRole(UserRole.valueOf(resultSet.getString("user_role")));
                    user.setUsername(resultSet.getString("username"));
                    user.setPassword(resultSet.getString("password"));
                    user.setActivity_1(resultSet.getBoolean("activity_1"));
                    user.setActivity_2(resultSet.getBoolean("activity_2"));
                    user.setActivity_3(resultSet.getBoolean("activity_3"));
                    return user;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Inserisce i dati dell'utente nel database
    public void saveUser(Connection connection, UserBean user) {
       String query = "INSERT INTO users (name, surname, email, birthdate, phone_number, user_role, username, password, ACTIVITY_1, ACTIVITY_2, ACTIVITY_3) " +
               "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getSurname());
            statement.setString(3, user.getEmail());
            statement.setDate(4, Date.valueOf(user.getBirthdate()));
            statement.setString(5, user.getPhoneNumber());
            statement.setString(6, user.getUserRole().toString());
            statement.setString(7, user.getUsername());
            statement.setString(8, user.getPassword());
            statement.setBoolean(9, user.getActivity_1());
            statement.setBoolean(10, user.getActivity_2());
            statement.setBoolean(11, user.getActivity_3());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void saveDonation(Connection connection, String username, int importo, int giorno, int mese, int anno) {
        String query = "INSERT INTO DONATIONS (USERNAME, VALUE_DONATION, DONATION_DAY, DONATION_MONTH, DONATION_YEAR) " +
                "VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            statement.setInt(2, importo);
            statement.setInt(3, giorno);
            statement.setInt(4, mese);
            statement.setInt(5, anno);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // Cancella l'utente dal database
    public void deleteUser(Connection connection, String username) {
        String query = "DELETE FROM users WHERE username = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Metodo per controllare se l'username esiste già
    public boolean isUsernameTaken(Connection connection, String username) {
        String query = "SELECT COUNT(*) FROM users WHERE username = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0; // Se count è maggiore di 0, allora l'username è già preso
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    // Aggiorno la tabella mettendo le attività a cui l'utente si è iscritto/disiscritto
    public void setActivities(Connection connection, String username,
                                    Boolean activity_1, Boolean activity_2, Boolean activity_3) {
        String query = "UPDATE USERS SET ACTIVITY_1 = ?, ACTIVITY_2 = ?, ACTIVITY_3 = ? " +
                "WHERE USERNAME = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setBoolean(1, activity_1);
            statement.setBoolean(2, activity_2);
            statement.setBoolean(3, activity_3);
            statement.setString(4, username);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Ritorna un array di boolean che indica le attività a cui è iscritto l'utente
    public Boolean[] getActivities(Connection connection, String username) {
        String query = "SELECT ACTIVITY_1, ACTIVITY_2, ACTIVITY_3 FROM USERS WHERE USERNAME = ?";
        Boolean[] activities = new Boolean[3];

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    activities[0] = resultSet.getBoolean("activity_1");
                    activities[1] = resultSet.getBoolean("activity_2");
                    activities[2] = resultSet.getBoolean("activity_3");
                    return activities;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
