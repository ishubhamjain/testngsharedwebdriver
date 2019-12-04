package automationframework;

/**
 * @author Shubham Jain
 *
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelLib {

	String xlpath = Configuration.getExcelFile();
	public String getXLcellValue(String sheetName, int rowNum, int cellNum)
	{
		try{
			FileInputStream fis=new FileInputStream(xlpath);
			Workbook wb=WorkbookFactory.create(fis);
			
			return wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
			
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		return "";
	}
	
	//get xl row count
	
	public int getXLRowCount(String sheetName)
	{
		try{
			FileInputStream fis=new FileInputStream(xlpath);
			
			Workbook wb=WorkbookFactory.create(fis);
			
			return wb.getSheet(sheetName).getLastRowNum();
		}
		catch(Exception ex)
		{
			
		}
		return -1;
	}
}