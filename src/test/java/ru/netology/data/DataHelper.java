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

    public static CardsInfo getCardsInfoWithApprovedCardToBuy() {

        return new CardsInfo("4444 4444 4444 4441", "08", "22", "Alex", "999");
    }

    public static CardsInfo getCardsInfoWithDeclinedCardToBuy() {

        return new CardsInfo("4444 4444 4444 4442", "08", "22", "Alex", "999");
    }

    public static void shouldSelectFromDBToBuy() throws SQLException {
        val statusSQL = "SELECT status FROM payment_entity;";
        val idSQL = "SELECT id FROM order_entity;";
        val payment_idSQL = "SELECT payment_id FROM order_entity;";
        try (
                val conn = DriverManager.getConnection("jdbc:mysql://192.168.99.100:3306/app", "app", "pass");

                val statusStmt = conn.createStatement();
                val idStmt = conn.createStatement();
                val payment_idStmt = conn.createStatement()
        ) {
            try (val rs = statusStmt.executeQuery(statusSQL)) {
                while (rs.next()) {
                    val status = rs.getString("status");
                    System.out.println(status);
                }
            }
            try (val rs = idStmt.executeQuery(idSQL)) {
                while (rs.next()) {
                    val id = rs.getString("id");
                    System.out.println(id);
                }
            }
            try (val rs = payment_idStmt.executeQuery(payment_idSQL)) {
                while (rs.next()) {
                    val payment_id = rs.getString("payment_id");
                    System.out.println(payment_id);
                }
            }
        }
    }

    public static String shouldDeleteFromDBToBuy() {
        val SQL = "DELETE FROM payment_entity;";
        return SQL;
    }

    public static CardsInfo getCardsInfoWithApprovedCardToBuyInCredit() {

        return new CardsInfo("4444 4444 4444 4441", "08", "22", "Alex", "999");
    }

    public static CardsInfo getCardsInfoWithDeclinedCArdToBuyInCredit() {

        return new CardsInfo("4444 4444 4444 4442", "08", "22", "Alex", "999");
    }

    public static void shouldSelectFromDBToBuyInCredit() throws SQLException {
        val statusSQL = "SELECT status FROM credit_request_entity;";
        val credit_idSQL = "SELECT credit_id FROM order_entity;";
        val idSQL = "SELECT id FROM order_entity;";

        try (
                val conn = DriverManager.getConnection("jdbc:mysql://192.168.99.100:3306/app", "app", "pass");

                val statusStmt = conn.createStatement();
                val credit_idStmt = conn.createStatement();
                val idStmt = conn.createStatement()
        ) {
            try (val rs = statusStmt.executeQuery(statusSQL)) {
                while (rs.next()) {
                    val status = rs.getString("status");
                    System.out.println(status);
                }
            }
            try (val rs = credit_idStmt.executeQuery(credit_idSQL)) {
                while (rs.next()) {
                    val credit_id = rs.getString("credit_id");
                    System.out.println(credit_id);
                }
            }
            try (val rs = idStmt.executeQuery(idSQL)) {
                while (rs.next()) {
                    val id = rs.getString("id");
                    System.out.println(id);
                }
            }
        }
    }

    public static String shouldDeleteFromDBToBuyInCredit() {
        val SQL = "DELETE FROM credit_request_entity;";
        return SQL;
    }

    public static CardsInfo getCardsInfoWithEmptyFields() {
        return new CardsInfo("", "", "", "", "");
    }

    public static CardsInfo getCardsInfoWithSingleSymbols() {
        return new CardsInfo("1", "1", "1", "1", "1");
    }
}
