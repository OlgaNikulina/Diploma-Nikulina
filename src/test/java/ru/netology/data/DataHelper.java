package ru.netology.data;

import lombok.Value;
import lombok.val;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataHelper {
    private DataHelper() {
    }

    public static String dbURL = System.getProperty("db.url");

    public enum Localhost {

        DEV("http://localhost:8080");

        private final String url;

        Localhost(String url) {
            this.url = url;
        }

        public String getUrl() {
            return url;
        }
    }

    @Value
    public static class CardsInfo {
        private String cardNumber;
        private String month;
        private String year;
        private String name;
        private String cvv;
    }

    @BeforeAll
    public static void shouldDeleteFromPayment_entityToBuy() {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection(dbURL, "app", "pass");
            statement = connection.createStatement();
            statement.execute("DELETE FROM payment_entity");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @BeforeAll
    public static void shouldDeleteFromOrder_entity() {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection(dbURL, "app", "pass");
            statement = connection.createStatement();
            statement.execute("DELETE FROM order_entity;");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @BeforeAll
    public static void shouldDeleteFromCredit_request_entityToBuyInCredit() {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection(dbURL, "app", "pass");
            statement = connection.createStatement();
            statement.execute("DELETE FROM credit_request_entity;");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static CardsInfo getCardsInfoWithApprovedCardToBuy() {

        return new CardsInfo("4444 4444 4444 4441", "08", "22", "Alex", "999");
    }

    public static CardsInfo getCardsInfoWithDeclinedCardToBuy() {

        return new CardsInfo("4444 4444 4444 4442", "08", "22", "Alex", "999");
    }

    public static String shouldSelectStatusFromDBToBuy() throws SQLException {
        val statusSQL = "SELECT status FROM payment_entity limit 1;";
        String status = "";
        try (
                val conn = DriverManager.getConnection(dbURL, "app", "pass");
                val statusStmt = conn.createStatement();
        ) {
            try (val rs = statusStmt.executeQuery(statusSQL)) {
                while (rs.next()) {
                    status = rs.getString("status");
                }
            }
        }
        return status;
    }

    public static String shouldSelectIdFromDBToBuy() throws SQLException {
        val idSQL = "SELECT id FROM order_entity limit 1;";
        String id = "";
        try (
                val conn = DriverManager.getConnection(dbURL, "app", "pass");
                val idStmt = conn.createStatement();
        ) {
            try (val rs = idStmt.executeQuery(idSQL)) {
                if (rs.next()) {
                    id = rs.getString("id");
                }
            }
        }
        return id;
    }

    public static String shouldSelectPayment_IdFromDBToBuy() throws SQLException {
        val payment_idSQL = "SELECT payment_id FROM order_entity limit 1;";
        String payment_id = "";
        try (
                val conn = DriverManager.getConnection(dbURL, "app", "pass");
                val payment_idStmt = conn.createStatement()
        ) {
            try (val rs = payment_idStmt.executeQuery(payment_idSQL)) {
                while (rs.next()) {
                    payment_id = rs.getString("payment_id");
                }
            }
        }
        return payment_id;
    }

    public static CardsInfo getCardsInfoWithApprovedCardToBuyInCredit() {

        return new CardsInfo("4444 4444 4444 4441", "08", "22", "Alex", "999");
    }

    public static CardsInfo getCardsInfoWithDeclinedCArdToBuyInCredit() {

        return new CardsInfo("4444 4444 4444 4442", "08", "22", "Alex", "999");
    }

    public static String shouldSelectStatusFromDBToBuyInCredit() throws SQLException {
        val statusSQL = "SELECT status FROM credit_request_entity limit 1;";
        String status = "";
        try (
                val conn = DriverManager.getConnection(dbURL, "app", "pass");
                val statusStmt = conn.createStatement();
        ) {
            try (val rs = statusStmt.executeQuery(statusSQL)) {
                while (rs.next()) {
                    status = rs.getString("status");
                }
            }
        }
        return status;
    }

    public static String shouldSelectIdFromDBToBuyInCredit() throws SQLException {
        val idSQL = "SELECT id FROM order_entity limit 1;";
        String id = "";
        try (
                val conn = DriverManager.getConnection(dbURL, "app", "pass");
                val idStmt = conn.createStatement();
        ) {
            try (val rs = idStmt.executeQuery(idSQL)) {
                while (rs.next()) {
                    id = rs.getString("id");
                }
            }
        }
        return id;
    }

    public static String shouldSelectCredit_idFromDBToBuyInCredit() throws SQLException {
        val credit_idSQL = "SELECT credit_id FROM order_entity limit 1;";
        String credit_id = "";
        try (
                val conn = DriverManager.getConnection(dbURL, "app", "pass");
                val credit_idStmt = conn.createStatement()
        ) {
            try (val rs = credit_idStmt.executeQuery(credit_idSQL)) {
                while (rs.next()) {
                    credit_id = rs.getString("credit_id");
                }
            }
        }
        return credit_id;
    }

    public static CardsInfo getCardsInfoWithEmptyFields() {
        return new CardsInfo("", "", "", "", "");
    }

    public static CardsInfo getCardsInfoWithSingleSymbols() {
        return new CardsInfo("1", "1", "1", "1", "1");
    }
}
