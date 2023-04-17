package com.musala.drones.util;

import lombok.experimental.UtilityClass;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@UtilityClass
public class MedicineUtil {

    public static boolean checkHasSpecialCharacter(String word){
        Pattern special = Pattern.compile ("[!@#$%&*()+=|<>?{}\\[\\]~]");
        Matcher hasSpecial = special.matcher(word);

        return hasSpecial.find();
    }

    public static boolean checkHasNumbers(String word){
        Pattern numbers = Pattern.compile ("[0-9]");
        Matcher hasNumbers = numbers.matcher(word);

        return hasNumbers.find();
    }

    public static boolean checkHasSmallCase(String word){
        Pattern smallCase = Pattern.compile ("[a-z]");
        Matcher hasSmallCase = smallCase.matcher(word);

        return hasSmallCase.find();
    }
}
