package it.unimi.di.prog2.esame;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Answers  {
  private final HashMap<String, Wordle.MARKING[]> oldTries = new HashMap<>();

  public void addTry(String word, Wordle.MARKING[] markings) {
    oldTries.put(word, markings);
  }

  public int turn() {
    return oldTries.size();
  }

 //TODO Rendere visibile i tentativi tramite il pattern Iterator/Iterable

}
