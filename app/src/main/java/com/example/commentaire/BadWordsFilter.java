package com.example.commentaire;

import java.util.Arrays;
import java.util.List;

public class BadWordsFilter {
    private static final List<String> BAD_WORDS = Arrays.asList("Merde", "Chier", "Salaud");

    public static boolean containsBadWords(String text) {
        for (String badWord : BAD_WORDS) {
            if (text.toLowerCase().contains(badWord.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public static String filterBadWords(String text) {
        for (String badWord : BAD_WORDS) {
            text = text.replaceAll("(?i)" + badWord, "****");
        }
        return text;
    }
}

