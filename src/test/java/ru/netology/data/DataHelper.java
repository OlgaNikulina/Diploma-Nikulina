package ru.netology.data;

import lombok.Value;
import lombok.val;
import org.checkerframework.checker.units.qual.C;

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

    public static CardsInfo getCardsInfoWith42ToBuy() throws SQLException {
        val cardNumberSQL = "SELECT * FROM payment_entity;";
        ){
            try (val rs = cardNumberStmt.executeQuery(cardNumberSQL)) {
                String transaction_id = "";
                String cardNumber = "";
                while (rs.last()) {
                    transaction_id = rs.getString("transaction_id");
                    cardNumber = rs.getString("cardNumber");
                }
            }
        }
        return new CardsInfo("4444 4444 4444 4442", "08", "22", "Name", "999");
    }

    public static CardsInfo shouldSelectFromDBToBuy() throws SQLException {
        val transaction_id = "SELECT transaction_id FROM payment_entity;";
        SELECT id FROM credit_request_entity
        SELECT status FROM credit_request_entity
        SELECT credit_id FROM order_entity
        SELECT id FROM order_entity
        SELECT id FROM payment_entity
        SELECT status FROM payment_entity
        SELECT payment_id FROM order_entity
        try (
                val conn = DriverManager.getConnection("jdbc:mysql://192.168.99.100:3306/app", "app", "pass");
                val cardNumberStmt = conn.prepareStatement(cardNumberSQL);
        ) {
            try (val rs = cardNumberStmt.executeQuery(cardNumberSQL)) {
                String transaction_id = "";
                String cardNumber = "";
                while (rs.last()) {
                    transaction_id = rs.getString("transaction_id");
                    cardNumber = rs.getString("cardNumber");
                }
            }
        }

    }

    public static String shouldDeleteFromDBToBuy() {
        val SQL = "DELETE FROM payment_entity;";
        return SQL;
    }

    public static CardsInfo getCardsInfoWith41ToBuyInCredit() throws SQLException {
        val cardNumberSQL = "SELECT * FROM credit_request_entity;";
        try (
                val conn = DriverManager.getConnection("jdbc:mysql://192.168.99.100:3306/app", "app", "pass");
                val cardNumberStmt = conn.prepareStatement(cardNumberSQL);
        ) {
            try (val rs = cardNumberStmt.executeQuery(cardNumberSQL)) {
                String id = "";
                String cardNumber = "";
                while (rs.first()) {
                    id = rs.getString("id");
                    cardNumber = rs.getString("cardNumber");
                }
            }
        }
        return new CardsInfo("4444 4444 4444 4441", "08", "22", "Name", "999");
    }

    public static CardsInfo getCardsInfoWith42ToBuyInCredit() throws SQLException {
        val cardNumberSQL = "SELECT * FROM credit_request_entity;";
        try (
                val conn = DriverManager.getConnection("jdbc:mysql://192.168.99.100:3306/app", "app", "pass");
                val cardNumberStmt = conn.prepareStatement(cardNumberSQL);
        ) {
            try (val rs = cardNumberStmt.executeQuery(cardNumberSQL)) {
                String id = "";
                String cardNumber = "";
                while (rs.last()) {
                    id = rs.getString("id");
                    cardNumber = rs.getString("cardNumber");
                }
            }
        }
        return new CardsInfo("4444 4444 4444 4442", "08", "22", "Name", "999");
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
