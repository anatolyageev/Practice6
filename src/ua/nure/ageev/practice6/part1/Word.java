package ua.nure.ageev.practice6.part1;

public class Word implements Comparable {

	private String word;
	private int frequency;

	public Word(String word) {
		this.word = word;
		frequency = 1;
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
		return word + " : " + frequency;
	}

	@Override
	public int compareTo(Object o) {
			return this.word.compareTo(((Word) o).word);
	}

}
