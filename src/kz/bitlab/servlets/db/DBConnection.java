package kz.bitlab.servlets.db;

import kz.bitlab.servlets.db.Items;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBConnection {

    private static Connection connection;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbitems",
                    "root",
                    "");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Items> getItems() {

        ArrayList<Items> items = new ArrayList<>();

        try {

            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM items");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Items item = new Items();
                item.setId(resultSet.getLong("id"));
                item.setName(resultSet.getString("name"));
                item.setDescription(resultSet.getString("description"));
                item.setPrice(resultSet.getDouble("price"));
                items.add(item);
            }
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }

    public static void addItem(Items items) {
        try {

            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO items (name, description,price) " +
                    "VALUES (?, ?, ? )");
            statement.setString(1, items.getName());
            statement.setString(2, items.getDescription());
            statement.setDouble(3, items.getPrice());

            statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Items getItem(int id) {
        Items items = null;
        try {

            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM items WHERE id = ? LIMIT 1");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                items = new Items();
                items.setId(resultSet.getLong("id"));
                items.setName(resultSet.getString("name"));
                items.setDescription(resultSet.getString("description"));
                items.setPrice(resultSet.getDouble("price"));
            }
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }

    public static void UpdateItem(Items item) {
        try {

            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE items " +
                            "SET " +
                            "name = ?, " +
                            "description = ?, " +
                            "price = ?, " +
                            "WHERE id = ?");

            statement.setString(1, item.getName());
            statement.setString(2, item.getDescription());
            statement.setDouble(3, item.getPrice());
            statement.setLong(4, item.getId());

            statement.executeUpdate();
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void DeleteItem(int id) {

        try {

            PreparedStatement statement = connection.prepareStatement("" +
                    "DELETE FROM items WHERE id = ?");

            statement.setInt(1, id);

            statement.executeUpdate();
            statement.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Users getUser(String email) {
        Users users = null;
        try {
            PreparedStatement statement = connection.prepareStatement(" " +
                    "SELECT * FROM users WHERE email = ?");
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                users = new Users();
                users.setId(resultSet.getLong("id"));
                users.setEmail(resultSet.getString("email"));
                users.setPassword(resultSet.getString("password"));
                users.setFullName(resultSet.getString("full_Name"));
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    public static void AddNews(News news) {
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO news(title,content,post_date,user_id)" +
                    "VALUES (?,?,NOW(),?)");

            statement.setString(1, news.getTitle());
            statement.setString(2, news.getContent());
            statement.setLong(3, news.getUsers().getId());
            statement.executeUpdate();
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<News> getNews() {
        ArrayList<News> news = new ArrayList<>();
        try {

            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT n.id, n.title, n.content, n.user_id, u.full_name, n.post_date" +
                    "FROM news AS n" +
                    "INNER JOIN users AS u ON u.id = n.user_id" +
                    "ORDER BY n.post_date DESC ");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                News n = new News();
                n.setId(resultSet.getLong("id"));
                n.setTitle(resultSet.getString("title"));
                n.setContent(resultSet.getString("content"));
                n.setPostDate(resultSet.getTimestamp("post_date"));

                Users users = new Users();
                users.setId(resultSet.getLong("user_id"));
                users.setFullName(resultSet.getString("full_name"));
                n.setUsers(users);
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return news;
    }
}