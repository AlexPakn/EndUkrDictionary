package com.simethinkidk.n3collectionshw2;

import java.util.Arrays;
import java.util.Collections;

public class Main {

  public static void main(String[] args) {
    EnglishToUkrainianDictionary dictionary = new EnglishToUkrainianDictionary();

    String[] words = {"hello", "world", "java", "fun", "run", "jump", "play", "study", "sleep",
        "eat", "drink", "watch", "listen", "read", "write", "ride", "fly", "sing", "dance"};

    String[][] translations = {
        {"привіт", "здравствуйте", "добридень"},
        {"світ", "всесвіт", "планета"},
        {"ява"},
        {"забава", "веселощі"},
        {"біг"},
        {"стрибок"},
        {"грати", "гульня"},
        {"вчитися"},
        {"спати", "дрімати"},
        {"їсти"},
        {"пити"},
        {"дивитися"},
        {"слухати"},
        {"читати"},
        {"писати"},
        {"їздити"},
        {"літати", "злітати"},
        {"співати"},
        {"танцювати", "плясати"}
    };

    for (int i = 0; i < words.length; i++) {
      for (String translation : translations[i]) {
        dictionary.put(words[i], translation);
      }
    }

    System.out.println("All translations: ");
    for (String word : words) {
      System.out.println(word + ": " + dictionary.get(word) + ", counter: " + dictionary.getCounter(word));
    }

    System.out.println("Translations for 'dance': " + dictionary.get("dance") +
        ", counter: " + dictionary.getCounter("dance"));

    System.out.println("Most popular words: " + dictionary.getMostPopularWords());

    System.out.println("Least popular words: " + dictionary.getLeastPopularWords());
  }
}