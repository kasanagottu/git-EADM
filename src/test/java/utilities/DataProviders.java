package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException
	
	{
		
		String path=".\\testData\\LoginData.xlsx";		//taking the data from xl 
		
		Excelutility xlutl=new Excelutility(path);		//creating the object for Excelutility class
			
		int totalrows=xlutl.getRowCount("Sheet1");
		int totalcols=xlutl.getCellCount("Sheet1",1);
		
		System.out.println("The no of rows are:"+totalrows);
		System.out.println("The no of colum are:"+totalcols);
		
		String logindata[][]=new String[totalrows][totalcols];  //creating 2 dimension array which can store rows & col count
		
		for (int i=1;i<=totalrows;i++)		//1 read the data from excel storing in 2 2 dimension 
		
		{
			for (int j=0;j<totalcols;j++)		//0 i the row and J is Column
			{
				logindata[i-1][j]=xlutl.getCellData("Sheet1", i, j); //1,0
			}
		}
			
		return logindata; //returning 2 dimension array
		
	}
	
	@DataProvider(name="ClassificationData")
	public String [][] getClassificationData() throws IOException
	
	{
		
		String path=".\\testData\\Classification_BP.xlsx";		//taking the data from xl
				
		Excelutility xlutl=new Excelutility(path);		//creating the object for Excelutility class
			
		int totalrows=xlutl.getRowCount("Sheet1");
		int totalcols=xlutl.getCellCount("Sheet1",1);
		
		System.out.println("The no of rows are:"+totalrows);
		System.out.println("The no of columns are:"+totalcols);
		
		String ClassificationData[][]=new String[totalrows][totalcols];  //creating 2 dimension array which can store rows & col count
		
		for (int i=1;i<=totalrows;i++) 	 //1 read the data from excel storing in 2 2 dimension 
		{
			for (int j=0;j<totalcols;j++)		//0 i the row and J is Column
			{
				ClassificationData[i-1][j]=xlutl.getCellData("Sheet1", i, j); //1,0
			}
		}
			
		return ClassificationData; //returning 2 dimension array
		
	}
	@DataProvider(name="ClassificationSchemeData")
	public String [][] getClassificationSchemeData() throws IOException
	
	{
		String path=".\\testData\\Classification_Scheme.xlsx";		//taking the data from xl
	
		Excelutility xlutl=new Excelutility(path);		//creating the object for Excelutility class
			
		int totalrows=xlutl.getRowCount("Sheet1");
		int totalcols=xlutl.getCellCount("Sheet1",1);
		
		System.out.println("The no of rows are:"+totalrows);
		System.out.println("The no of columns are:"+totalcols);
		
		String ClassificationData[][]=new String[totalrows][totalcols];  //creating 2 dimension array which can store rows & col count
		
		for (int i=1;i<=totalrows;i++)		//1 read the data from excel storing in 2 2 dimension 
		{
			for (int j=0;j<totalcols;j++)		//0 i the row and J is Column
			{
				ClassificationData[i-1][j]=xlutl.getCellData("Sheet1", i, j); //1,0
			}
		}
			
		return ClassificationData; //returning 2 dimension array
		
	}
	@DataProvider(name="ClassificationServiceChainData")
	public String [][] getClassificationServiceChainData() throws IOException
	
	{
		String path=".\\testData\\Classification_SC.xlsx";		//taking the data from xl
	
		Excelutility xlutl=new Excelutility(path);			//creating the object for Excelutility class
			
		int totalrows=xlutl.getRowCount("Sheet1");
		int totalcols=xlutl.getCellCount("Sheet1",1);
		
		System.out.println("The no of rows are:"+totalrows);
		System.out.println("The no of columns are:"+totalcols);
		
		String ClassificationData[][]=new String[totalrows][totalcols];  //creating 2 dimension array which can store rows & col count
		
		for (int i=1;i<=totalrows;i++)		//1 read the data from excel storing in 2 2 dimension 
		{
			for (int j=0;j<totalcols;j++)		//0 i the row and J is Column
			{
				ClassificationData[i-1][j]=xlutl.getCellData("Sheet1", i, j); //1,0
			}
		}
			
		return ClassificationData; //returning 2 dimension array
		
	}
	
	@DataProvider(name="ClassificationFacilityData")
	public String [][] getClassificationFacilityData() throws IOException
	
	{
		String path=".\\testData\\Classification_Facility.xlsx";	
		//String path=".\\testData\\Facility.xlsx";	
	
		Excelutility xlutl=new Excelutility(path);			
			
		int totalrows=xlutl.getRowCount("Sheet1");
		int totalcols=xlutl.getCellCount("Sheet1",1);
		
		System.out.println("The no of rows are:"+totalrows);
		System.out.println("The no of columns are:"+totalcols);
		
		String ClassificationData[][]=new String[totalrows][totalcols]; 
		
		for (int i=1;i<=totalrows;i++)		
		{
			for (int j=0;j<totalcols;j++)		
			{
				ClassificationData[i-1][j]=xlutl.getCellData("Sheet1", i, j); //1,0
			}
		}
			
		return ClassificationData; 
		
	}

}
