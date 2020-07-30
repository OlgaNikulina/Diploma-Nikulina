package ru.netology.data;

import lombok.Value;
import lombok.val;

import java.sql.DriverManager;
import java.sql.SQLException;

public class DataHelper {
    private DataHelper() {
    }

    @Value
    public static class CardsInfo {
        private String cardNumber;
        private String month;
        private String year;
        private String name;
        private String cvv;
    }

    public static CardsInfo getCardsInfoWith41() throws SQLException {
     //   val transaction_idSQL = "DELETE transaction_id FROM payment_entity created order by desc limit 1;";
        val transaction_idSQL = "SELECT * FROM payment_entity;";
        try (
                val conn = DriverManager.getConnection("jdbc:mysql://192.168.99.100:3306/app", "app", "pass");
                val transaction_idStmt = conn.prepareStatement(transaction_idSQL);
        ) {
            try (val rs = transaction_idStmt.executeQuery(transaction_idSQL)) {
                String transaction_id = "";
                String cardNumber = "";
                while (rs.first()) {
                    transaction_id = rs.getString("transaction_id");
                    cardNumber = rs.getString("cardNumber");
                }
            }
        }
        return new CardsInfo(transaction_idSQL, "08", "22", "Name", "999");
    }

    public static CardsInfo getCardsInfoWith42() throws SQLException {
        val transaction_idSQL = "SELECT * FROM payment_entity;";
        try (
                val conn = DriverManager.getConnection("jdbc:mysql://192.168.99.100:3306/app", "app", "pass");
                val transaction_idStmt = conn.prepareStatement(transaction_idSQL);
        ) {
            try (val rs = transaction_idStmt.executeQuery(transaction_idSQL)) {
                String transaction_id = "";
                String cardNumber = "";
                while (rs.last()) {
                    transaction_id = rs.getString("transaction_id");
                    cardNumber = rs.getString("cardNumber");
                }
            }
        }
        return new CardsInfo(transaction_idSQL, "08", "22", "Name", "999");
    }

    public static void shouldDeleteFromDB() throws SQLException {
        val SQL = "DELETE FROM payment_entity ORDER BY transaction_id LIMIT 1;";

        try (
                val conn = DriverManager.getConnection("jdbc:mysql://192.168.99.100:3306/app", "app", "pass");
                val SQLStmt = conn.prepareStatement(SQL);
        ) {
        }
    }

    public static CardsInfo getCardsInfoWithEmptyFields() {
        return new CardsInfo("", "", "", "", "");
    }

    public static CardsInfo getCardsInfoWithSingleSymbols() {
        return new CardsInfo("1", "1", "1", "1", "1");
    }
}
