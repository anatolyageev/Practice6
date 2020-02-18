package ua.nure.ageev.practice6.part6;

import ua.nure.ageev.practice6.part1.Word;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static ua.nure.ageev.practice6.Utils.getInitInfo;

public class Part61 {
    protected static final String CHARSET = "CP1251";
    protected String fileName;
    protected ArrayList<String> wordList;
    protected Map<String,Integer> wordMap;

    public Part61(String fileName) {
        this.fileName = fileName;
        wordMap = new HashMap<>();
    }

    public void fillMap(){
        wordList = new ArrayList(Arrays.asList(getInitInfo(fileName, CHARSET).split(" ")));
        Map<String, Long> counted = wordList.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        List<Word> list = fillMapHelper(counted);
        list.stream()
                .sorted(Comparator.reverseOrder()).forEach(System.out::println);
    }

    protected List<Word> fillMapHelper(Map<String, Long> counted) {
        Map<String, Long> finalMap = new LinkedHashMap<>();
        List<Word> list = new ArrayList();
        counted.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue()
                        .reversed()).forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));
        int count =0;
        for (Map.Entry<String, Long> entry: finalMap.entrySet()){
            if(count==3){break;}
            list.add(new Word(entry.getKey(),entry.getValue()));
            count++;
        }
        return list;
    }
}
