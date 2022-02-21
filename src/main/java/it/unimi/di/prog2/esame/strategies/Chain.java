package it.unimi.di.prog2.esame.strategies;

import it.unimi.di.prog2.esame.Answers;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Scanner;

public interface Chain {

  //Il primo anello da implementare è quindi appunto questo null object
  Chain ULTIMO = (@NotNull Collection<String> candidates,
                  @NotNull Answers feedback) -> candidates.iterator().next();

  String chooseWord(@NotNull Collection<String> candidates,
                    @NotNull Answers feedback) throws FailedStrategyError;
}
