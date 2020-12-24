package entity;

import java.io.File;

public class Card {

	private int typeId;
	
	private String name;
	private String subname;
	private String Team;
	
	private File icon;

	private File artPreview;

	private int apt;
	
	private int rarityId;
	
	public String getName() {
		return name;
	}

	public String getTeam() {
		return Team;
	}

	public void setTeam(String team) {
		this.Team = team;
	}

	public File getIcon() {
		return icon;
	}

	public void setIcon(File icon) {
		this.icon = icon;
	}

	public File getArtPreview() {
		return artPreview;
	}

	public void setArtPreview(File artPreview) {
		this.artPreview = artPreview;
	}

	public int getApt() {
		return apt;
	}

	public void setApt(int apt) {
		this.apt = apt;
	}

	public int getRarityId() {
		return rarityId;
	}

	public void setRarityId(int rarityId) {
		this.rarityId = rarityId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubname() {
		return subname;
	}

	public void setSubname(String subname) {
		this.subname = subname;
	}
	

	public Card(String name, String subname, String team, File icon,
			File artPreview, int apt , int typeId , int rarityId) {
		super();
		this.name = name;
		this.subname = subname;
		this.Team = team;
		this.icon = icon;
		this.artPreview = artPreview;
		this.apt = apt;
		this.typeId = typeId;
		this.rarityId = rarityId;
		
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	
}
