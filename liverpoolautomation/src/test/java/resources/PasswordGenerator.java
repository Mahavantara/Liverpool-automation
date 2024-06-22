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
        String upperCasePass = RandomStringUtils.random(1, UPPERCASE);
        String lowerCasePass = RandomStringUtils.random(1, LOWERCASE);
        String digitPass = RandomStringUtils.random(1, DIGITS);
        String specialCharPass = RandomStringUtils.random(1, SPECIAL_CHARACTERS);

        String remainingCharsPass = RandomStringUtils.random(length - 4, 
        ALL_CHARACTERS);

        String combinedCharsPass = upperCasePass + lowerCasePass + digitPass + specialCharPass + remainingCharsPass;
        List<Character> characters = new ArrayList<>();
        for (char c : combinedCharsPass.toCharArray()) {
            characters.add(c);
        }
        Collections.shuffle(characters);

        StringBuilder shuffledPassword = new StringBuilder();
        for (char c : characters) {
            shuffledPassword.append(c);
        }

        return shuffledPassword.toString();
    }

    public static String generateUserRandom() {
        String lowerCaseUser = RandomStringUtils.random(6, LOWERCASE);
        String digitUser = RandomStringUtils.random(4, DIGITS);
        String domainUser = "@gmail.com";

        String combinedCharUser = lowerCaseUser + digitUser;
        List<Character> charactersUser = new ArrayList<>();
        for(char c : combinedCharUser.toCharArray()) {
            charactersUser.add(c);
        }

        Collections.shuffle(charactersUser);
        
        StringBuilder shuffledUsernName = new StringBuilder();
        for(char c : charactersUser){
            shuffledUsernName.append(c);
        }
        String userName = shuffledUsernName.toString() + domainUser;

        return userName;
    }

}

