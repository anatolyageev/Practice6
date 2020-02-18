package ua.nure.ageev.practice6.part6;

import ua.nure.ageev.practice6.part1.Word;
import java.util.*;
import java.util.stream.Collectors;

import static ua.nure.ageev.practice6.Utils.getInitInfo;

public class Part62 extends Part61 {

    public Part62(String fileName) {
        super(fileName);
    }

    @Override
    public void fillMap() {
        wordList = new ArrayList(Arrays.asList(getInitInfo(fileName, CHARSET).split(" ")));
        List<Word> words = wordList.stream()
                .map(p -> new Word(p, p.length()))
                .collect(Collectors.toList());
        SortedSet<Word> sortWord = words.stream().collect(Collectors.toCollection(TreeSet::new));
        words = new ArrayList<>(sortWord);
        sortCollection(words);
        prinTask(words);
    }

    protected void sortCollection(List<Word> words) {
        Collections.sort(words, (s1, s2) -> {
            int temp = s2.getFrequency() - s1.getFrequency();
            if (temp == 0) {
                temp = s1.getPlace() - s2.getPlace();
            }
            return temp;
        });
    }

    private void prinTask(List<Word> words) {
        int count =0;
        for (Word w: words){
            if(count==3){break;}
            System.out.println(w);
            count++;
        }
    }
}
