package ru.gb.chat.server.core;

import java.sql.*;

public class SqlClient {

    private static Connection connection;
    private static Statement statement;

    synchronized static void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:chat-server/chat-db.db");
            statement = connection.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    synchronized static void disconnect() {
        try {
            connection.close();
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
    }

    synchronized static String getNickname(String login, String password) {
        try {
            ResultSet rs = statement.executeQuery(
                    String.format("select nickname from users where login = '%s' and password = '%s';",
                            login, password));
            if (rs.next()) {
                String nickname = rs.getString("nickname");
                rs.close();
                return nickname;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    synchronized static ResultSet checkFields(String column, String field){
        try {
            ResultSet rs = statement.executeQuery(
                    String.format("SELECT %s FROM users WHERE %s = '%s';",
                            column, column, field));
            return rs;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    synchronized static String newNickname(String oldNickname, String newNickname){
        try {
            ResultSet rs = checkFields("nickname", newNickname);
            if (rs.next()) {
                return "-1";
            }
            int eu = statement.executeUpdate(
                    String.format("UPDATE users SET nickname = '%s' WHERE nickname = '%s';",
                            newNickname, oldNickname));
            if (eu == 1) return String.valueOf(eu);
            else return "0";
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //return null;
    }

    synchronized static String newUser(String login, String password, String nickname) {
        try {
            ResultSet rsl = checkFields("login", login);
            if (rsl.next()) {
                return "Такой логин уже занят";
            }

            ResultSet rsn = checkFields("nickname", nickname);
            if (rsn.next()) {
                return "Такой никнэйм уже занят";
            }else {
                int eu = statement.executeUpdate(
                        String.format("INSERT INTO users (login, password, nickname) VALUES ('%s', '%s', '%s');",
                                login, password, nickname));
                return String.valueOf(eu);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //return null;
    }
}
