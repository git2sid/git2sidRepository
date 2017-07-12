package org.heritage.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
//import org.heritage.dao.StudentDAO;
import org.heritage.model.DataModel;
import org.heritage.services.StudentServices;
import org.heritage.view.ExcelClassUserListView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class DataController {

	@Autowired
	private StudentServices studentServices;
	List<DataModel> listModel=new ArrayList<DataModel>();
	@RequestMapping("/")
public ModelAndView showHello()
{	
		List<DataModel> list=new ArrayList<DataModel>();
list.add(new DataModel("siddharth","22","muradnagar","21"));
list.add(new DataModel("nishant","12","muradnagar","32"));
list.add(new DataModel("rudra","12","muradnagar","8"));
list.add(new DataModel("himanshu","12","muradnagar","26"));
list.add(new DataModel("else","12","muradnagar","50"));
		this.listModel=list;	
		return new ModelAndView("hello","userList",list);
}
	@RequestMapping("/report")
	public ModelAndView showReport()
	{
	
		
		return new ModelAndView(new ExcelClassUserListView(),"userList",listModel);
	}
	@RequestMapping("/querydb")
	public ModelAndView showDataFromDB()
	{
	//StudentDAO studentDao=new StudentDAO();
		List<DataModel> list=studentServices.getData();
		System.out.println(list);
		//List<DataModel> list=studentDAO.getDataModel();
	//	System.out.println("name is "+list.get(0).username);
		return  new ModelAndView("databasePage","list",list);
	}
	@RequestMapping("/readexcel")
	public ModelAndView readexcel()
	{
		try 
		{ 
		FileInputStream file = new FileInputStream(new File("/home/siddharth/Downloads/report.xls")); 

		//Create Workbook instance holding reference to .xlsx file 
		HSSFWorkbook workbook = new HSSFWorkbook(file); 

		//Get first/desired sheet from the workbook 
		HSSFSheet sheet = workbook.getSheetAt(0); 

		//Iterate through each rows one by one 
		Iterator<Row> rowIterator = sheet.iterator(); 
		while (rowIterator.hasNext()) 
		{ 
		Row row = rowIterator.next(); 
		System.out.println("the zeroth cell elements are "+row.getCell(1));
		//For each row, iterate through all the columns 
		Iterator<Cell> cellIterator = row.cellIterator(); 

		while (cellIterator.hasNext()) 
		{ 
		Cell cell = cellIterator.next(); 
		//Check the cell type and format accordingly 
		switch (cell.getCellType()) 
		{ 
		case Cell.CELL_TYPE_NUMERIC: 
		System.out.print(cell.getNumericCellValue() + "--"); 
		break; 
		case Cell.CELL_TYPE_STRING: 
		System.out.print(cell.getStringCellValue() + "--"); 
		break; 
		} 
		} 
		System.out.println(""); 
		} 
		file.close(); 
		} 
		catch (Exception e) 
		{ 
		e.printStackTrace(); 
		} 
		int id=10;
		return new ModelAndView("chart","modelChart",id);
	}
	@RequestMapping("/getdatausingjquery")
	public String showGetdatausingjquery()
	{
		return "getdatausingjquery";
	}
}
