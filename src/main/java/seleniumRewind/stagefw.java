package seleniumRewind;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class stagefw {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		System.setProperty("webdriver.chrome.driver","D:\\Selenium\\Chrome\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://stage.shriramgi.com/car-insurance");
		
		
		WebElement carRegNo =   driver.findElement(By.id("reg_number"));
		carRegNo.click();
		carRegNo.sendKeys("TN85B1234");
		
		WebElement mobNo = driver.findElement(By.id("mobile_number"));
		mobNo.click();
		mobNo.sendKeys("7070707070");
		
		WebElement checkBox = driver.findElement(By.id("imb7p"));
		checkBox.click();
		
		WebElement InsureNowBtn = driver.findElement(By.id("carRegFormSubmit"));
		InsureNowBtn.click();
		
		
	
		/*       
		
WebElement otp1 = driver.findElement(By.cssSelector("input[type='tel']"));
		
		if(otp1.isEnabled()) {
			System.out.println("OTP field1  is enabled.");
		}else {
            System.out.println("OTP field1 is NOT enabled.");
        }
		
		*/
		
		
		//update
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		try {
		    // Locate all OTP fields
		    List<WebElement> otpFields = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
		            By.cssSelector("input[type='tel']")
		    ));
		    System.out.println("Number of OTP fields found: " + otpFields.size());

		    // Scroll to fields and check visibility
		    JavascriptExecutor js = (JavascriptExecutor) driver;
		    int visibleCount = 0;

		    for (WebElement field : otpFields) {
		        js.executeScript("arguments[0].scrollIntoView(true);", field);

		        if (field.isDisplayed()) {
		            System.out.println("Field is visible: " + field.getAttribute("id"));
		            visibleCount++;
		        } else {
		            System.out.println("Field is NOT visible: " + field.getAttribute("id"));
		        }
		    }

		    System.out.println("Number of visible OTP fields: " + visibleCount);

		    // OTP value to send
		    String otp = "1111";

		    // Send OTP digit by digit
		    for (int i = 0; i < otp.length(); i++) {
		        String fieldId = "otp" + (i + 1); // Field IDs are otp1, otp2, otp3, otp4
		        js.executeScript("document.getElementById('" + fieldId + "').value = '" + otp.charAt(i) + "';");
		    }

		    System.out.println("OTP sent to hidden fields.");
		} catch (Exception e) {
		    e.printStackTrace(); // Print full stack trace for better debugging
		}
		
		/*
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		try {
		    // Locate all OTP fields
		    List<WebElement> otpFields = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
		            By.cssSelector("input[type='tel']")
		    ));
		    System.out.println("Number of OTP fields found: " + otpFields.size());

		    // OTP value to send
		    String otp = "1234";

		    // Send OTP digit by digit
		    JavascriptExecutor js = (JavascriptExecutor) driver;
		   // js.executeScript(s, args)
		    for (int i = 0; i < otp.length(); i++) {
		        String fieldId = "otp" + (i + 1); // Field IDs are otp1, otp2, otp3, otp4
		        js.executeScript("document.getElementById('" + fieldId + "').value = '" + otp.charAt(i) + "';");
		        System.out.println("OTP sent to field " + fieldId + ": " + otp.charAt(i));
		    }
		} catch (Exception e) {
		    e.printStackTrace(); // Print full stack trace for better debugging
		}
		
		
		*/
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
