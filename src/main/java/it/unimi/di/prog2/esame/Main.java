package it.unimi.di.prog2.esame;

import it.unimi.di.prog2.esame.strategies.*;

public class Main {

  public static void main(String[] args) throws FailedStrategyError {
    Wordle game = new Wordle();
    Player mattia = new Player("Mattia", game);

    //mattia.setStrategy(new DiscardTriedWords(Chain.ULTIMO));
    mattia.setStrategy(new DiscardTriedWords(new ConsiderRightHints(Chain.ULTIMO)));

    int result = mattia.play();
    if (result >= 0) {
      System.out.println("You guess it in " + (result + 1) + " tries!");
    } else {
      System.out.println("You lost... in"+(result + 1) + " tries!" );
    }

  }

}
