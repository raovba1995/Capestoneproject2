package stepdefs;

import java.time.Duration;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FlyawayStepDefs {
	
	WebDriver driver = Hooks.driver;
	
	String actmsg;
	
	@Given("I have launched the application")
	public void i_have_launched_the_application() {
	    // Write code here that turns the phrase above into concrete actions
		driver.get("http://localhost:8081/FlyAway/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@When("I click on Signup link")
	public void i_click_on_Signup_link() {
	    // Write code here that turns the phrase above into concrete actions
		 WebElement signup = driver.findElement(By.xpath("//a[2]"));
		 signup.click();
	}

	@When("I click on  Not a member?Signup link")
	public void i_click_on_Not_a_member_Signup_link() {
	    // Write code here that turns the phrase above into concrete actions
		WebElement signuplink = driver.findElement(By.xpath("//tr[3]/td/a"));
		 signuplink.click();
	}

	@When("I enter the details")
	public void i_enter_the_details(Map<String, String> map1) {
		for (String item : map1.keySet()) {
			if (item.equals("Email id")) {
				WebElement mail = driver.findElement(By.name("email_id"));
				mail.sendKeys(map1.get(item));

			} else if (item.equals("Password")) {
				WebElement password = driver.findElement(By.name("pwd"));
				password.sendKeys(map1.get(item));
			}else if (item.equals("Confirm Password")) {
				WebElement password2 = driver.findElement(By.name("pwd2"));
				password2.sendKeys(map1.get(item));
			}else if (item.equals("Name")) {
				WebElement password2 = driver.findElement(By.name("name"));
				password2.sendKeys(map1.get(item));
			}else if (item.equals("Address")) {
				WebElement add = driver.findElement(By.name("address"));
				add.sendKeys(map1.get(item));
			}else {
				WebElement city = driver.findElement(By.name("city"));
				city.sendKeys(map1.get(item));
			}
		}
	    
	}

	@When("I click on Signup button")
	public void i_click_on_Signup_button() {
	    // Write code here that turns the phrase above into concrete actions
		WebElement signupbtn = driver.findElement(By.xpath("//tr[7]/td/button"));
	    signupbtn.click();
	  //  System.out.println("Signupsuccess");
	}
	
	@Then("I should see the link as {string}")
	public void i_should_see_the_link_as(String msg) {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Signupsuccess");
		WebElement success = driver.findElement(By.xpath("/html/body/a[3]"));
		actmsg = success.getText();
		Assert.assertEquals(msg, actmsg);
	}


	@Given("I click on login link")
	public void i_click_on_login_link() {
	    // Write code here that turns the phrase above into concrete actions
		WebElement login = driver.findElement(By.xpath("//a[2]"));
		 login.click();
	}

	@When("I enter emailid as {string}")
	public void i_enter_emailid_as(String email) {
	    // Write code here that turns the phrase above into concrete actions
		WebElement mailid = driver.findElement(By.name("email_id"));
		mailid.sendKeys(email);
	    
	}

	@When("I enter the password as {string}")
	public void i_enter_the_password_as(String pswd) {
	    // Write code here that turns the phrase above into concrete actions
		WebElement paswd = driver.findElement(By.name("pwd"));
		paswd.sendKeys(pswd);
	}

	@When("I click on login button")
	public void i_click_on_login_button() {
	    // Write code here that turns the phrase above into concrete actions
		WebElement loginbtn = driver.findElement(By.xpath("//tr[3]/td/button"));
		 loginbtn.click();
	}

	@Then("I should land on to Flyaway-Dashboard page")
	public void i_should_land_on_to_Flyaway_Dashboard_page() {
	    // Write code here that turns the phrase above into concrete actions
		WebElement success = driver.findElement(By.xpath("//h3"));
		actmsg = success.getText();
		Assert.assertEquals("FLYAWAY - DASHBOARD", actmsg);
		
	}

	@Then("I should get the error message as {string}")
	public void i_should_get_the_error_message_as(String msg) {
	    // Write code here that turns the phrase above into concrete actions
		WebElement error = driver.findElement(By.tagName("body"));
		actmsg = error.getText();
		String[] lines = actmsg.split("\\r?\\n");
		//System.out.println(lines[2]);
		//System.out.println(actmsg);
		Assert.assertEquals(msg, lines[2]);
		
		
	}

	@When("I click on Home button")
	public void i_click_on_Home_button() {
	    // Write code here that turns the phrase above into concrete actions
		WebElement homebtn = driver.findElement(By.xpath("//a[1]"));
		 homebtn.click();
		
	}

	@When("selected source as {string}")
	public void selected_source_as(String src1) {
	    // Write code here that turns the phrase above into concrete actions
		WebElement src = driver.findElement(By.name("source"));
		Select sources = new Select(src);
		sources.selectByVisibleText(src1);
	}

	@When("selected destination as {string}")
	public void selected_destination_as(String dest1) {
	    // Write code here that turns the phrase above into concrete actions
		WebElement dest = driver.findElement(By.name("destination"));
		Select destinations = new Select(dest);
		destinations.selectByVisibleText(dest1);
	
		
	}

	@When("I click on submit button")
	public void i_click_on_submit_button() {
	    // Write code here that turns the phrase above into concrete actions
		WebElement subbtn = driver.findElement(By.xpath("//tr/td[3]/button"));
		 subbtn.click();
		
	}

	@When("I click on BookFlight link")
	public void i_click_on_BookFlight_link() {
	    // Write code here that turns the phrase above into concrete actions
		WebElement bookflight = driver.findElement(By.xpath("//tr[2]/td[6]/a"));
		 bookflight.click();
		
	}
	
	@When("I Click on Click to complete booking")
	public void i_Click_on_Click_to_complete_booking() {
	    // Write code here that turns the phrase above into concrete actions
		WebElement completebook = driver.findElement(By.xpath("//a[6]"));
		 completebook.click();
	    
	}

	@Then("I should land on to Flyaway-Booking Confirmation page")
	public void i_should_land_on_to_Flyaway_Booking_Confirmation_page() {
	    // Write code here that turns the phrase above into concrete actions
		WebElement success = driver.findElement(By.xpath("//h3"));
		actmsg = success.getText();
		Assert.assertEquals("FLYAWAY - BOOKING CONFIRMATION", actmsg);
	}

	@Then("i click on your bookings link")
	public void i_click_on_your_bookings_link() {
	    // Write code here that turns the phrase above into concrete actions
		WebElement mybooking = driver.findElement(By.xpath("//a[4]"));
		 mybooking.click();
	    
	    
	}

	@Then("I should land on to Flyaway-Your Bookings page")
	public void i_should_land_on_to_Flyaway_Your_Bookings_page() {
	    // Write code here that turns the phrase above into concrete actions
		WebElement success = driver.findElement(By.xpath("//h3"));
		actmsg = success.getText();
		Assert.assertEquals("FLYAWAY - YOUR BOOKINGS", actmsg);
	}

	@Then("I should see Source as {string} and Destination as {string} in the table")
	public void i_should_see_Source_as_and_Destination_as_in_the_table(String src, String dest) {
	    // Write code here that turns the phrase above into concrete actions
		WebElement source = driver.findElement(By.xpath("//tr[2]/td[2]"));
		actmsg = source.getText();
		Assert.assertEquals(src, actmsg);
		WebElement destination = driver.findElement(By.xpath("//tr[2]/td[3]"));
		String actmsg1 = destination.getText();
		Assert.assertEquals(dest, actmsg1);
	    
	}

}
