package seleniumRewind;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutomationExercise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Launch browser

		System.setProperty("webdriver.chrome.driver", "D:\\selenium\\chrome\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		//2. Navigate to url
		driver.get("https://automationexercise.com/");
		
		//3. Verify that home page is visible successfully
		
		
		String expectedTitle ="Automation Exercise";
		String actualTitle = driver.getTitle();
		
		if(actualTitle.equals(expectedTitle)) {
			System.out.println("Home page is visible, Title name is: " + actualTitle);
		}
		else {
			System.out.println("Home page is not visible");
		}
		
		
		//chatGPT
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		try {
		    // Wait for the URL to match the expected home page URL
		    wait.until(ExpectedConditions.urlToBe("https://automationexercise.com/")); // Replace with actual home page URL
		    System.out.println("Home page is visible.");
		} catch (Exception e) {
		    System.out.println("Home page is NOT visible.");
		    e.printStackTrace();
		}

		
		
		
		
		//4.  Click on 'Signup / Login' button
		WebElement signup_LoginBtn = driver.findElement(By.xpath("//ul//li[4]"));
		signup_LoginBtn.click();
			
			//5.  Verify New user signup is available
		
		String newuserTitle = "New User Signup!";
		String actualNewUserTitle = driver.getTitle();
		
		if(actualNewUserTitle.equals(newuserTitle)) {
			System.out.println("New user signup is available");
		}else {
			System.out.println("New user signup is not available");
		}
		
		
		//chatGPT
		try {
		    // Wait for a specific text to appear on the page
		    WebElement signup = wait.until(ExpectedConditions.visibilityOfElementLocated(
		            By.xpath("//button[contains(text(),'Signup')]") // Replace with actual text
		    ));
		    System.out.println("SignUp is visible.");
		} catch (Exception e) {
		    System.out.println("SignUp is NOT visible.");
		    e.printStackTrace();
		}
		
		
		
		//6. Enter name and email address
		
		
		WebElement name = driver.findElement(By.xpath("//input[@name='name']"));
			name.sendKeys("Gopal");
			
			WebElement email = driver.findElement(By.xpath("//input[@data-qa='signup-email' and @name='email']"));
			email.sendKeys("goapal@test.com");
			
			WebElement signUpClick = driver.findElement(By.xpath("//button[contains(text(),'Signup')]"));
			signUpClick.click();
			
		
		// 7. Verify that 'ENTER ACCOUNT INFORMATION' is visible
			
		//	WebElement EAI = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Enter Account Information')]")));
			
			
			try {
	            // Locate the element that contains the text "ENTER ACCOUNT INFORMATION"
				WebElement EAI = wait.until(
	                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Enter Account Information')]"))
	            );

	            // Check if the page containing the text is visible
	            if (EAI.isDisplayed()) {
	                System.out.println("The 'ENTER ACCOUNT INFORMATION' page is visible.");
	            } else {
	                System.out.println("The 'ENTER ACCOUNT INFORMATION' page is NOT visible.");
	            }
	        } catch (Exception e) {
	            System.out.println("The 'ENTER ACCOUNT INFORMATION' page is not found or visible.");
	        }
		
		
		//9.	Fill details: Title, Name, Email, Password, Date of birth
		
		
		//title id_gender1
		
			WebElement MR = driver.findElement(By.id("id_gender1"));
			MR.click();
		
			
			//password
			
			WebElement password = driver.findElement(By.id("password"));
			password.sendKeys("Gopal@123");
			
			//days
			
			WebElement days = driver.findElement(By.id("days"));
			days.click();
			days.sendKeys(Keys.ARROW_DOWN);
			days.click();
			
			//months chatGPT
			
			WebElement months = driver.findElement(By.id("months"));

			Select select = new Select(months);
			
			select.selectByVisibleText("May");
			
			
			
			// years 
		
			WebElement years = driver.findElement(By.id("years"));
			
			Select yearsSelect = new Select(years);
			
			yearsSelect.selectByVisibleText("2000");
			
			// 10. Select checkbox 'Sign up for our newsletter!' newsletter
			
			WebElement signupcheckbox = driver.findElement(By.id("newsletter"));
			signupcheckbox.click();
			
			//11. Select checkbox 'Receive special offers from our partners!' optin
			WebElement receiveSPL = driver.findElement(By.id("optin"));
			receiveSPL.click();
			
			// 12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
			
			//first_name
			WebElement first_name = driver.findElement(By.id("first_name"));
			first_name.sendKeys("Gopal");
			
			//last_name
			WebElement last_name = driver.findElement(By.id("last_name"));
			last_name.sendKeys("Gopal");
			
			//company
			WebElement company = driver.findElement(By.id("company"));
			company.sendKeys("NOVAC");
			
			//address1
			WebElement address1 = driver.findElement(By.id("address1"));
			address1.sendKeys("MYlapore");
			
			//address2
			WebElement address2 = driver.findElement(By.id("address2"));
			address2.sendKeys("CHENNAI");
			
			//country
			
			//state
			WebElement state = driver.findElement(By.id("state"));
			state.sendKeys("CHENNAI");
			
			//city
			WebElement city = driver.findElement(By.id("city"));
			city.sendKeys("porur");
			
			//zipcode
			WebElement zipcode = driver.findElement(By.id("zipcode"));
			zipcode.sendKeys("600122");
			
			//mobile_number
			WebElement mobile_number = driver.findElement(By.id("mobile_number"));
			mobile_number.sendKeys("7000000000");
			
			//Create Account //*[contains(text(),'Create Account')]
			WebElement create_account = driver.findElement(By.xpath("//*[contains(text(),'Create Account')]"));
			create_account.click();
			
			// 14. Verify that 'ACCOUNT CREATED!' is visible //*[contains(text(),'Account Created!')]
			
			WebElement accountCreated = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Account Created!')]")));
			
			if (accountCreated.isDisplayed()) {
				System.out.println("Account creation is  visible");
			}else {
				System.out.println("Account creation is not visible");
			}
			

			// 15.Click 'Continue' button   //*[contains(text(),'Continue')]
			WebElement continuebtn = driver.findElement(By.xpath("//*[contains(text(),'Continue')]"));
			continuebtn.click();
			
			
			// 16. Verify that 'Logged in as username' is visible
			WebElement username = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath(" //*[contains(text(),'Logged in as')]")));
			
			if (username.isDisplayed()) {
				System.out.println("'Logged in as ' " + first_name + " is visible");
			}else {
				System.out.println("'Logged in as username' " + first_name +" is not visible");
			}
			
			
			//WebElement loggedInUser = driver.findElement(By.id("username"));
			
			if(username.equals(first_name)) {
				System.out.println(first_name + "is logged in");
			}else {
				System.out.println(first_name + "is not logged in");
			}
			
			
			
			// 17. Click 'Delete Account' button //a[contains(@href, '/delete_account') and normalize-space(text()) = 'Delete Account']
			WebElement deleteAccount = driver.findElement(By.xpath(
					"//a[contains(@href, '/delete_account') and normalize-space(text()) = 'Delete Account']"));
			deleteAccount.click();
			
			
			
			
			
			// 18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button 
			//*[contains(text(),'Account Deleted!')]
			//a[@href='/' and normalize-space(text())='Continue']  
			WebElement ACCOUNTDELETED = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath(" //*[contains(text(),'Account Deleted!')]")));
			
			if (ACCOUNTDELETED.isDisplayed()) {
				System.out.println(" 'ACCOUNT DELETED!' is visible");
			}else {
				System.out.println( " 'ACCOUNT DELETED!' is not visible");
			}
			
			
			WebElement clickCntbtn = driver.findElement(By.xpath(
					"//a[@href='/' and normalize-space(text())='Continue']"));
			clickCntbtn.click();
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		
		
		
	}

}
