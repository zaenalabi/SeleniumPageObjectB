package com.juaracoding.pageobjectB;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.juaracoding.pageobject.drivers.DriverSingleton;
import com.juaracoding.pageobject.main.DutyPageObjectB;

public class TestDutyPageObjectB {
	public static WebDriver driver;
	private DutyPageObjectB dutyPageObjectB;

	@BeforeClass
	public void setUp() {
		DriverSingleton.getInstance("Chrome");
		driver = DriverSingleton.getDriver();

		String url = "https://shop.demoqa.com/my-account/";
		driver.get(url);

	}

	@BeforeMethod
	public void pageObjectTwo() {
		dutyPageObjectB = new DutyPageObjectB();
	}

	@Test
	public void testDutyPageObjectB() {

		delay(3);
		scroll(700);
		dutyPageObjectB.usernameReg();
		dutyPageObjectB.emailReg();
		dutyPageObjectB.passwordReg();
		dutyPageObjectB.regist();
		System.out.println("You have successfully Registered a New Account.");

		delay(3);
		dutyPageObjectB.usernameLogin();
		dutyPageObjectB.passwordLogin();
		dutyPageObjectB.btnLogin();
		System.out.println("Your newly created account is successfully logged in.");

		delay(3);
		dutyPageObjectB.btnOrder();
		System.out.println("You're entering your order page.");
		dutyPageObjectB.btnBrowse();
		System.out.println("Do you wish to browse to other products?");
		dutyPageObjectB.search();
		delay(3);
		dutyPageObjectB.searchInput();
		scroll(500);
		System.out.println("You're successfully search of your keyword");

		delay(3);
		dutyPageObjectB.compareOne();
		System.out.println("You have added a product to compare list.");
		delay(3);
		dutyPageObjectB.closeWindow();

		delay(3);
		dutyPageObjectB.clickProductTitle();
		System.out.println("You are looking on Product detail page.");

		scroll(700);

		delay(3);
		dutyPageObjectB.compareTwo();
		System.out.println("You have added product 2 to compare list.");

		delay(3);
		driver.switchTo().frame(driver.findElement(By.cssSelector("#cboxLoadedContent > iframe")));

		delay(3);
		dutyPageObjectB.selectProduct();
		System.out.println("You have selected a product detail.");
		
		delay(3);
		scroll(700);
		dutyPageObjectB.addCart();
		System.out.println("You have added a product to a cart.");
		dutyPageObjectB.viewCart();
		System.out.println("You viewed your cart.");
		
		scroll(700);
		dutyPageObjectB.proceedCheckout();
		System.out.println("You proceed your cart to Check out.");
		delay(3);
		
		scroll(700);
		dutyPageObjectB.firstName();
		dutyPageObjectB.lastName();
		dutyPageObjectB.companyName();
		scroll(300);
		
		
		delay(3);
		dutyPageObjectB.houseNumber();
		dutyPageObjectB.suiteUnit();
		dutyPageObjectB.townCity();
		
		delay(3);
		dutyPageObjectB.selectProvice();
		dutyPageObjectB.inputProvince();
		
		delay(3);
		dutyPageObjectB.inputPostcode();
		dutyPageObjectB.inputPhone();
		dutyPageObjectB.inputNote();
		System.out.println("You have successfully entered you billing detail.");
		
		delay(3);
		scroll(-300);
		dutyPageObjectB.agreeBox();
		
		delay(3);
		dutyPageObjectB.btnPlacedOrder();
		System.out.println("Congratulation! your order was successfully created.");
	
		delay(10);

	}

	@AfterClass
	public void closeBrowser() {
		delay(3);
		driver.quit();
	}

	static void delay(int detik) {
		try {
			Thread.sleep(1000 * detik);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static void scroll(int vertical) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0," + vertical + ")");
	}
}

