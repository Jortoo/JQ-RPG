package me.jqrtox.rpg.Main;

public class StringUtils {

    public static String capitalizeFirstLetter(String input) {
        if (input == null || input.isEmpty()) {
            return input;  // Return the original string if it's null or empty
        }

        // Capitalize the first letter and concatenate with the rest of the string
        return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
    }
    public static String Format(Integer number){
        return String.format("%,d", number);
    }
}

