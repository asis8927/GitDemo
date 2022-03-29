package Academy.E2EProject1;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class HomePage extends Base {
	@Test(dataProvider="getData")
	public void basePageNavigation(String username, String password,String text) throws IOException, InterruptedException
	{
		driver=initializeDriver();
		driver.get("http://qaclickacademy.com/");
		LandingPage l=new LandingPage(driver);
				l.getLogin().click();
				LoginPage lp=new LoginPage(driver);
				lp.getEmail().sendKeys(username);
				lp.getPassword().sendKeys(password);
				System.out.println(text);
				lp.getLogin().click();
	}
				@DataProvider
				public void getData()
				{
					Object[][] data= new Object[1][2];
					data[0][0]="nonrestricted.@com";
					data[0][1]="123544";
					data[0][2]="Restricted Uesr";
					
					data[1][0]="restricted.@com";
					data[1][1]="6521";
					data[1][2]="NonRestricted Uesr";
						
				}
	}				
				
				
				
				
				
				
