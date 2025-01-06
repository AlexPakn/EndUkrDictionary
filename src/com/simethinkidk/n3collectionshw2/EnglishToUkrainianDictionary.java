package com.simethinkidk.n3collectionshw2;

import java.util.*;

public class EnglishToUkrainianDictionary {

    private Map<String, Pair<List<String>, Integer>> dictionary;

    public EnglishToUkrainianDictionary() {
        dictionary = new HashMap<>();
    }

    public void put(String englishWord, String ukrainianWord) {
        if(dictionary.containsKey(englishWord)) {
            dictionary.get(englishWord).first.add(ukrainianWord);
            dictionary.put(englishWord, new Pair<>(dictionary.get(englishWord).first,
                dictionary.get(englishWord).second)); // kinda cringe ngl.
        } else {
            List<String> list = new ArrayList<>();
            list.add(ukrainianWord);
            dictionary.put(englishWord, new Pair<>(list, 0));
        }
    }

    public List<String> get(String englishWord) {
        if(dictionary.containsKey(englishWord)) {
            int counter = dictionary.get(englishWord).second + 1;
            dictionary.put(englishWord, new Pair<>(dictionary.get(englishWord).first, counter));
            return dictionary.get(englishWord).first;
        }
        return new ArrayList<>();
    }

    public int getCounter(String englishWord) {
        if(dictionary.containsKey(englishWord)) {
            return dictionary.get(englishWord).second;
        }
        return 0;
    }

    // this is so much easier with AI fr
    public List<String> getMostPopularWords() {
        return dictionary.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().second - e1.getValue().second)
                .limit(10)
                .map(Map.Entry::getKey)
                .toList();
    }

    public List<String> getLeastPopularWords() {
        return dictionary.entrySet().stream()
                .sorted(Comparator.comparingInt(e -> e.getValue().second))
                .limit(10)
                .map(Map.Entry::getKey)
                .toList();
    }

    public void updateEnglishWord(String oldEnglishWord, String newEnglishWord) {
        if(dictionary.containsKey(oldEnglishWord)) {
            Pair<List<String>, Integer> pair = dictionary.get(oldEnglishWord);
            dictionary.remove(oldEnglishWord);
            dictionary.put(newEnglishWord, pair);
        }
    }

    public void updateTranslation(String englishWord, String oldUkrainianWord, String newUkrainianWord) {
        if(dictionary.containsKey(englishWord)) {
            List<String> list = dictionary.get(englishWord).first;
            int index = list.indexOf(oldUkrainianWord);
            if(index != -1) {
                list.set(index, newUkrainianWord);
            }
        }
    }

    public void deleteTranslation(String englishWord, String ukrainianWord) {
        if(dictionary.containsKey(englishWord)) {
            List<String> list = dictionary.get(englishWord).first;
            int index = list.indexOf(ukrainianWord);
            if(index != -1) {
                list.remove(index);
            }
        }
    }

    public void deleteEnglishWord(String englishWord) {
        dictionary.remove(englishWord);
    }

    private static class Pair<F, S> {
        final F first;
        final S second;

        public Pair(F first, S second) {
            this.first = first;
            this.second = second;
        }
    }
}