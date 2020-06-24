package stepDefinations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefination1 {
	WebDriver driver;
	@When("^launch url in chrome$")
	public void launch_url_in_chrome() throws Throwable {
	driver=new ChromeDriver();
	driver.get("http://orangehrm.qedgetech.com/");
	driver.manage().window().maximize();
	    
	}

	@When("^I enter username and password$")
	public void i_enter_username_and_password() throws Throwable {
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("Qedge123!@#");
	   
	}

	@When("^I click Login Button$")
	public void i_click_Login_Button() throws Throwable {
		driver.findElement(By.name("Submit")).click();
		Thread.sleep(5000);
	   
	}

	@Then("^I Should see Welcome Link on Home Page$")
	public void i_Should_see_Welcome_Link_on_Home_Page() throws Throwable {
	   String expected="Welcome";
	   String actual =driver.findElement(By.id("welcome")).getText();
	   if(actual.contains(expected))
	   {
		System.out.println("Login success");   
	   }
	   else
	   {
		   System.out.println("Login Fail");  
	   }
	}

	@When("^I close the browser$")
	public void i_close_the_browser() throws Throwable {
		driver.close();
	    
	}
}
