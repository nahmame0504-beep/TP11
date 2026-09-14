package com.example.tp;

import java.util.Map;
import java.util.Scanner;

public class TestDictionary {
    public static void main(String[] args) {
        DictionaryManager dict = new DictionaryManager();

        dict.addEntry("apple", "pomme");
        dict.addEntry("banana", "banane");
        dict.addEntry("cherry", "cerise");
        dict.addEntry("date", "datte");
        dict.addEntry("apricot", "abricot");

        dict.displayAll();

        Scanner sc = new Scanner(System.in);

        System.out.print("\nMot à traduire : ");
        String word = sc.nextLine().trim();
        String tr = dict.getTranslation(word);
        System.out.printf("Traduction de '%s' : %s%n", word, tr != null ? tr : "[non trouvé]");

        System.out.print("\nPréfixe à chercher : ");
        String pref = sc.nextLine().trim();
        Map<String, String> results = dict.searchByPrefix(pref);
        System.out.println("Résultats pour \"" + pref + "\" :");
        results.forEach((k, v) -> System.out.printf("%-10s → %s%n", k, v));

        System.out.print("\nMot à supprimer : ");
        String rem = sc.nextLine().trim();
        if (dict.removeEntry(rem)) {
            System.out.printf("'%s' supprimé avec succès.%n", rem);
        } else {
            System.out.printf("'%s' introuvable.%n", rem);
        }

        System.out.println();
        dict.displayAll();

        sc.close();
    }
}