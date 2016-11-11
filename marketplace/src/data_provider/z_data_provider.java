package data_provider;


import java.io.BufferedReader;

import java.io.FileInputStream;

import java.io.IOException;
import java.io.InputStreamReader;

import org.testng.annotations.DataProvider;

public class z_data_provider
{
	
//	DataProvider for add product
	
	public static int rownum = 0;
	public static String tmp;
	@DataProvider(name= "add_product") 
	public static String[][] addproduct() throws IOException
	{	
		String filepath = "/home/users/himanshu.chand/Documents/marketplace/addproduct.csv";
		get_rownum(filepath);
		String[][] value= new String[rownum-1][1];
	  	get_data_values(filepath, value, rownum);
		return value;
	}
	
	@DataProvider(name= "add_seller") 
	public static String[][] addseller() throws IOException
	{	
		String filepath = "/home/users/himanshu.chand/Documents/marketplace/addseller.csv";
		get_rownum(filepath);
		String[][] value= new String[rownum-1][1];
	  	get_data_values(filepath, value, rownum);
		return value;
	}
	@DataProvider(name= "join_seller") 
	public static String[][] joinseller() throws IOException
	{	
		String filepath = "/home/users/himanshu.chand/Documents/marketplace/joinseller.csv";
		get_rownum(filepath);
		String[][] value= new String[rownum-1][1];
	  	get_data_values(filepath, value, rownum);
		return value;
	}
//	add_product_via_seller
	@DataProvider(name= "add_product_via_seller") 
	public static String[][] addproduct_via_seller() throws IOException
	{	
		String filepath = "/home/users/himanshu.chand/Documents/marketplace/add_product_via_seller.csv";
		get_rownum(filepath);
		String[][] value= new String[rownum-1][1];
	  	get_data_values(filepath, value, rownum);
		return value;
	}
	
	
	public static  int get_rownum(String filepath) throws IOException {
		FileInputStream in = new FileInputStream(filepath);
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		int numrow=0;
		while ((tmp = br.readLine()) != null)
		  {
			  numrow++;
		  }
		rownum=numrow;
		return rownum;
		
	}
	private static String[][] get_data_values(String filepath, String[][] data, int rownum) throws IOException {
		FileInputStream in1 = new FileInputStream(filepath);
		@SuppressWarnings("resource")
		BufferedReader br1 = new BufferedReader(new InputStreamReader(in1));
		int j=rownum;
		for(int m=0; m<j;m++)
		{
		 tmp = br1.readLine();
			 if(m!=0)
			 {
				 data[m-1][0]=tmp;
			 }
		}
		
		return data;
	}
}
