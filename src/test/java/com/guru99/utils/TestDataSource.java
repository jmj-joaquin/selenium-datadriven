package com.guru99.utils;

import org.testng.annotations.DataProvider;

import commonLibs.utils.DatabaseUtils;

public class TestDataSource {

	@DataProvider
	public Object[][] getData(){
		
		Object[][] data = new Object[3][2];
		
		data[0][1] = "mngr484236";
		data[0][2] = "Enemepa";
		
		data[1][1] = "mngr484236";
		data[1][2] = "Enemepa";
		
		data[2][1] = "mngr484236";
		data[2][2] = "Enemepa";
		
		return data;
		
	}
	
	@DataProvider
	public Object[][] getDataFromDatabase() throws Exception{
		Object[][] data;
		
		DatabaseUtils databaseUtils = new DatabaseUtils();
		
		String server = "localhost";
		int portNumber = 3307;
		String database = "Guru99TestData";
		String username = "jmjoaquin";
		String password = "Pew#pew%3397";
		
		databaseUtils.openConnection(server, portNumber, database, username, password);
		
		String sqlQuery = "select * from users";
		
		data = databaseUtils.executeSqlSelectQuery(sqlQuery);
		
		databaseUtils.closeConnection();
		return data;
	}
	
}
