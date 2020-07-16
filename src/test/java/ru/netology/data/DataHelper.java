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
        val cardNumberSQL = "SELECT number FROM data.js";
        try (
            val conn = DriverManager.getConnection("jdbc:mysql://192.168.99.100:3306/app", "app", "pass");
            val cardNumberStmt = conn.prepareStatement(cardNumberSQL);
        ){
            try (val rs = cardNumberStmt.executeQuery(cardNumberSQL)) {
                String number = "";
                while (rs.next()) {
                    number = rs.getString("number");
                }
                return new CardsInfo("4444 4444 4444 4441", "08", "22", "Name", "999");
            }
            }
        };

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
