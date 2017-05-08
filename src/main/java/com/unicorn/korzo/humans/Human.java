package com.unicorn.korzo.humans;

public class Human {
	private int id;
	private int age;
	private String name;
	private Profession prof; 
	
	public Human(int age, String name){
		this.id = -1;
		this.age = age;
		this.name = name;
		this.prof = new Profession();
	}
	
	public Human(int id, int age, String name){
		this.id = Integer.toString(id).equals("") ? -1 : id;
		this.age = age;
		this.name = name;
		this.prof = new Profession();
	}
	
	public Human(int age, String name, Profession prof){
		this.id = -1;
		this.age = age;
		this.name = name;
		this.prof = prof;
	}

	public Human() {
		this.id = -1;
		this.age = -1;
		this.name = "";
	}

	public int getId() {
		return id;
	}
	
	public Profession getProf() {
		return prof;
	}

	public void setProf(Profession prof) {
		this.prof = prof;
	}	
	
	public void setId(int id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString(){
		return this.age + " " + this.name + "(" + this.id + ")";
	}
	

}
