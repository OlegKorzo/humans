package com.unicorn.korzo.humans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HumanDAOImpl implements HumanDAO{
	
	
	private boolean run(Human human, String method){
		
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb", "java", "java");
	        
	        PreparedStatement st = null;
	        
	        if (method.equals("add")) {
	        	st = conn.prepareStatement("insert into human(age, name, prof_id) values (?, ?, ?)");
	        	st.setInt(1, human.getAge());
	        	st.setString(2, human.getName());
	        	st.setInt(3, human.getProf().getId());
	        	
	        };
	        
	        if (method.equals("remove")) {
	        	st = conn.prepareStatement("delete from human where id = ?");
	        	st.setInt(1, human.getId());
	        };
	
	        if (method.equals("update")) {
	        	st = conn.prepareStatement("update human set age = ?, name = ?, prof_id = ? where id = ?");
	        	st.setInt(1, human.getAge());
	        	st.setString(2, human.getName());
	        	st.setInt(3, human.getId());
	        	st.setInt(4, human.getProf().getId());
	        };
	        
	        Boolean ret = st.execute();
	        if (method.equals("add")) {
	        	ResultSet rs = conn.createStatement().executeQuery("select last_insert_id() as last_id");
		        while (rs.next()){
		        	human.setId(rs.getInt(1));
		        }
	        }
	        
	        return ret;
        

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	public boolean add(Human human) {
		return run(human, "add");

	}

	public boolean remove(Human human) {
		return run(human, "remove");
	}

	public boolean update(Human human) {
		return run(human, "update");
	}

	public List<Human> findAll() {
		List<Human> list = new ArrayList<Human>();
		
		try {
			//Connection  conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
			Connection  conn = UtilSQL.conn;
	        conn.setAutoCommit(false);
	        
	        ResultSet rs = conn.createStatement().executeQuery("select id, age, name from human");
	        while (rs.next()){
	        	list.add(new Human(rs.getInt("id"), rs.getInt("age"), rs.getString("name")));
	        }
        

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}		
		
		// TODO Auto-generated method stub
		return list;
	}
	
	public HumanDAOImpl() {
		
	}
	
	public Human findByName(String name){
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb", "java", "java");
	        
	        
	        PreparedStatement st = null;
	        
	        
	        st = conn.prepareStatement("select id, age from human where name = ?");
        	st.setString(1, name);
        	st.execute();
        	
	        while (st.getResultSet().next()){
	        	return new Human(st.getResultSet().getInt("id"), st.getResultSet().getInt("age"), name);
	        }
        

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return new Human();		
	}
	
	public List<Human> findByCriteria() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Human> findByAge() {
		// TODO Auto-generated method stub
		return null;
	}

}
