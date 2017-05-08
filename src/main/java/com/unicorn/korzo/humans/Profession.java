package com.unicorn.korzo.humans;

public class Profession {
	private int id;
	private String name;
	
	public Profession(int id, String name){
		this.id = id;
		this.name = name;
	}
	
	public Profession(String name){
		this.id = -1;
		this.name = name;
	}
	
	public Profession(){
		this.id = -1;
		this.name = "";
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
		
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString(){
		return this.name + "(" + this.id + ")";
	}
	

}
