package com.ssafy.project.persistence;

import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.jupiter.api.Test;

public class JDBCTests {
    static {
		try {
			Class.forName("org.mariadb.cj.jdbc.Driver");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testConnection() {
		
		try(Connection con = 
				DriverManager.getConnection(
						"jdbc:mariadb://localhost:3306/ssafy?serverTimezone=Asia/Seoul",
						"root",
						"root")){
			System.out.println(con);
            System.out.println("성공");
		} catch (Exception e) {
			fail(e.getMessage());
		}
		
	}
}
