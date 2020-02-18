package ua.nure.ageev.practice6.part6;

import java.util.*;
import static ua.nure.ageev.practice6.Utils.getInitInfo;

public class Part63 extends Part61 {

    public Part63(String fileName) {
        super(fileName);
    }

    @Override
    public void fillMap() {
        wordList = new ArrayList(Arrays.asList(getInitInfo(fileName, CHARSET).split(" ")));
        LinkedList<String> words = new LinkedList<>();
        for(String num : wordList) {
            if(Collections.frequency(wordList, num) > 1) {
                words.add(num.toUpperCase());
            }
        }
        printPart63(words);
    }

    private void printPart63(LinkedList<String> words){
        int count =0;
        for (String w: words){
            if(count==3){break;}
            System.out.println(w);
            count++;
        }
    }

}
