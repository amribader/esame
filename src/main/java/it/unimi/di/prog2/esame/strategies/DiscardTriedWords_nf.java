package it.unimi.di.prog2.esame.strategies;

import it.unimi.di.prog2.esame.Answers;
import it.unimi.di.prog2.esame.Wordle;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class DiscardTriedWords_nf implements Chain{

    private final @NotNull Chain next;

    public DiscardTriedWords_nf(@NotNull Chain next) {
        this.next = next;
    }


    @Override
    public String chooseWord(@NotNull Collection<String> candidates, @NotNull Answers feedback) throws FailedStrategyError {
        //togliere le parole già provate
        List<String> arr = new ArrayList<>();
        System.err.println(candidates.size());
        //togliere da cadidati answer
        for (String candidate : candidates) {
            for (Map.Entry<String, Wordle.MARKING[]> stringEntry : feedback) {
                //System.out.println(candidate+"---"+stringEntry.getKey());
                //if (candidates.contains(stringEntry.getKey())){
                if (candidate.contains(stringEntry.getKey())){
                    //System.out.println(candidate+"---"+stringEntry.getKey());
                    arr.add(candidate);
                    //candidates.remove(candidate);
                    //candidates.removeIf(x -> x.contains(feedback));
                }
            }
        }
        candidates.removeAll(arr);
        //System.err.println(candidates.size());
        //System.err.println(arr);
        //System.err.println(arr.size());

        return next.chooseWord(candidates,feedback);
    }
}
