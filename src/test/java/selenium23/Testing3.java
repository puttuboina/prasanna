package selenium23;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.openqa.selenium.WebElement;

public class Testing3 extends Testing {
	public static void main(String[] args) throws IOException, InterruptedException {
		
		Testing3 t3 = new Testing3();
     t3.BrowserLaunch("https://adactinhotelapp.com/");
		WebElement textusername = t3.locators("id", "username");
		String username = t3.excelRead("C:\\Java\\Book1.xlsx", "abcde", 2, 0);
		t3.enterText(textusername, username);
		
		WebElement textpassword = t3.locators("id", "password");
		String password = t3.excelRead("C:\\Java\\Book1.xlsx", "abcde", 2, 1);
		t3.enterText(textpassword,password);
		
		WebElement btnlogin = t3.locators("name", "login");
		t3.buttonClick(btnlogin);
		
		WebElement location = t3.locators("id", "location");
		String index = t3.excelRead("C:\\Java\\Book1.xlsx", "abcde", 2, 2);
	    t3.enterText(location, index);
	    int parseint = Integer.parseInt(index);
	    
	    t3.SelectByIndex(location,parseint );
	    WebElement hotels = t3.locators("name", "hotels");
	    String valve = t3.excelRead("C:\\Java\\Book1.xlsx", "abcde", 2, 3);
	    t3.enterText(hotels, valve);
	    
	    WebElement room = t3.locators("id", "room_type");
	    String type = t3.excelRead("C:\\Java\\Book1.xlsx", "abcde", 2, 4);
	      t3.enterText(room, type);
	      
     WebElement rooms = t3.locators("name", "room_nos");
     String nos = t3.excelRead("C:\\Java\\Book1.xlsx", "abcde", 2, 5);
     t3.enterText(rooms, nos);
	      
   
	WebElement date = t3.locators("name", "datepick_in");
	t3.clear(date);
   String date1 = t3.excelRead("C:\\Java\\Book1.xlsx", "abcde", 2, 6);
	  t3.enterText(date, date1);
	  
	WebElement date2 = t3.locators("name", "datepick_out");
	t3.clear(date2);
	String dateout = t3.excelRead("C:\\Java\\Book1.xlsx", "abcde", 2, 7);
	t3.enterText(date2, dateout);
	
	WebElement select = t3.locators("id", "adult_room");
	String select1 = t3.excelRead("C:\\Java\\Book1.xlsx", "abcde", 2, 8);
	t3.enterText(select, select1);
	
	Thread.sleep(5000);
	WebElement submit= t3.locators("id", "Submit");
	t3.buttonClick(submit);
	
	Thread.sleep(4000);
	WebElement radio = t3.locators("id", "radiobutton_0");
	t3.buttonClick(radio);

	WebElement submit1 = t3.locators("name", "continue");
	t3.buttonClick(submit1);
	
	WebElement first = t3.locators("name", "first_name");
	String textname = t3.excelRead("C:\\Java\\Book1.xlsx", "abcde", 2, 9);
	t3.enterText(first, textname);
	
	WebElement second = t3.locators("name", "last_name");
	String textsur = t3.excelRead("C:\\Java\\Book1.xlsx", "abcde", 2, 10);
	t3.enterText(second, textsur);
	
	WebElement address = t3.locators("name", "address");
	String textaddress = t3.excelRead("C:\\Java\\Book1.xlsx", "abcde", 2, 11);
	t3.enterText(address, textaddress);
	
	WebElement cc = t3.locators("name", "cc_num");
	String cc3 = t3.excelRead("C:\\Java\\Book1.xlsx", "abcde", 2, 12);
	t3.enterText(cc, cc3);
	
	WebElement card = t3.locators("id", "cc_type");
	String card2 = t3.excelRead("C:\\Java\\Book1.xlsx", "abcde", 2, 13);
	t3.enterText(card, card2);
	
	WebElement date4 = t3.locators("id", "cc_exp_month");
	String textdate4 = t3.excelRead("C:\\Java\\Book1.xlsx", "abcde", 2, 14);
	t3.enterText(date4, textdate4);
	
	WebElement w3 = t3.locators("id", "cc_exp_year");
	String textw3 = t3.excelRead("C:\\Java\\Book1.xlsx", "abcde", 2, 15);
	t3.enterText(w3,textw3 );
	
	WebElement ww3 = t3.locators("id", "cc_cvv");
	String textww3 = t3.excelRead("C:\\Java\\Book1.xlsx", "abcde", 2, 16);
	t3.enterText(ww3,textww3 );
	
	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	WebElement book = t3.locators("id", "book_now");
	t3.buttonClick(book);
	Thread.sleep(5000);
	
//    WebElement	orderno = t3.locators("id", "order_no");
//    Thread.sleep(15000);
//    t3.ExcelWrite("D:\\excelwriteoutput.xlsx","ABCD" , 0,0);
//    String attribute = orderno.getAttribute("value");
//    System.out.println(attribute);
//    
	
	WebElement orderNo = t3.locators("id", "order_no");
	String attribute = orderNo.getAttribute("value");
	System.out.println(attribute);
		try {
		t3.excelWrite("D:\\excelwriteoutput.xlsx","ABCD", 0,0, attribute);
	} catch (InvalidFormatException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	
	}
	}
}

