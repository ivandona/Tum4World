package it.unitn.disi.progetto;

import java.sql.*;

/* || Classe per accesso al DB
Classe contenente i metodi per poter interagire con il database

*/

public class UserDAO {
    public UserBean getUserById(int id) {
        String query = "SELECT * FROM users WHERE id = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    UserBean user = new UserBean();
                    user.setId(resultSet.getInt("id"));
                    user.setName(resultSet.getString("name"));
                    user.setSurname(resultSet.getString("surname"));
                    user.setEmail(resultSet.getString("email"));
                    user.setBirthdate(resultSet.getDate("birthdate"));
                    user.setPhoneNumber(resultSet.getString("phone_number"));
                    user.setUserRole(UserRole.valueOf(resultSet.getString("user_role")));
                    user.setPassword(resultSet.getString("password"));
                    return user;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void saveUser(UserBean user) {
        String query = "INSERT INTO users (name, surname, email, birthdate, phone_number, user_role, password) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getSurname());
            statement.setString(3, user.getEmail());
            statement.setDate(4, new java.sql.Date(user.getBirthdate().getTime()));
            statement.setString(5, user.getPhoneNumber());
            statement.setString(6, user.getUserRole().toString());
            statement.setString(7, user.getPassword());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
