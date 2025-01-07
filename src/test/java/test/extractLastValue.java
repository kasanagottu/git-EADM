package test;

import java.io.IOException;

import utilities.Excelutility;

public class extractLastValue {

	public static void main(String[] args) throws IOException {
		
		String path="C:\\Users\\VENKATESHAMKASANAGOT\\Documents\\Local Files\\Service Chain.xlsx";
		
		Excelutility xlutl=new Excelutility(path);	
		int totalrows=xlutl.getRowCount("Service Chain");
		int totalcols=xlutl.getCellCount("Service Chain",1);
		
		System.out.println("The no of rows are:"+totalrows);
		System.out.println("The no of colum are:"+totalcols);
		
		for(int i=1;i<totalrows;i++)
		{
		String CellValue=xlutl.getCellData("Service Chain", i, 0);
		
		String lastItem = CellValue.substring(CellValue.lastIndexOf('\\') + 1);
		
		System.out.println(lastItem.trim());
		
		//xlutl.setCellData("Service Chain", i, 0,lastItem);
		
		}
	//	String string= "Business_Product/Supply";
		//String val="Business_Product/Supply/Non-Potable/Water";
		
	/*	String [] val=CellValue.split("/");
		
		String lastOne = val[val.length-1];
		
		System.out.println("Split Array : "+ lastOne);
		
		//System.out.println(val1[val1.length-1]); */
		
			}

}
