package com.ssafy.project.persistence;

import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.jupiter.api.Test;

public class JDBCTests {
    static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testConnection() {
		
		try(Connection con = 
				DriverManager.getConnection(
						"jdbc:mysql://i6e102.p.ssafy.io:3306/ssafy?serverTimezone=Asia/Seoul",
						"team02",
						"ssafycampus")){
			System.out.println(con);
            System.out.println("성공");
		} catch (Exception e) {
			fail(e.getMessage());
		}
		
	}
}
