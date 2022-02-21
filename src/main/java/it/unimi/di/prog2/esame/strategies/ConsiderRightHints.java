package it.unimi.di.prog2.esame.strategies;

import it.unimi.di.prog2.esame.Answers;
import it.unimi.di.prog2.esame.Wordle;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class ConsiderRightHints implements Chain{
    private final @NotNull Chain next;

    public ConsiderRightHints(@NotNull Chain next) {
        this.next = next;
    }

    @Override
    public String chooseWord(@NotNull Collection<String> candidates, @NotNull Answers feedback) throws FailedStrategyError {
//
//        List<String> result = new ArrayList<>(candidates);
////        System.err.println(result.size());
////        System.err.println(candidates.size());
//        StringBuilder s =new StringBuilder();
//        //togliere le parole che non rispettano i RIGHT marking (ConsiderRightHints)
//        //int i = 0;
//        for (Map.Entry<String, Wordle.MARKING[]> stringEntry : feedback) {
//            int i =0;
//            for (Wordle.MARKING marking : stringEntry.getValue()) {
//                if (!marking.equals(Wordle.MARKING.RIGHT)){
////                    System.out.println(stringEntry.getKey().charAt(i));
////                    System.out.println(marking);
//                    s.append(stringEntry.getKey().charAt(i));
//                    //letterCorrette.add(stringEntry.getKey().charAt(i));
//                    //candidates.remove(stringEntry.getKey());
//                    //letterCorrette.add(String.valueOf(stringEntry.getKey().charAt(i)));
////                    for (String candidate : candidates) {
////                        if (candidate.indexOf(stringEntry.getKey().charAt(i))!=-1){
////                            System.out.println("candidati:" +candidate);
////                            //System.out.println(stringEntry.getKey().charAt(i));
////                            result.remove(candidate);
////                        }
////                    }
//                    //candidates.removeIf(candidate -> {
//                    //    return candidate.indexOf(stringEntry.getKey().charAt(i));
//                    //});
//                }
//                i++;
//            }
//        }
//        if (s.isEmpty()){
//            return next.chooseWord(result,feedback);
//        }
//
//
//        System.err.println("lettere da aliminare"+s);
////
////        for (String candidate : candidates) {
////            for (int i = 0; i < s.length(); i++) {
////                if (candidate.indexOf(s.charAt(i))!=-1){
////                    //System.out.println("candidati:" +candidate);
////                    //System.out.println(stringEntry.getKey().charAt(i));
////                    result.remove(candidate);
////                }
////            }
////
////        }
//
//
//        /*
//        List<String> arr = new ArrayList<>();
//        System.err.println(letterCorrette);
//        for (String candidate : candidates) {
//            for (CharSequence character : letterCorrette) {
//                if (candidate.contains(character)){
//                arr.add(candidate);
//                }
//            }
//        }
//        candidates.removeAll(arr);
//        System.out.println(candidates.size());
//         */
//        System.err.println("-r-"+result.size());
//        System.err.println("-c-"+candidates.size());

//        Collection<String> result = new HashSet<>(candidates);//tolgo tutte le parole che non hanno una right
//        for (Map.Entry<String, Wordle.MARKING[]> stringEntry : feedback) {
//            String s = stringEntry.getKey();
//            Wordle.MARKING[] markings = stringEntry.getValue();
//            for (int i = 0; i <s.length(); i++) {
//                if (markings[i] == Wordle.MARKING.RIGHT){
//                    for (String candidate : candidates) {
//                        if (candidate.charAt(i) != s.charAt(i)){
//                            result.remove(candidate);
//                        }
//                    }
//                }
//            }
//        }

        //tolgo tutte le parole che non hanno una right
        List<String> result = new ArrayList<>(candidates);
        for (Map.Entry<String, Wordle.MARKING[]> stringEntry : feedback) {
            int i = 0;
            for (Wordle.MARKING marking : stringEntry.getValue()) {
                if (marking.equals(Wordle.MARKING.RIGHT)){
                    for (String candidate : candidates) {
                        if (candidate.charAt(i) != stringEntry.getKey().charAt(i)){
                            result.remove(candidate);
                        }
                    }
                }
                i++;
            }
        }


        if (result.size() < 10){
            return result.iterator().next();
        }

        return next.chooseWord(result,feedback);
    }
}
