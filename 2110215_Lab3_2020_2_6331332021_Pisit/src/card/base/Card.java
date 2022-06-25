package card.base;


//You CAN modify the first line
public abstract class Card {
	private String name;
	private String Description;
	
	public Card(String name, String description) {
		this.name = name;
		this.Description = description;
	}
	
	public abstract String toString();
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return Description;
	}
}
