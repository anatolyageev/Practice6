package ua.nure.ageev.practice6.part1;

import java.util.*;

public class WordContainer extends ArrayList<Word> {

    /**
     * Overrides @add method from original class to add sorting functionality and additional changes to internal object
     * @param e
     * @return
     */
    @Override
    public boolean add(Word e) {
        if (!contains(e)) {
            return super.add(e);
        }
        increaseCount(e);
        sortThis();
        return true;
    }

    private void sortThis() {
        Collections.sort(this, (o1, o2) -> {
            int temp = o2.getFrequency() - o1.getFrequency();
            if(temp==0){
                temp = o1.getWord().compareTo(o2.getWord());
            }
            return  temp;
        });
    }

    /**
     * Method which increments number of word income
     * @param e
     */
    private void increaseCount(Word e) {
        Iterator<Word> iterator = iterator();
        while (iterator.hasNext()) {
            Word temp = iterator.next();
            if (temp.equals(e)) {
                temp.frequencyIncrement();
            }
        }
    }
}

