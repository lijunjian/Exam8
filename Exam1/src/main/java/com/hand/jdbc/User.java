package com.hand.jdbc;

public class User extends IdEntity {

	private String title;
	private String description;
	private String language;

	

	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getLanguage() {
		return language;
	}



	public void setLanguage(String language) {
		this.language = language;
	}



	@Override
	public String toString() {
		return "User [title=" + title + ", description=" + description + ", language=" + language + ", id=" + id + "]";
	}

}
