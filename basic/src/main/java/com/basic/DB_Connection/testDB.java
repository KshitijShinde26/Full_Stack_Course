package com.basic.DB_Connection;

public class testDB {
	public static void main(String[] args) {
        try {
			dbConnection.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
