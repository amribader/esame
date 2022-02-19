package it.unimi.di.prog2.esame;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import it.unimi.di.prog2.esame.Wordle.MARKING;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class WordleTest {
  Wordle game;

  @BeforeEach
  void setUp() {
    game = new Wordle("PROVA");
  }

  @Test
  void tryCorrectWord() {
    MARKING[] actual = game.tryWord("PROVA");
    MARKING[] expected = new MARKING[Wordle.WORD_LEN];
    Arrays.fill(expected, MARKING.RIGHT);
    assertArrayEquals(expected, actual);
  }

  @Test
  void tryWrongWord() {
    MARKING[] actual = game.tryWord("BIZZE");
    MARKING[] expected = new MARKING[Wordle.WORD_LEN];
    Arrays.fill(expected, MARKING.NOT_FOUND);
    assertArrayEquals(expected, actual);
  }

  @Test
  void tryPartiallyWrongWord() {
    MARKING[] actual = game.tryWord("PIZZE");
    MARKING[] expected = new MARKING[Wordle.WORD_LEN];
    Arrays.fill(expected, MARKING.NOT_FOUND);
    expected[0] = MARKING.RIGHT;
    assertArrayEquals(expected, actual);
  }

  @Test
  void tryPartiallyWrongWord2() {
    MARKING[] actual = game.tryWord("MONTE");
    MARKING[] expected = new MARKING[Wordle.WORD_LEN];
    Arrays.fill(expected, MARKING.NOT_FOUND);
    expected[1] = MARKING.WRONG_PLACE;
    assertArrayEquals(expected, actual);
  }

  @Test
  void tryPartiallyWrongWord3() {
    MARKING[] actual = game.tryWord("MAMME");
    MARKING[] expected = new MARKING[Wordle.WORD_LEN];
    Arrays.fill(expected, MARKING.NOT_FOUND);
    expected[1] = MARKING.WRONG_PLACE;
    assertArrayEquals(expected, actual);
  }

  @Test
  void tryPartiallyWrongWord4() {
    MARKING[] actual = game.tryWord("PRORA");
    MARKING[] expected = new MARKING[Wordle.WORD_LEN];
    Arrays.fill(expected, MARKING.RIGHT);
    expected[3] = MARKING.NOT_FOUND;
    assertArrayEquals(expected, actual);
  }



  @Test
  void illegalTry() {
    assertThrows(AssertionError.class, () -> game.tryWord("xxxxxxxxxxxxxxxxxxxxxx"));
  }

  @Test
  void illegalTries() {
    for (int i = 0; i < Wordle.NUM_TRIES; i++) {
      game.tryWord("PIZZA");
    }
    assertThrows(AssertionError.class, () -> game.tryWord("PROVA"));
  }


}