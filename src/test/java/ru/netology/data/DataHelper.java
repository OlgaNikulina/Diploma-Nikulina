package ru.netology.data;

import com.github.javafaker.Faker;
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
        val faker = new Faker();
        val dataSQL = "INSERT INTO payment_entity(cardNumber, month, year, name, cvv) VALUES (?, ?, ?, ?, ?);";

        try (
                val conn = DriverManager.getConnection("jdbc:mysql://192.168.99.100:3306/app" , "app" , "pass" );
                val dataStmt = conn.prepareStatement(dataSQL);
        ) {
            dataStmt.setString(1, "4444 4444 4444 4441" );
            dataStmt.setString(2, "month" );
            dataStmt.setString(3, "year" );
            dataStmt.setString(4, faker.name().fullName());
            dataStmt.setString(5, "cvv" );
            dataStmt.executeUpdate();
        }
        return new CardsInfo("4444 4444 4444 4441", "08", "22", faker.name().fullName(), "999");
    }

    public static CardsInfo getCardsInfoWith42() throws SQLException {
        val faker = new Faker();
        val dataSQL = "INSERT INTO payment_entity(cardNumber, month, year, name, cvv) VALUES (?, ?, ?, ?, ?);";

        try (
                val conn = DriverManager.getConnection("jdbc:mysql://192.168.99.100:3306/app" , "app" , "pass" );
                val dataStmt = conn.prepareStatement(dataSQL);
        ) {
            dataStmt.setString(1, "4444 4444 4444 4442" );
            dataStmt.setString(2, "month" );
            dataStmt.setString(3, "year" );
            dataStmt.setString(4, faker.name().fullName());
            dataStmt.setString(2, "cvv" );
            dataStmt.executeUpdate();
        }
        return new CardsInfo("4444 4444 4444 4442", "08", "22", faker.name().fullName(), "999");
    }

    public static CardsInfo getCardsInfoWithEmptyFields() {
        return new CardsInfo("", "", "", "", "");
    }

    public static CardsInfo getCardsInfoWithSingleSymbols() {
        return new CardsInfo("1", "1", "1", "1", "1");
    }
}
