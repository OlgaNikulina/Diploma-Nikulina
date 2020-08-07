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

    public static CardsInfo getCardsInfoWith41ToBuy() {

        return new CardsInfo("4444 4444 4444 4441", "08", "22", "Name", "999");
    }

    public static CardsInfo getCardsInfoWith42ToBuy() {

        return new CardsInfo("4444 4444 4444 4442", "08", "22", "Name", "999");
    }

    public static void shouldSelectFromDBToBuy() throws SQLException {
        val id_order_entitySQL = "SELECT id FROM order_entity;";
        val id_payment_entitySQL = "SELECT id FROM payment_entity;";
        val status_payment_entitySQL = "SELECT status FROM payment_entity;";
        val payment_idSQL = "SELECT payment_id FROM order_entity;";
        try (
                val conn = DriverManager.getConnection("jdbc:mysql://192.168.99.100:3306/app", "app", "pass");

                val id_order_entityStmt = conn.createStatement();
                val id_payment_entityStmt = conn.createStatement();
                val status_payment_entityStmt = conn.createStatement();
                val payment_idStmt = conn.createStatement()
        ) {
            try (val rs = id_order_entityStmt.executeQuery(id_order_entitySQL)) {
                while (rs.next()) {
                    val id_order_entity = rs.getString("id_order_entity");
                    System.out.println(id_order_entity);
                }
            }
            try (val rs = id_payment_entityStmt.executeQuery(id_payment_entitySQL)) {
                while (rs.next()) {
                    val id_payment_entity = rs.getString("id_payment_entity");
                    System.out.println(id_payment_entity);
                }
            }
            try (val rs = status_payment_entityStmt.executeQuery(status_payment_entitySQL)) {
                while (rs.next()) {
                    val status_payment_entity = rs.getString("status");
                    System.out.println(status_payment_entity);
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

    public static CardsInfo getCardsInfoWith41ToBuyInCredit() {

        return new CardsInfo("4444 4444 4444 4441", "08", "22", "Name", "999");
    }

    public static CardsInfo getCardsInfoWith42ToBuyInCredit() {

        return new CardsInfo("4444 4444 4444 4442", "08", "22", "Name", "999");
    }

    public static void shouldSelectFromDBToBuyInCredit() throws SQLException {
        val id_credit_requestSQL = "SELECT id FROM credit_request_entity;";
        val status_credit_requestSQL = "SELECT status FROM credit_request_entity;";
        val credit_idSQL = "SELECT credit_id FROM order_entity;";
        val id_order_entitySQL = "SELECT id FROM order_entity;";

        try (
                val conn = DriverManager.getConnection("jdbc:mysql://192.168.99.100:3306/app", "app", "pass");

                val id_credit_requestStmt = conn.createStatement();
                val status_credit_requestStmt = conn.createStatement();
                val credit_idStmt = conn.createStatement();
                val id_order_entityStmt = conn.createStatement()
        ) {
            try (val rs = id_credit_requestStmt.executeQuery(id_credit_requestSQL)) {
                while (rs.next()) {
                    val id_credit_request = rs.getString("id_credit");
                    System.out.println(id_credit_request);
                }
            }
            try (val rs = status_credit_requestStmt.executeQuery(status_credit_requestSQL)) {
                while (rs.next()) {
                    val status_credit_request = rs.getString("status");
                    System.out.println(status_credit_request);
                }
            }
            try (val rs = credit_idStmt.executeQuery(credit_idSQL)) {
                while (rs.next()) {
                    val credit_id = rs.getString("credit_id");
                    System.out.println(credit_id);
                }
            }
            try (val rs = id_order_entityStmt.executeQuery(id_order_entitySQL)) {
                while (rs.next()) {
                    val id_order_entity = rs.getString("id_order_entity");
                    System.out.println(id_order_entity);
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
