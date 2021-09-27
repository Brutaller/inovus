package ru.inovus.util;

import java.util.ArrayList;
import java.util.List;

public class CarNumberUtil {
    private static final char[] AVAILABLE_CHARS = {'А', 'В', 'Е', 'К', 'М', 'Н', 'О', 'Р', 'С', 'Т', 'У', 'Х'};
    private static final String REGION = " 116 RUS";
    private static List<String> availableCarNumbers;
    private static volatile int currentCarNumberIndex;

    static {
        availableCarNumbers = getAllNumbers();
    }

    public static String getRandomNumber() {
        if (availableCarNumbers.isEmpty()) {
            return "Numbers are over.";
        }
        currentCarNumberIndex = (int) (Math.random()*availableCarNumbers.size());
        String result = availableCarNumbers.get(currentCarNumberIndex);
        availableCarNumbers.remove(currentCarNumberIndex);
        return result;
    }

    public static String getNextNumber() {
        if (availableCarNumbers.isEmpty()) {
            return "Numbers are over.";
        }
        String result;
        if (currentCarNumberIndex == availableCarNumbers.size()) {
            result = availableCarNumbers.get(0);
        } else {
            result = availableCarNumbers.get(currentCarNumberIndex);
        }
        availableCarNumbers.remove(currentCarNumberIndex);
        return result;
    }

    private static List<String> getAllNumbers() {
        List<String> result = new ArrayList<>();
        for (char firstChar : AVAILABLE_CHARS) {
            for (char secondChar : AVAILABLE_CHARS) {
                for (char thirdChar : AVAILABLE_CHARS) {
                    for (int i = 1; i < 1000; i++) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(firstChar);
                        sb.append(String.format("%03d", i));
                        sb.append(secondChar);
                        sb.append(thirdChar);
                        sb.append(REGION);
                        result.add(new String(sb));
                    }
                }
            }
        }

        return result;
    }
}
