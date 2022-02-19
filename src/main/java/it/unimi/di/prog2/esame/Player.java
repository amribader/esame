package it.unimi.di.prog2.esame;

import it.unimi.di.prog2.esame.strategies.Chain;

public class Player {
  public final String name;
  private final Wordle game;
  private final Answers previous = new Answers();
  private Chain strategy;

  public Player(String name, Wordle game) {
    this.name = name;
    this.game = game;
  }

  public void setStrategy(Chain s) {
    strategy = s;
  }

  public int play() {
    // Il metodo ritorna il numero del tentativo in cui si è indovinata la parola segreta o -1 in caso di fallimento

    // TODO: implementare opportunamente questo metodo

    return -1; // Non indovinata
  }
}
