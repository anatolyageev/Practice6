package ua.nure.ageev.practice6.part2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Part2 {
    public static final Long NUMBER_MAN = (long) 10_000;
    public static final int K = 4;
    private Long numberMan;
    List<Man> arrayListMan = new ArrayList<>();
    List<Man> linkedListMan = new LinkedList<>();

    public Part2(Long numberMan) {
        this.numberMan = numberMan;
        fillList();
    }

    /**
     * Method for filling two collections
     */
    public void fillList() {
        for (Long i = (long) 0; i < numberMan; i++) {
            arrayListMan.add(new Man(i));
            linkedListMan.add(new Man(i));
        }
    }

    /**
     * Removing each k element from the collection while till 1 element in collection remains. Using index.
     * @param list
     * @param k
     */
    public void removeByIndex(List<Man> list, int k) {
        int index = 0;
        while (list.size() > 1) {
            index += k - 1;
            while (index >= list.size()) {
                index -= list.size();
            }
            list.remove(index);
        }
    }

    /**
     * Removing each k element from the collection while till 1 element in collection remains. Using Iterator.
     * @param list
     * @param k
     */
    public void removeByIterator(List<Man> list, int k) {
        Iterator<Man> manIter =  list.iterator();
        int count=0;
        while (list.size()>1){
            while (manIter.hasNext()){
                manIter.next();
                count++;
                if(count==k){
                    manIter.remove();
                    count=0;
                }
            }
            manIter =  list.iterator();

        }
    }

    public static void main(String[] args) {

        Part2 part2 = new Part2(Part2.NUMBER_MAN);

        Long before = System.currentTimeMillis();
        part2.removeByIndex(part2.arrayListMan, K);
        System.out.println("ArrayList#Index: " + (System.currentTimeMillis() - before) + " ms");

        before = System.currentTimeMillis();
        part2.removeByIndex(part2.linkedListMan, K);
        System.out.println("LinkedList#Index: " + (System.currentTimeMillis() - before) + " ms");

        part2 = new Part2(Part2.NUMBER_MAN);
        before = System.currentTimeMillis();
        part2.removeByIterator(part2.arrayListMan, K);
        System.out.println("ArrayList#Iterator: " + (System.currentTimeMillis() - before) + " ms");

        before = System.currentTimeMillis();
        part2.removeByIterator(part2.linkedListMan, K);
        System.out.println("LinkedList#Iterator: " + (System.currentTimeMillis() - before) + " ms");
    }
}
