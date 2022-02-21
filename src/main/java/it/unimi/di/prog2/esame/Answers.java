package it.unimi.di.prog2.esame;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Answers implements Iterable<Map.Entry<String,Wordle.MARKING[]>> {
  private final HashMap<String, Wordle.MARKING[]> oldTries = new HashMap<>();

  public void addTry(String word, Wordle.MARKING[] markings) {
    oldTries.put(word, markings);
  }

  public int turn() {
    return oldTries.size();
  }

  @NotNull
  @Override
  public Iterator<Map.Entry<String, Wordle.MARKING[]>> iterator() {
    return oldTries.entrySet().iterator();
  }


  //TODO Rendere visibile i tentativi tramite il pattern Iterator/Iterable

}
