package it.unimi.di.prog2.esame.strategies;

import it.unimi.di.prog2.esame.Answers;
import it.unimi.di.prog2.esame.Wordle;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class DiscardTriedWords implements Chain{

    private final @NotNull Chain next;

    public DiscardTriedWords(@NotNull Chain next) {
        this.next = next;
    }


    @Override
    public String chooseWord(@NotNull Collection<String> candidates, @NotNull Answers feedback) throws FailedStrategyError {
        //togliere le parole già provate
        //togliere da cadidati answer
        //System.err.println(candidates.size());
        for (Map.Entry<String, Wordle.MARKING[]> stringEntry : feedback) {
            candidates.remove(stringEntry.getKey());
        }

        System.out.println(candidates.size());
        if (candidates.size() < 10){
            return candidates.iterator().next();
        }

        return next.chooseWord(candidates,feedback);
    }
}
