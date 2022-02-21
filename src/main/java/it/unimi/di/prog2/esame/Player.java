package it.unimi.di.prog2.esame;

import it.unimi.di.prog2.esame.strategies.Chain;
import it.unimi.di.prog2.esame.strategies.FailedStrategyError;

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

  public int play() throws FailedStrategyError {
    // Il metodo ritorna il numero del tentativo in cui si è indovinata la parola segreta o -1 in caso di fallimento
    while (previous.turn() < Wordle.NUM_TRIES){
      String s = strategy.chooseWord(game.dict(),previous);
      System.err.println("S:"+s);
      previous.addTry(s,game.tryWord(s));

      if (game.isWon()){
        return previous.turn();
      }
    }

    // TODO: implementare opportunamente questo metodo

    return -1; // Non indovinata
  }
}
/*
* while(previous.turn() < Wordle.NUM_TRIES){
      String s = "";
      s = strategy.chooseWord(game.dict(),previous);
      System.out.println(s);
      previous.addTry(s,game.tryWord(s));
      if (game.isWon())
        return previous.turn();
    }
* */