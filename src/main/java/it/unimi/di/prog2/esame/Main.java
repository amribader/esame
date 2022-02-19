package it.unimi.di.prog2.esame;

public class Main {

  public static void main(String[] args) {
    Wordle game = new Wordle();
    Player mattia = new Player("Mattia", game);

    // mattia.setStrategy( ... ) ;


    int result = mattia.play();
    if (result >= 0) {
      System.out.println("You guess it in " + (result + 1) + " tries!");
    } else {
      System.out.println("You lost...");
    }

  }

}
