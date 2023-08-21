package it.unitn.disi.progetto.models;

import java.sql.*;
import java.time.LocalDate;

/*
|| Classe contenente i metodi per poter interagire con il database
*/

public class UserDAO {
   public UserBean getUserById(Connection connection, int id) {
        String query = "SELECT * FROM users WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    UserBean user = new UserBean();
                    user.setId(resultSet.getInt("id"));
                    user.setName(resultSet.getString("name"));
                    user.setSurname(resultSet.getString("surname"));
                    user.setEmail(resultSet.getString("email"));
                    user.setBirthdate((resultSet.getDate("birthdate")).toLocalDate()); //converto la data da Date (sql) a LocalDate
                    user.setPhoneNumber(resultSet.getString("phone_number"));
                    user.setUserRole(UserRole.valueOf(resultSet.getString("user_role")));
                    user.setPassword(resultSet.getString("username"));
                    user.setPassword(resultSet.getString("password"));
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

    //verifica username e password nel database e ritorna le informazioni dell'utente, altrimenti ritorna null
    public UserBean checkCredentials(Connection connection, String username, String password) {
        String query = "SELECT * FROM users WHERE username = ? AND password = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            statement.setString(2, password);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    UserBean user = new UserBean();
                    user.setId(resultSet.getInt("id"));
                    user.setName(resultSet.getString("name"));
                    user.setSurname(resultSet.getString("surname"));
                    user.setEmail(resultSet.getString("email"));
                    user.setBirthdate((resultSet.getDate("birthdate")).toLocalDate()); //converto la data da Date (sql) a LocalDate
                    user.setPhoneNumber(resultSet.getString("phone_number"));
                    user.setUserRole(UserRole.valueOf(resultSet.getString("user_role")));
                    user.setUsername(resultSet.getString("username"));
                    user.setPassword(resultSet.getString("password"));
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

    //inserisce dati dell'utente nel db
    public void saveUser(Connection connection, UserBean user) {
            if (isUsernameTaken(connection, user.getEmail())) {
            // Handle username already taken case
            return; // Return or throw an exception as appropriate
        }

       String query = "INSERT INTO users (name, surname, email, birthdate, phone_number, user_role, username, password) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getSurname());
            statement.setString(3, user.getEmail());
            statement.setDate(4, Date.valueOf(user.getBirthdate()));
            statement.setString(5, user.getPhoneNumber());
            statement.setString(6, user.getUserRole().toString());
            statement.setString(7, user.getUsername());
            statement.setString(7, user.getPassword());
            statement.executeUpdate();

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int generatedId = generatedKeys.getInt(1);
                    user.setId(generatedId);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //metodo per controllare se lo username esiste già
    public boolean isUsernameTaken(Connection connection, String username) {
        String query = "SELECT COUNT(*) FROM users WHERE email = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0; // Se count è maggiore di 0, allora lo username è già preso
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
