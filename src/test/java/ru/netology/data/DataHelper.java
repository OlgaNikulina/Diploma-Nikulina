package ru.netology.data;

import javafx.beans.binding.When;
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
        val cardNumberSQL = "INSERT INTO payment_entity(cardNumber) VALUES (?);";
        try (
                val conn = DriverManager.getConnection("jdbc:mysql://192.168.99.100:3306/app", "app", "pass");
                val cardNumberStmt = conn.prepareStatement(cardNumberSQL);
        ) {
            try (val rs = cardNumberStmt.executeQuery(cardNumberSQL)) {
                String cardNumber = "";
                while (rs.next()) {
                    cardNumber = rs.getString("cardNumber");
                }
            }
        }
        return new CardsInfo(cardNumberSQL, "08", "22", "Name", "999");
    }

    public static CardsInfo getCardsInfoWith42() {
        return new CardsInfo("4444 4444 4444 4442", "08", "22", "Name", "999");
    }

    public static CardsInfo getCardsInfoWithEmptyFields() {
        return new CardsInfo("", "", "", "", "");
    }

    public static CardsInfo getCardsInfoWithSingleSymbols() {
        return new CardsInfo("1", "1", "1", "1", "1");
    }
}
