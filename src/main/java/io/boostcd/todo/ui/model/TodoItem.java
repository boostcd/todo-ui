package io.boostcd.todo.ui.model;

public class TodoItem {

	private int id;
	private int listId;
	
	private String notes;
	private boolean completed;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
		
	public int getListId() {
		return listId;
	}
	
	public void setListId(int listId) {
		this.listId = listId;
	}
	public String getNotes() {
		return notes;
	}
	
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	public boolean isCompleted() {
		return completed;
	}
	
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	
	public String getState() {
		return completed ? "Completed" : "Todo";
	}
}
