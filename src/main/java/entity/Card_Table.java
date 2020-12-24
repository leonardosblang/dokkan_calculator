package entity;

public class Card_Table {


	String id,apt, name,team,type,rarity;
	

	public Card_Table(String id, String name, String apt, String team, String type, String rarity) {
		super();
		this.id = id;
		this.name = name;
		this.apt = apt;
		this.team = team;
		this.type = type;
		this.rarity = rarity;
	}

	




	public String getId() {
		return id;
	}






	public void setId(String id) {
		this.id = id;
	}






	public String getApt() {
		return apt;
	}






	public void setApt(String apt) {
		this.apt = apt;
	}






	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRarity() {
		return rarity;
	}

	public void setRarity(String rarity) {
		this.rarity = rarity;
	}
	
	
	
	
	
	
}
