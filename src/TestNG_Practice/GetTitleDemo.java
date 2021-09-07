package TestNG_Practice;

import java.awt.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



import junit.framework.Assert;

public class GetTitleDemo {
	public WebDriver driver;

	@BeforeMethod
	@Parameters("Browser")
	public void setup(String browserName) {
		
		if(browserName.equalsIgnoreCase("chrome")) {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sipancha\\Desktop\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		}
		
		else if(browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		
		driver.get("https://www.flipkart.com/");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Title of the webapge is: "+driver.getTitle());


	}


	/*@Test(priority= 0)
	public void searchProduct() {
		WebElement closePopUp = driver.findElement(By.xpath("//button[@class=\"_2KpZ6l _2doB4z\"]"));
		closePopUp.click();

		WebElement searchBox = driver.findElement(By.xpath("//input[@name=\"q\"]"));
		searchBox.sendKeys("Samsung Galaxy S10");
		searchBox.sendKeys(Keys.ENTER);
	}*/

	@Test
	public void applyFilters() throws InterruptedException {

		WebElement closePopUp = driver.findElement(By.xpath("//button[@class=\"_2KpZ6l _2doB4z\"]"));
		closePopUp.click();

		WebElement searchBox = driver.findElement(By.xpath("//input[@name=\"q\"]"));
		searchBox.sendKeys("Samsung Galaxy S10");
		searchBox.sendKeys(Keys.ENTER);


		Thread.sleep(3000);
		WebElement flipkartAssured= driver.findElement(By.xpath("//img[@class=\"_3U-Vxu\"]"));
		flipkartAssured.isDisplayed();
		flipkartAssured.click();

		//WebElement flipkartAssuredCheckbox= driver.findElement(By.xpath("//img[@class=\"_3U-Vxu\"]//preceding::input[1]"));
		//flipkartAssuredCheckbox.click();

		//Element <div class="_3879cV">...</div> is not clickable at point (144, 558). Other element would receive the click: <div class="_213eRC _2ssEMF">...</div>

		//WebElement brandSection= driver.findElement(By.xpath("//div[@class=\"_213eRC _2ssEMF\"]"));

		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("arguments[0].scrollIntoView();",brandSection);
		//js.executeScript("window.scrollBy(0,1000)");

		//WebElement samsungFilter= driver.findElement(By.xpath("//div[text()=\"SAMSUNG\"]"));
		//samsungFilter.click();

		//WebElement samsungCheckbox= driver.findElement(By.xpath("//div[text()= \"SAMSUNG\"]//preceding::input[1]"));
		//samsungCheckbox.click();



		WebElement price= driver.findElement(By.xpath("//span[text()=\"Price\"]"));

		/*WebElement min_dropdown= driver.findElement(By.xpath("//select[@class=\"_2YxCDZ\"]"));

		Select sel = new Select(min_dropdown);

		Thread.sleep(3000);

		sel.selectByVisibleText("₹2000");

		Thread.sleep(2000);*/
		
		WebElement priceHighToLow= driver.findElement(By.xpath("//div[text()=\"Price -- High to Low\"]"));
		
		priceHighToLow.click();

		java.util.List<WebElement> els= driver.findElements(By.xpath("//*[contains(text(),'SAMSUNG Galaxy')]"));

		int total = els.size();

		System.out.println("Total number of samsung results are "+total);


		java.util.List<WebElement> els2= driver.findElements(By.xpath("//*[contains(text(),'SAMSUNG Galaxy')]//following::div[5]"));

		int total2 = els2.size();

		System.out.println("Total number of samsung results are "+total2);


		for(int i=0;i<total; i++) {
		
			String str = els.get(i).getText();
			String str2 = els2.get(i).getText();

			System.out.println("Product names is "+str+"Products prices is "+str2);
			
	

	}

		/*java.util.List<WebElement> linkElements = driver.findElements(By.xpath("//*[contains(text(),'SAMSUNG Galaxy S10')]"));
		
        String[] linkTexts = new String[linkElements.size()];							
			int	i = 0;					

				
			for (WebElement e : linkElements) {							
			linkTexts[i] = e.getText();							
			i++;			
        }		

				
			for (String t : linkTexts) {							
			driver.findElement(By.linkText(t)).click();					
			if (driver.getTitle().equals("SAMSUNG Galaxy S10")) {							
                System.out.println("\"" + t + "\""								
                        + " is under construction.");			
            } else {			
                System.out.println("\"" + t + "\""								
                        + " is working.");			
            }		
			driver.navigate().back();			
        }		*/
		
		
			
			
			
		}
	@AfterMethod
	public void teardown() {
		
		driver.close();
	}}

