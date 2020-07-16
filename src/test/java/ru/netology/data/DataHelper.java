package ru.netology.data;

import lombok.Value;

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

    public static CardsInfo getCardsInfoWith41() {
        return new CardsInfo("4444 4444 4444 4441", "08", "22", "Name", "999");
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
