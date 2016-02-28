package core;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Selenium {

    public static boolean RegExpQuote(String userNameString){  
	Pattern p = Pattern.compile("^[a-zA-Z, .'?!-]{36,103}$");
//	Pattern p = Pattern.compile("[a-zA-Z0-9][-\w]{2,}@([0-9a-zA-Z][-\w]*\.)+[a-zA-Z]{2,6}");   //email  	
        Matcher m = p.matcher(userNameString);  
        return m.matches();  
    }
    public static boolean RegExpPhone(String userNameString){  
	Pattern p = Pattern.compile("^[0-9() -]{10,15}$");   //phone  	
        Matcher m = p.matcher(userNameString);  
        return m.matches();  
    }

	public static void main(String[] args) {


		HtmlUnitDriver driver = new HtmlUnitDriver();	
		driver.setJavascriptEnabled(true);
	
//		WebDriver driver = new FirefoxDriver();
		String text_case_id_01 = "TC-001.01";
		String text_case_id_02 = "TC-001.02";
		String text_case_id_03 = "TC-001.03";
		String text_case_id_04 = "TC-001.04";
		String text_case_id_05 = "TC-001.05";
		String text_case_id_06 = "TC-001.06";
		String text_case_id_07 = "TC-001.07";
		String text_case_id_08 = "TC-001.08";
		String text_case_id_10 = "TC-001.10";
		String text_case_id_13 = "TC-001.13";
		String text_case_id_14 = "TC-001.14";
		String text_case_id_20 = "TC-001.20";
		String text_case_id_27 = "TC-001.27";
		String text_case_id_28 = "TC-001.28";
		String url = "http://learn2test.net/qa/apps/sign_up/v1/";
		String title_sign_up_expected = "Welcome to Sign Up v1";
//		String title_facebook_expected = "Добро пожаловать на Фейсбук - заходите, регистрируйтесь и находите друзей.";
		String fname = "Alex";
		String lname = "Moore";
		String email = "alexmoore@gmail.com";
		String phone = "415 555-1212";

		System.out.println("====================================================");
		// TC-001.01 Checking the Site Title

		driver.get(url);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		String title_sign_up_actual = driver.getTitle();

		if (title_sign_up_expected.equals(title_sign_up_actual)) 
		{
			System.out.println("Test Case ID: \t\t" + text_case_id_01);
			System.out.println("Title Expected/Actual: \t" + title_sign_up_expected + "/" + title_sign_up_actual + "\t- PASSED");
			System.out.println("=================================================================");
		} else	{
			System.out.println("Test Case ID: \t\t" + text_case_id_01);
			System.out.println("Title Expected/Actual: \t" + title_sign_up_expected + "/" + title_sign_up_actual + "\t- FAILED");
			System.out.println("====================================================");
				}

		// TC-001.02 Sign Up page application title is: "Sign Up"
		try
		{		
			driver.findElement(By.id("id_f_title")).getText();
			String quote1 = driver.findElement(By.id("id_f_title")).getText();

			if (quote1 != null && quote1.equals("Sign Up")) 
				{ 	System.out.println("Test Case ID:\t\t" + text_case_id_02);
					System.out.println("Sign Up page application title is:\t" + quote1 + "\t\t\t\t- PASSED");			
//					System.out.println("====================================================");			
				}
			else 	{
					System.out.println("Test Case ID:\t\t" + text_case_id_02);
					System.out.println("Sign Up page application title is:\t" + quote1 + "\t\t\t\t- FAILED");
					}
		} catch (Exception e) 	{
					System.out.println("Test Case ID: \t\t" + text_case_id_02);
					System.out.println("No 'Sign Up' page application with title id_f_title" + "\t\t\t- FAILED");
								}
					System.out.println("====================================================");
			
		// TC-001.03 Page contains dynamic text (quote)
		try
		{
		driver.findElement(By.id("id_quotes")).getText();
		String quote = driver.findElement(By.id("id_quotes")).getText();		
		if (RegExpQuote(quote)) 
			{
			System.out.println("Test Case ID:\t\t" + text_case_id_03);
			System.out.println("Page contains dynamic text\t\t\t\t\t" + "\t- PASSED");
			System.out.println("====================================================");
			} else	{
			System.out.println("Test Case ID: \t\t" + text_case_id_03);
			System.out.println("The page doesn't contain dynamic text\t\t\t\t" + "\t- FAILED");
			System.out.println("====================================================");
					}
		} catch (Exception e) 	{
			System.out.println("Test Case ID: \t\t" + text_case_id_03);
			System.out.println("No id_quotes founded\t\t\t\t\t\t" + "\t- FAILED");
			System.out.println("====================================================");
								}	

		// TC-001.04 Page contains 4 text fields ("First Name", "Last Name", "Email Address", "Phone")

			System.out.println("Test Case ID: \t\t" + text_case_id_04);
			try
			{
		driver.findElement(By.id("id_fname"));
			System.out.println("Page contains first name field\t\t\t\t\t" + "\t- PASSED");
			} catch (Exception e) 
			{System.out.println("Page doesn't contain last name field\t\t\t" + "\t- FAILED");}
			
			try
			{
		driver.findElement(By.id("id_lname"));
			System.out.println("Page contains last name field\t\t\t\t\t" + "\t- PASSED");
			} catch (Exception e) {System.out.println("Page doesn't contain last name field\t\t" + "\t- FAILED");}			
			
			try
			{
		driver.findElement(By.id("id_email"));
			System.out.println("Page contains email field\t\t\t\t\t" + "\t- PASSED");
			} catch (Exception e) 
			{System.out.println("Page doesn't contain email field\t\t\t" + "\t- FAILED");}
		
			try
			{
		driver.findElement(By.id("id_phone"));			
			System.out.println("Page contains phone number field\t\t\t\t" + "\t- PASSED");
			} catch (Exception e) {
			System.out.println("Page doesn't contain phone number field\t\t\t" + "\t- FAILED");}
			System.out.println("====================================================");

			// TC-001.05 Page contains 2 radio buttons (Gender: "Male", "Female")
			
			System.out.println("Test Case ID:\t\t" + text_case_id_05);
			
			try
			{
		driver.findElement(By.id("id_g_radio_01"));
		System.out.println("Page contains Male radio buttons\t\t\t\t" + "\t- PASSED");		
			} catch (Exception e) {System.out.println("Page doesn't contain Male  radio button\t\t\t\t" + "\t- FAILED");}
			
			try
			{
		driver.findElement(By.id("id_g_radio_02"));
		System.out.println("Page contains Female radio buttons\t\t\t\t" + "\t- PASSED");
			} catch (Exception e) {System.out.println("Page doesn't contain last name field\t\t\t\t" + "\t- FAILED");}
			
			System.out.println("====================================================");
			
			
		// TC-001.06 Page contains drop-down list ("State") 

			System.out.println("Test Case ID: \t\t" + text_case_id_06);
		
		try
		{
	driver.findElement(By.id("id_state"));
		System.out.println("Page contains drop-down list State\t\t\t\t" + "\t- PASSED");		
		} catch (Exception e) {System.out.println("Page doesn't contains drop-down list State\t\t\t\t" + "\t- FAILED");}
		System.out.println("====================================================");

		// TC-001.07 Page contains checkbox (Agreement on Terms)

		System.out.println("Test Case ID: \t\t" + text_case_id_07);
	
		try
		{
	driver.findElement(By.id("id_checkbox"));
		System.out.println("Page contains checkbox (Agreement on Terms)\t\t\t" + "\t- PASSED");		
		} catch (Exception e) 
		{System.out.println("Page doesn't contain drop-down list State\t\t\t\t" + "\t- FAILED");}
	System.out.println("====================================================");
	
	
		// TC-001.08 Page contains 4 image links (Facebook, Twitter, Flickr, YouTube)
	System.out.println("Test Case ID: \t\t" + text_case_id_08);
	try
			{		
		driver.findElement(By.id("id_img_facebook")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		ArrayList<String> allTabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(allTabs.get(1));
		driver.close();
		driver.switchTo().window(allTabs.get(0));

		System.out.println("Image links Facebook found\t\t\t\t\t\t- PASSED");
			}
	catch (Exception e) 	{
		System.out.println("Image links Facebook didn't find\t\t\t\t\t- FAILED");
							}		
	try
		{		
		driver.findElement(By.id("id_img_twitter")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		ArrayList<String> allTabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(allTabs.get(1));
		driver.close();
		driver.switchTo().window(allTabs.get(0));
		System.out.println("Image links twitter found\t\t\t\t\t\t- PASSED");
		} catch (Exception e) 	
			{
		System.out.println("Image links twitter didn't find\t\t\t\t\t\t- FAILED");
			}
		
	try
	{		
		driver.findElement(By.id("id_img_flickr")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		ArrayList<String> allTabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(allTabs.get(1));
		driver.close();
		driver.switchTo().window(allTabs.get(0));
		System.out.println("Image links flickr found\t\t\t\t\t\t- PASSED");
	} catch (Exception e) 	
		{
		System.out.println("Image links flickr didn't find\t\t\t\t\t\t- FAILED");
		}
	
	try
	{		
		driver.findElement(By.id("id_img_youtube")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		ArrayList<String> allTabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(allTabs.get(1));
		driver.close();
		driver.switchTo().window(allTabs.get(0));
		System.out.println("Image links youtube found\t\t\t\t\t\t- PASSED");
	} catch (Exception e) 	
		{
		System.out.println("Image links youtube didn't find\t\t\t\t\t\t- FAILED");
		}	
		System.out.println("====================================================");	

		// TC-001.10 Page contains dynamic text (today’s day) (Format - Month Day, Year: [February 21, 2015]) with regex
		
		try
		{	
		driver.findElement(By.id("timestamp")).getText();
		String quote5 = driver.findElement(By.id("timestamp")).getText();
		System.out.println("Test Case ID: \t\t" + text_case_id_10);
		System.out.println("Page contains dynamic text (today’s day). Quote length: " + quote5.length() + "\t\t- PASSED");		


		} catch (Exception e) 	{
		System.out.println("Test Case ID: \t\t" + text_case_id_10);			
		System.out.println("Test Case ID: \t\t" + "Page not contains dynamic text (today’s day)\t- FAILED");
								}	
		System.out.println("====================================================");
		// TC-001.13 
	try
		{			
		driver.findElement(By.id("id_current_location")).getText();
		driver.findElement(By.id("id_temperature")).getText();
		String quote6 = driver.findElement(By.id("id_current_location")).getText();
		String quote7 = driver.findElement(By.id("id_temperature")).getText();
		System.out.println("Test Case ID: \t\t" + text_case_id_13);
		System.out.println("Page contains dynamic icon (Client’s current weather)" + "\t\t\t- PASSED");
		System.out.println("The weather in " + quote6 + " is " + quote7);
		} 
	catch (Exception e) 	{
		System.out.println("Test Case ID: \t\t" + text_case_id_13);
		System.out.println("Page doesn't contain dynamic icon (Client’s current weather)" + "\t\t- FAILED");
								}					
		System.out.println("====================================================");
			
			
			// TC-001.14	Page contains dynamic icon (Client’s current weather)	xpath	
			try
			{
				driver.findElement(By.xpath("html/body/form/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[1]/td[5]/table/tbody/tr[2]/td[1]/img"));
		System.out.println("Test Case ID: \t\t" + text_case_id_14);
		System.out.println("Page contains dynamic icon (Client’s current weather)" + "\t\t\t- PASSED");		
			} catch (Exception e) 	{
		System.out.println("Test Case ID: \t\t" + text_case_id_14);
		System.out.println("Page doesn't contain dynamic icon (Client’s current weather)" + "\t\t- FAILED");
									}
			System.out.println("====================================================");

			
		// TC-001.20	"Phone" - required fields and accepts numeric (10 digits)including: spaces, open/close parenthesis, hyphens			
			try
			{				
				driver.findElement(By.id("id_fname")).sendKeys(fname);
				driver.findElement(By.id("id_lname")).sendKeys(lname);
				driver.findElement(By.id("id_email")).sendKeys(email);
				driver.findElement(By.id("id_phone")).sendKeys(phone);
				driver.findElement(By.id("id_submit_button")).click();

				String quote25 = driver.findElement(By.id("ErrorLine")).getText();
				
				if (quote25.equals("Invalid Phone Number: should be 10 digits"))					
				{
				System.out.println("Test Case ID: \t\t" + text_case_id_20);
				System.out.println("Page contains id_phone with wrong format" + "\t\t\t\t- FAILED");
				System.out.println("====================================================");
				}
			} catch (Exception e) 	{
					System.out.println("Test Case ID: \t\t" + text_case_id_20);
					System.out.println("Page contains id_phone with right format" + "\t\t\t\t- PASSED");
					System.out.println("====================================================");
					driver.findElement(By.id("id_back_button")).click();
									}

			
		// TC-001.27	"Reset" button resets all fields and buttons (reloading the page resets as well)		
		try
		{		
		driver.findElement(By.id("id_fname")).sendKeys(fname);
		driver.findElement(By.id("id_lname")).sendKeys(lname);
		driver.findElement(By.id("id_email")).sendKeys(email);
		driver.findElement(By.id("id_phone")).sendKeys(phone);
		driver.findElement(By.id("id_checkbox")).click();
		driver.findElement(By.id("id_g_radio_01")).click();
		driver.findElement(By.id("id_state")).sendKeys("Alaska");
		driver.findElement(By.id("id_reset_button")).click();
		driver.findElement(By.id("id_submit_button")).click();
		
		String quote9 = driver.findElement(By.id("ErrorLine")).getText();
		if (quote9 != null) 
		{System.out.println("Test Case ID: \t\t" + text_case_id_27);
		System.out.println("Reset button resets all fields and buttons and reloading the page resets" + " - PASSED");
		}
		else 
		{System.out.println("Test Case ID: \t\t" + text_case_id_27);
		System.out.println("Reset button doesn't work" + "\t\t\t\t- FAILED");}
		} catch (Exception e) 	{
		System.out.println("Test Case ID: \t\t" + text_case_id_27);
		System.out.println("Page doesn't contains all field or error line" + "\t\t\t\t- FAILED");			
								}
		System.out.println("====================================================");
			
		// TC-001.28	"Submit" button redirects to Conformation page (both titles [html/application]: "Conformation")
	try
	{		
		driver.findElement(By.id("id_lname")).sendKeys(lname);		
		driver.findElement(By.id("id_fname")).sendKeys(fname);
		driver.findElement(By.id("id_phone")).sendKeys(phone);		
		driver.findElement(By.id("id_email")).sendKeys(email);
		driver.findElement(By.id("id_submit_button")).click();		
		String quote15 = driver.findElement(By.id("id_f_title")).getText();


		if (quote15.equals("Confirmation"))	{
			System.out.println("Test Case ID: \t\t" + text_case_id_28);
			System.out.println("Submit button redirects to Conformation page" + "\t\t\t\t- PASSED");
			System.out.println("====================================================");
											}
		if (quote15.equals("Sign Up"))	{
			System.out.println("Test Case ID: \t\t" + text_case_id_28);
			System.out.println("Submit button didn't redirect to Conformation page" + "\t\t\t- FAILED");
			System.out.println("====================================================");
										}
	} catch (Exception e) {
							System.out.println("Test Case ID: \t\t" + text_case_id_28);
							System.out.println("Page doesn't contain all the fields" + "\t\t\t\t\t- FAILED");}
		
		
		driver.quit();		
		
	}
}