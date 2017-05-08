package com.unicorn.korzo.humans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProfessionDAOImpl implements ProfessionDAO{
	
	public ProfessionDAOImpl(){
		
	}	
	
	
	private boolean run(Profession prof, String method){
		
		try {
			//Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb", "java", "java");
			Connection  conn = UtilSQL.conn;
	        
	        
	        PreparedStatement st = null;
	        
	        if (method.equals("add")) {
	        	st = conn.prepareStatement("insert into profession(name) values (?)");
	        	st.setString(1, prof.getName());
	        	
	        };
	        
	        if (method.equals("remove")) {
	        	st = conn.prepareStatement("delete from profession where id = ?");
	        	st.setInt(1, prof.getId());
	        };
	
	        if (method.equals("update")) {
	        	st = conn.prepareStatement("update profession set name = ? where id = ?");
	        	st.setInt(1, prof.getId());
	        	st.setString(2, prof.getName());
	        };
	        
	        Boolean ret = st.execute();
	        if (method.equals("add")) {
	        	ResultSet rs = conn.createStatement().executeQuery("select last_insert_id() as last_id");
		        while (rs.next()){
		        	prof.setId(rs.getInt(1));
		        }
	        }
	        
	        return ret;
        

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	public boolean add(Profession prof) {
		return run(prof, "add");

	}

	public boolean remove(Profession prof) {
		return run(prof, "remove");
	}

	public boolean update(Profession prof) {
		return run(prof, "update");
	}

	public List<Profession> findAll() {
		List<Profession> list = new ArrayList<Profession>();
		
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			Connection  conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb", "java", "java");
			//Connection  conn = DriverManager.getConnection("jdbc:h2:~/test;AUTO_SERVER=TRUE", "sa", "");
			
			//Connection  conn = UtilSQL.conn;
	        conn.setAutoCommit(false);
	        
	        ResultSet rs = conn.createStatement().executeQuery("select id, name from profession");
	        while (rs.next()){
	        	list.add(new Profession(rs.getInt("id"), rs.getString("name")));
	        }
        

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}		
		
		// TODO Auto-generated method stub
		return list;
	}
	
	public Profession findByName(String name){
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			Connection  conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb", "java", "java");

	        
	        PreparedStatement st = null;
	        
	        
	        st = conn.prepareStatement("select id from profession where name = ?");
        	st.setString(1, name);
        	st.execute();
        	
	        while (st.getResultSet().next()){
	        	return new Profession(st.getResultSet().getInt("id"), name);
	        }
        

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return new Profession();		
	}
	
	public List<Profession> findByCriteria() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Profession> findByAge() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
