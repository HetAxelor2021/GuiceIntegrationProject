package com.hh.web.dao;

import java.sql.*;

import com.hh.web.model.Alien;

public class AlienDao {
	public Alien getAlien(int aid) {
		Alien a = new Alien();
		
//		
//		a.setAid(101);
//		a.setAname("HetulCh");
//		a.setTech("javaEE");
//		
		try {
			
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5433/neon","axelor","axelor");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from alien where aid ="+aid);
			if(rs.next()) {
				a.setAid(rs.getInt("aid"));
				a.setAname(rs.getString("aname"));
				a.setTech(rs.getString("color"));
				
			}
			
		} catch(Exception e) {
			System.out.println(e);
		}
		return a;
		
		
	}
}
