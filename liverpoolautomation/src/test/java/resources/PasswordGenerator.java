package resources;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;

public class PasswordGenerator {
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_+=<>?";
    private static final String ALL_CHARACTERS = UPPERCASE + LOWERCASE + DIGITS + SPECIAL_CHARACTERS;


    public static String generateRandomPassword(int length) {
        if (length < 4) {
            throw new IllegalArgumentException("Length must be at least 4");
            
        }
        String upperCase = RandomStringUtils.random(1, UPPERCASE);
        String lowerCase = RandomStringUtils.random(1, LOWERCASE);
        String digit = RandomStringUtils.random(1, DIGITS);
        String specialChar = RandomStringUtils.random(1, SPECIAL_CHARACTERS);

        String remainingChars = RandomStringUtils.random(length - 4, 
        ALL_CHARACTERS);

        String combinedChars = upperCase + lowerCase + digit + specialChar + remainingChars;
        List<Character> characters = new ArrayList<>();
        for (char c : combinedChars.toCharArray()) {
            characters.add(c);
        }
        Collections.shuffle(characters);

        // Build the final shuffled string
        StringBuilder shuffledPassword = new StringBuilder();
        for (char c : characters) {
            shuffledPassword.append(c);
        }

        return shuffledPassword.toString();
    }

}

