package it.unimi.di.prog2.esame.strategies;

import it.unimi.di.prog2.esame.Answers;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public interface Chain {
  String chooseWord(@NotNull Collection<String> candidates,
                    @NotNull Answers feedback) throws FailedStrategyError;
}
