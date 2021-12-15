package selenium23;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testing {
	static WebDriver driver;
	public void BrowserLaunch(String url) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
	}
	public  WebElement locators (String locatorsType , String valve) {
	if (locatorsType.equals("id")) {
		WebElement findElement = driver.findElement(By.id(valve));
		return findElement;	
	}
	else if(locatorsType.equals("name")) {
		WebElement findElement = driver.findElement(By.name(valve));
		return findElement;	
	}
	else {
		WebElement findElement = driver.findElement(By.xpath(valve));
		return findElement;
	}
	}
	
	public  void enterText(WebElement element , String text) {
		element.sendKeys(text);
	}
	
	public void buttonClick(WebElement element) {
	element.click();
	
}
	public void SelectByVisibleText(WebElement element , String valve) {
		Select s = new Select(element);
		s.selectByVisibleText(valve);
	}
	public void SelectByValve(WebElement element , String valve) {
		Select s = new Select(element);
		s.selectByValue(valve);
		
	}
	public void SelectByIndex(WebElement element , int index) {
		Select s = new Select(element);
		s.selectByIndex(index);
	}
	public void clear(WebElement element) {
		element.clear();
	}
	
	
	public String excelRead(String path , String SheetName , int Rowindex , int Cellindex ) throws IOException {
		File f = new File(path);
	FileInputStream s = new FileInputStream(f);
	Workbook w = new XSSFWorkbook(s);
	Sheet sheet = w.getSheet(SheetName);
	Row row= sheet.getRow(Rowindex);
	Cell cell = row.getCell(Cellindex);
	
	int cellType =cell.getCellType() ;
	
	if (cellType == 1) {
		String stringcellvalve = cell.getStringCellValue();
		return stringcellvalve;
	}
	else if (DateUtil.isCellDateFormatted(cell)) {
		Date datecellvalve = cell.getDateCellValue();
		SimpleDateFormat s1 = new SimpleDateFormat("dd/MM/yyyy");
		String format = s1.format(datecellvalve);
		return format;
	} 
	else {
		double numericcellvalve = cell.getNumericCellValue();
		long l = (long)numericcellvalve;
		String valveof = String.valueOf(l);
	return valveof;	
	}
	}


	public void excelWrite(String path , String sheetName , int rownum , int index, String value) throws IOException {
  File f  = new File(path);
FileOutputStream Stream = new FileOutputStream (f);
Workbook w = new XSSFWorkbook();
Sheet createsheet = w.createSheet(sheetName);
	Row createRow = createsheet.createRow(rownum);
	Cell createcell = createRow.createCell(index);
	createcell.setCellValue(value);
	w.write(Stream);
	Stream.close();
	
	
	
	}
	
	
	
	
	
	
	
	
	
	}	
	
	
	
		
	
	
	



