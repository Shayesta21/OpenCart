package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public CellStyle style;
    String path;
    
    public ExcelUtility(String path) {
    	this.path=path;
    }
    
    public int getRowCount(String sheetname) throws IOException {
    	
    	fi= new FileInputStream(path);
    	workbook=new XSSFWorkbook(fi);
    	sheet= workbook.getSheet(sheetname);
    	int rowcount=sheet.getLastRowNum();
    	workbook.close();
    	fi.close();    	    	    	   	
    	return rowcount;
    }
    
    
    public int getCellCount(String sheetname, int rownum) throws IOException {
    	
    	fi=new FileInputStream(path);
    	workbook= new XSSFWorkbook(fi); 
    	sheet =workbook.getSheet(sheetname);
    	row=sheet.getRow(rownum);
    	int cellcount = row.getLastCellNum();
    	workbook.close();
    	fi.close();
    	return cellcount;
    }
    
    public String getCellData(String sheetname, int rownum, int colnum) throws IOException {
    	fi = new FileInputStream(path);
    	workbook= new XSSFWorkbook(fi);
    	sheet=workbook.getSheet(sheetname);
    	row=sheet.getRow(rownum);
    	cell=row.getCell(colnum);
    	
    	DataFormatter formatter = new DataFormatter();
    	String data;
    	try {
    		data=formatter.formatCellValue(cell); //returns the formatted value of a cell as a string regardless of the data type
    		
    	}
    	catch(Exception e) {
    		data=" ";
    	}
    	
    	workbook.close();
    	fi.close();
    	return data;
    	    	
    }
    
    public void setCellData(String sheetname, int rownum, int colnum, String data) throws IOException {
    	
    	File xlfile= new File(path);
    	//if File does not exist
    	
    	if(!xlfile.exists()) {
    		workbook= new XSSFWorkbook();
    		fo= new FileOutputStream(path);
    		workbook.write(fo);    		   		
    	}
    	
    	fi = new FileInputStream(path);
    	workbook = new XSSFWorkbook(fi);
    	
    	if(workbook.getSheetIndex(sheetname)==-1) //if sheet does not exist create a new sheet
        	workbook.createSheet(sheetname);
    	sheet=workbook.getSheet(sheetname);
    	
    	if(sheet.getRow(rownum)==null)   // if row does not exist
    	 sheet.createRow(rownum);
    	 row=sheet.getRow(rownum);
    	
    	cell=row.createCell(colnum);
    	cell.setCellValue(data);
    	fo = new FileOutputStream(path);
    	workbook.write(fo);
    	fi.close();
    	fo.close();
    	    	    	
    }
    
    public void fillGreenColor(String sheetname, int rownum, int colnum) throws IOException {
    	
    	fi = new FileInputStream(path);
    	workbook=new XSSFWorkbook(fi);
    	sheet= workbook.getSheet(sheetname);
    	row=sheet.getRow(rownum);
    	cell=row.getCell(colnum);
    	
    	style=workbook.createCellStyle();
    	
    	style.setFillForegroundColor(IndexedColors.BRIGHT_GREEN.getIndex());
    	style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
    	cell.setCellStyle(style);
    	workbook.close();
    	fi.close();
    	fo.close();
    	  	   	
    }
    
    
    public void fillRedColor(String sheetname, int rownum, int colnum) throws IOException {
    	
    	fi = new FileInputStream(path);
    	workbook= new XSSFWorkbook(fi);
    	sheet=workbook.getSheet(sheetname);
    	row=sheet.getRow(rownum);
    	cell= row.getCell(colnum);
    	
    	style= workbook.createCellStyle();
    	
    	style.setFillForegroundColor(IndexedColors.RED.getIndex());
    	style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
    	cell.setCellStyle(style);
    	
    	workbook.close();
    	fi.close();
    	fo.close();
    	
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
