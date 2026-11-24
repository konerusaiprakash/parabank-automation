package com.saiprakash.parabank.utils;

/** Generates unique test data so every run registers a fresh customer. */
public final class TestDataGenerator {

    public static final String DEFAULT_PASSWORD = "Test@1234";

    private TestDataGenerator() {
    }

    public static String uniqueUsername() {
        return "user" + System.currentTimeMillis();
    }
}
