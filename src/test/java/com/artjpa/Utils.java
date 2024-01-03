package com.artjpa;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Utils {

    public static long generateRandomLong(int minValue, int maxValue) {
        // Vérifiez que la valeur minimale est inférieure ou égale à la valeur maximale
        if (minValue > maxValue) {
            throw new IllegalArgumentException("La valeur minimale doit être inférieure ou égale à la valeur maximale");
        }

        // Utilisez ThreadLocalRandom pour générer un long aléatoire entre les deux valeurs
        return ThreadLocalRandom.current().nextLong((long) minValue, (long) maxValue + 1);
    }
}
