package com.tieto.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.swing.Box.Filler;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//john - pass1234
//peter - peter123
//paul, paul123

public class DemoTest {

public void readProperties() throws IOException
{
	FileInputStream file = new FileInputStream("testdata/data.properties"); // reading the file
	
	Properties prop = new Properties();
	prop.load(file);
	
	String baseUrl = prop.getProperty("url");
	System.out.println(baseUrl);
}

	/*
	 * @DataProvider public Object[][] fillFormData() { Object[][] main = new
	 * Object[3][2];
	 * 
	 * // i- no of testcases //j- number of parameter
	 * 
	 * 
	 * main [0][0] = "john"; main [0][1] = "john123";
	 * 
	 * main [1][0] = "peter"; main [1][1] = "peter123";
	 * 
	 * main [2][0] = "paul"; main [2][1] = "paul123";
	 * 
	 * return main;
	 * 
	 * }
	 * 
	 * @Test(dataProvider = "fillFormData") public void fillFormTest(String
	 * username, String password) { System.out.println(username+password); }
	 * 
	 * 
	 * 
	 * 
	 * @DataProvider public Object[][] invalidData() { Object[][] main = new
	 * Object[2][4];
	 * 
	 * // i- no of testcases //j- number of parameter
	 * 
	 * 
	 * main [0][0] = "john"; main [0][1] = "john123"; main [0][2] =
	 * "French (Standard)"; main [0][3] = "Invalid username or password";
	 * 
	 * main [1][0] = "peter"; main [1][1] = "peter123"; main [1][2] =
	 * "French (Standard)"; main [1][3] = "Invalid username or password";
	 * 
	 * return main;
	 * 
	 * }
	 * 
	 * 
	 * @Test(dataProvider = "invalidData") public void invalidTest(String username,
	 * String password, String language, String expectedValue) {
	 * System.out.println(username+password+language+expectedValue);
	 * 
	 * }
	 */
}
