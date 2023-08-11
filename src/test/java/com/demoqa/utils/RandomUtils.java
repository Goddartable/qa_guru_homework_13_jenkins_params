package com.demoqa.utils;

import com.github.javafaker.Faker;

import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {
    static Faker faker = new Faker();

    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static String getRandomItemFromArray(String[] array) {
        int index = getRandomInt(0, array.length - 1);
        return array[index];
    }

    public static String getRandomFirstName() {
        return faker.name().firstName();
    }

    public static String getRandomLastName() {
        return faker.name().lastName();
    }

    public static String getRandomEmail() {
        return faker.internet().emailAddress();
    }

    public static String getRandomGender() {
        String[] genders = {"Male", "Female", "Other"};
        return getRandomItemFromArray(genders);
    }

    public static String getRandomPhone() {
        return faker.numerify("##########");
    }

    public static String getRandomSubject() {
        String[] genders = {"Hindi", "English", "Maths", "Physics", "Chemistry",
                "Biology", "Computer Science", "Commerce",
                "Accounting", "Economics", "Arts", "Social Studies", "History", "Civics"};
        return getRandomItemFromArray(genders);
    }

    public static String getRandomHobby() {
        String[] hobbies = {"Sports", "Reading", "Music"};
        return getRandomItemFromArray(hobbies);
    }

    public static String getRandomPicture() {
        String[] pictures = {"13912597291716.jpg", "5229cdf156ea99dc57418e9dc98c7e07.jpg", "kartinki-ezhika-na-avu-32.jpg"};
        return getRandomItemFromArray(pictures);
    }

    public static String getRandomAdress() {
        return faker.address().fullAddress();
    }

    public static String getRandomState() {
        String[] states = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
        return getRandomItemFromArray(states);
    }

    public static String getRandomCity(String getRandomCityInput) {
        String[] cityNCR = {"Delhi", "Gurgaon", "Noida"};
        String[] cityUttar = {"Agra", "Lucknow", "Merrut"};
        String[] cityHaryana = {"Karnal", "Panipat"};
        String[] cityRajasthan = {"Jaipur", "Jaiselmer"};
        String userCity;
        switch (getRandomCityInput) {
            case "NCR":
                return getRandomItemFromArray(cityNCR);

            case "Uttar Pradesh":
                return getRandomItemFromArray(cityUttar);

            case "Haryana":
                return getRandomItemFromArray(cityHaryana);
            case "Rajasthan":
                return getRandomItemFromArray(cityRajasthan);
        }
        return null;

    }

    public static String getRandomDate() {
        int day = faker.number().numberBetween(01, 28);
        if (day < 10) {
            return "0" + Integer.toString(day);
        } else {
            return Integer.toString(day);
        }
    }

    public static String getRandomMonth() {
        String[] months = {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};
        return getRandomItemFromArray(months);
    }

    public static String getRandomYear() {
        int year = faker.number().numberBetween(1900, 2005);
        return Integer.toString(year);
    }
}
