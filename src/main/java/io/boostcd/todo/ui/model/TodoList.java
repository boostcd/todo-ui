package io.boostcd.todo.ui.model;

public class TodoList {

	private int id;
	
	private String title;
	private String description;
	
	private int totalItems;
	private int totalItemsCompleted;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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
	
	public int getTotalItems() {
		return totalItems;
	}
	
	public void setTotalItems(int totalItems) {
		this.totalItems = totalItems;
	}
	
	public int getTotalItemsCompleted() {
		return totalItemsCompleted;
	}
	
	public void setTotalItemsCompleted(int totalItemsCompleted) {
		this.totalItemsCompleted = totalItemsCompleted;
	}

}
