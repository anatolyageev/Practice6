package ua.nure.ageev.practice6.part1;

public class Word implements Comparable {
	static Integer count=0;
	private Integer place;
	private String word;
	private int frequency;
	private boolean part61Flag;


	public Word(String word) {
		this.word = word;
		frequency = 1;
	}

	public  Integer getPlace() {
		return this.place;
	}

	public Word(String word, Long frequency) {
		this.word = word;
		this.frequency = frequency.intValue();
		this.part61Flag = true;
	}

	public Word(String word, Integer length){
		this.word = word;
		this.frequency = length;
		this.part61Flag = true;
		count ++;
		place=count;
	}

	public void frequencyIncrement(){
		frequency++;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Word)) {
			return false;
		}
		Word word1 = (Word) o;
		return word.equalsIgnoreCase(word1.word);
	}

	@Override
	public int hashCode() {
		return word.hashCode();
	}

	@Override
	public String toString() {
		return part61Flag ? word + " ==> " + frequency : word + " : " + frequency;
	}

	@Override
	public int compareTo(Object o) {
			return this.word.compareTo(((Word) o).word);
	}

}
