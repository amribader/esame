package it.unimi.di.prog2.esame;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.*;

public class Wordle implements Iterable<String> {
  public final static int WORD_LEN = 5;
  public final static int NUM_TRIES = 20;
  private final Set<String> dictionary = new HashSet<>();
  private int turn = 0;
  private String secret;
  private boolean won = false;

  public Wordle() {
    loadDict();
    int choose = new Random().nextInt(dictionary.size());
    int i = 0;
    for (String s : dictionary) {
      if (i++ == choose) {
        secret = s.toUpperCase();
        System.err.println(secret);
        break;
      }
    }
  }

  public Wordle(String secret) {
    loadDict();
    assert dictionary.contains(secret.toUpperCase());
    this.secret = secret.toUpperCase();
  }

  public Collection<String> dict() {
    return new HashSet<>(dictionary);
  }

  private void loadDict() {
    ClassLoader loader = Thread.currentThread().getContextClassLoader();
    URL dict = loader.getResource("dict.txt");
    assert (dict != null) : "Dictionary not found";
    File f = new File(dict.getPath());
    try {
      Scanner s = new Scanner(f);
      dictionary.clear();
      while (s.hasNextLine()) {
        String word = s.nextLine().trim();
        if (word.length() == WORD_LEN &&
            word.chars().allMatch((c) -> Character.isLetter(c) && Character.isLowerCase(c))) {
          dictionary.add(word.toUpperCase());
        }
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    assert dictionary.size() > NUM_TRIES + 1 : "Not enough words to make a fun game";
  }

  @Override
  public Iterator<String> iterator() {
    return dictionary.iterator();
  }

  public MARKING[] tryWord(String word) {
    assert word.length() == WORD_LEN;
    assert turn < NUM_TRIES;
    assert dictionary.contains(word);
    String candidate = word.toUpperCase();
    Map<Character, Integer> counter = new HashMap<>();
    for (int i = 0; i < secret.length(); i++) {
      counter.put(secret.charAt(i), 1 + counter.getOrDefault(secret.charAt(i), 0));
    }

    MARKING[] m = new MARKING[WORD_LEN];
    for (int i = 0; i < secret.length(); i++) {
      char c = candidate.charAt(i);
      if (secret.charAt(i) == c) {
        m[i] = MARKING.RIGHT;
        counter.put(c, counter.get(c) - 1);
        won = i == 0 || won;
      } else if (counter.containsKey(c) && counter.get(c) > 0) {
        m[i] = MARKING.WRONG_PLACE;
        counter.put(c, counter.get(c) - 1);
        won = false;
      } else {
        m[i] = MARKING.NOT_FOUND;
        won = false;
      }
    }
    turn += 1;
    return m;
  }

  public boolean isWon() {
    return won;
  }

  public enum MARKING {
    NOT_FOUND, WRONG_PLACE, RIGHT
  }
}
