package dataDriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	
	public String ExcelRead(int row, int col, String workbook, String sheetname) throws IOException {
		File readexcel1 = new File(workbook);
		FileInputStream input_stream = new FileInputStream(readexcel1);
		XSSFWorkbook work_book = new XSSFWorkbook(input_stream);
		String strval = work_book.getSheet(sheetname).getRow(row).getCell(col).getStringCellValue();
		return strval;
	}


	
}
