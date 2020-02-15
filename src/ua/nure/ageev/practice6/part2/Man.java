package ua.nure.ageev.practice6.part2;

public class Man {
	private Long Id;

	public Man(Long id) {
		super();
		Id = id;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	@Override
	public String toString() {
		return  String.valueOf(Id);
	}
}
