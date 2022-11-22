package subscriptionValidation;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.BaseClass.Base_Class;
import com.data.ConfigManager;
import com.pageObjectMan.PageObjMan;
import com.subscriptionData.Sub_Manager;

public class Lite extends Base_Class {

	public static WebDriver driver;
	static PageObjMan pom;
	String $userKp;
	String $drKp;
	static JavascriptExecutor j;
	WebDriverWait ww;
	String kpid;

	@BeforeClass
	private void l() throws InterruptedException, IOException {

		driver = browserLaunch("chrome");
		pom = new PageObjMan(driver);
		j = (JavascriptExecutor) driver;
		ww = new WebDriverWait(driver, 60);
		String ur = ConfigManager.getconfigManager().getInstanceConfigReader().getUrl();

		while (true) {
			if (ur.equals("https://localhost:8443/")) {

				driver.get(ConfigManager.getconfigManager().getInstanceConfigReader().getUrl());
				sleep(3000);
				driver.findElement(By.id("details-button")).click();
				sleep(3000);

				driver.findElement(By.id("proceed-link")).click();
				sleep(4000);
				implicitWait(60, TimeUnit.SECONDS);

				break;
			} else if (ur.equals("https://www.75health.com/login.jsp")) {
				driver.get("https://www.75health.com/login.jsp");

				break;
			}

		}

		click(pom.getInstanceLoginPage().sigIn);
		sleep(2000);
		sendkeys(pom.getInstanceLoginPage().email,
				ConfigManager.getconfigManager().getInstanceConfigReader().getEmail());
		sendkeys(pom.getInstanceLoginPage().pass, ConfigManager.getconfigManager().getInstanceConfigReader().getpass());
		click(pom.getInstanceLoginPage().login);

		ww.until(ExpectedConditions.urlToBe("https://localhost:8443/health/#home"));
		// https://localhost:8443/health/#home
		// https://www.75health.com/health/#home

	}

	@Test(priority = 0)
	private void LiteManageruser() throws InterruptedException, IOException {

		// while(true) {}

		WebElement $upgradeLater$ = driver.findElement(By.xpath("(//button[@title='Upgrade Later'])[1]"));
		visbility(driver, $upgradeLater$, 60);
		click($upgradeLater$);

		visbility(driver, pom.getInstanceSetting().clickSettings, 60);
		javascriptclick(pom.getInstanceSetting().clickSettings);

		WebElement manageuser = driver.findElement(By.xpath("//button[@onclick='setting.userList()']"));
		visbility(driver, manageuser, 60);
		manageuser.click();
		WebElement adduser = driver.findElement(By.xpath("//button[@onclick='Health.user_new()']"));
		visbility(driver, adduser, 60);
		adduser.click();
		sleep(2000);
		WebElement trp14 = driver.findElement(By.xpath("//input[@id='Firstname']"));
		visbility(driver, trp14, 60);
		sendkeys(trp14, Sub_Manager.getInstanecSubManager().getInstanceSubReader().firstname());
		WebElement trp15 = driver.findElement(By.xpath("//input[@id='LastName']"));
		visbility(driver, trp15, 60);
		sendkeys(trp15, Sub_Manager.getInstanecSubManager().getInstanceSubReader().lastname());
		sleep(2000);
		WebElement trp16 = driver.findElement(By.xpath("//input[@id='UserLoginId']"));
		visbility(driver, trp16, 60);
		sendkeys(trp16, Sub_Manager.getInstanecSubManager().getInstanceSubReader().$lte$useremail());
		// .sendKeys("Akashn1212@gmail.com");
		sleep(2000);
		WebElement trp17 = driver.findElement(By.xpath("//button[@id='user_dropdown']"));
		visbility(driver, trp17, 60);
		click(trp17);// .click();
		List<WebElement> usserdrp = driver.findElements(By.xpath("//button[@id='user_dropdown']//following::ul[1]/li"));
		for (WebElement web : usserdrp) {
			if (web.getText().trim().equals("Standard User")) {
				visbility(driver, web, 60);
				web.click();
				break;
			}

		}
		sleep(2000);

		WebElement createuser = driver.findElement(By.xpath("(//button[@id='createButton'])[2]"));
		visbility(driver, createuser, 60);

		WebElement canceluser = driver.findElement(By.xpath("(//button[@onclick='window.history.back()'])[2]"));
		visbility(driver, canceluser, 60);
		// canceluser.click(); //
		createuser.click();
		WebElement user_dr = driver.findElement(By.xpath("(//td[@id='val-kdid'])[2]"));
		visbility(driver, user_dr, 60);
		$userKp = user_dr.getText();
		// System.out.println(id);

	}

	String $gm;

	@Test(priority = 1)
	private void $liteManageSubscription() throws InterruptedException, IOException {

		visbility(driver, pom.getInstanceSetting().clickSettings, 60);
		javascriptclick(pom.getInstanceSetting().clickSettings);

		WebElement $manageSubscription$ = driver.findElement(By.xpath("//button[text()='Manage Subscription']"));
		visbility(driver, $manageSubscription$, 60);
		javascriptclick($manageSubscription$);

		WebElement $createusericon$ = driver.findElement(By.xpath("//div[@id='add-new-user']/i"));
		visbility(driver, $createusericon$, 60);
		click($createusericon$);

		// create a user from manage subscription..

		WebElement trp14 = driver.findElement(By.xpath("//input[@id='Firstname']"));
		visbility(driver, trp14, 60);
		sendkeys(trp14, Sub_Manager.getInstanecSubManager().getInstanceSubReader().firstname());
		WebElement trp15 = driver.findElement(By.xpath("//input[@id='LastName']"));
		visbility(driver, trp15, 60);
		sendkeys(trp15, Sub_Manager.getInstanecSubManager().getInstanceSubReader().lastname());
		sleep(2000);
		WebElement trp16 = driver.findElement(By.xpath("//input[@id='UserLoginId']"));
		visbility(driver, trp16, 60);
		sendkeys(trp16, Sub_Manager.getInstanecSubManager().getInstanceSubReader().$lte$dremail());
		// .sendKeys("Akashn1212@gmail.com");
		sleep(2000);
		WebElement trp17 = driver.findElement(By.xpath("//button[@id='user_dropdown']"));
		visbility(driver, trp17, 60);
		click(trp17);
		// .click();
		List<WebElement> usserdrp = driver.findElements(By.xpath("//button[@id='user_dropdown']//following::ul[1]/li"));
		for (WebElement web : usserdrp) {
			if (web.getText().trim().equals("Standard User")) {
				visbility(driver, web, 60);
				web.click();
				break;
			}

		}
		sleep(2000);

		WebElement createuser = driver.findElement(By.xpath("(//button[@id='createButton'])[2]"));
		visbility(driver, createuser, 60);

		WebElement canceluser = driver.findElement(By.xpath("(//button[@onclick='window.history.back()'])[2]"));
		visbility(driver, canceluser, 60);
		// canceluser.click(); //
		createuser.click();
		WebElement user_dr = driver.findElement(By.xpath("(//td[@id='val-kdid'])[2]"));
		visbility(driver, user_dr, 60);
		$drKp = user_dr.getText();

		WebElement $drgm = driver
				.findElement(By.xpath("(//span[text()='Basic Information'])[4]/following::table[1]/tbody/tr[2]/td[3]"));
		$gm = $drgm.getText();
		System.out.println($gm);

	}

	@Test(priority = 2)
	private void $activeuserAndPayementpage$lte$() throws InterruptedException {
		driver.navigate().to("https://localhost:8443/health/#allPaymentHistory");
		sleep(5000);
		driver.navigate().to("https://localhost:8443/health/#allSubscriptionActiveUsers");
		sleep(3000);

	}

	@Test(priority = 3)
	private void activate$deac$lte() throws IOException, InterruptedException {

		String $user = $userKp.replace("-", "");
		// System.out.println($user);

		for (int i = 1; i <= 5; i++) {
			try {
				WebElement ids = driver.findElement(By.xpath("//div[text()='" + $user + "']"));

				actions("move to element", ids);

				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		WebElement userdcact = driver.findElement(By.xpath("//div[text()='" + $user + "']//following::span[3]"));

		for (int i = 1; i <= 5; i++) {
			try {
				visbility(driver, userdcact, 60);
				actions("click", userdcact);

				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		List<WebElement> cnclacdrp = driver
				.findElements(By.xpath("//div[text()='" + $user + "']//following::span[3]//following::ul[1]/li"));
		for (WebElement web : cnclacdrp) {

			if (web.getText().trim().equals("Cancel Subscription")) {

				visbility(driver, web, 60);
				web.click();

				break;
			}

		}

		sleep(2500);
		// activate the same user..
		WebElement $deacusericon = driver.findElement(By.xpath("//div[@id='menu-deactivated-user']"));
		visbility(driver, $deacusericon, 60);
		actions("click", $deacusericon);
		sleep(2000);

		WebElement $deusrmv = driver.findElement(By.xpath("//div[text()='" + $user + "']"));

		actions("move to element", $deusrmv);

		for (int i = 1; i <= 5; i++) {
			try {

				WebElement $dcacElipse = driver
						.findElement(By.xpath("//div[text()='" + $user + "']//following::span[3]"));
				actions("move to element", $dcacElipse);

				visbility(driver, $dcacElipse, 60);
				actions("click", $dcacElipse);

				break;
			} catch (Exception e) {
				System.out.println(e);
			}
		}

		List<WebElement> $dcacelipsedrp = driver
				.findElements(By.xpath("//div[text()='" + $user + "']//following::span[3]//following::ul[1]/li/a"));
		for (WebElement web : $dcacelipsedrp) {
			if (web.getText().trim().equals("Activate Subscription")) {
				click(web);

				break;
			}

		}
		// verify userto act with pass..

		WebElement $verifypasstoact = driver.findElement(By.xpath("//input[@id='userPasswordEir-1']"));
		visbility(driver, $verifypasstoact, 60);
		sendkeys($verifypasstoact, ConfigManager.getconfigManager().getInstanceConfigReader().getpass());

		WebElement $submitpass = driver.findElement(By.xpath("//input[@id='userPasswordEir-1']//following::button[2]"));
		visbility(driver, $submitpass, 60);
		click($submitpass);
		sleep(5000);

		//

		for (int i = 1; i <= 5; i++) {
			try {
				WebElement ids = driver.findElement(By.xpath("//div[text()='" + $user + "']"));

				actions("move to element", ids);

				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		WebElement userdcact1 = driver.findElement(By.xpath("//div[text()='" + $user + "']//following::span[3]"));
		System.out.println(userdcact1);

		for (int i = 1; i <= 5; i++) {
			try {
				visbility(driver, userdcact1, 60);
				actions("click", userdcact1);

				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		List<WebElement> cnclacdrp1 = driver
				.findElements(By.xpath("//div[text()='" + $user + "']//following::span[3]//following::ul[1]/li"));
		for (WebElement web : cnclacdrp1) {

			if (web.getText().trim().equals("Cancel Subscription")) {

				visbility(driver, web, 60);
				web.click();

				break;
			}

		}
		sleep(4000);
	}

	@Test(priority = 4)
	private void $upgradeplan$UI() throws InterruptedException, AWTException {

		WebElement $upgradeplnui$ = driver.findElement(By.xpath("(//span[@id='manage-sub-text'])[1]/a/img"));
		visbility(driver, $upgradeplnui$, 60);
		actions("click", $upgradeplnui$);

		sleep(2000);

		WebElement $editusers$ = driver.findElement(By.xpath("//button[@onclick='allPaymentServices.editUsers();']"));
		visbility(driver, $editusers$, 60);
		javascriptclick($editusers$);

		sleep(2000);

		try {
			WebElement $removeusermovescn$ = driver.findElement(By.xpath("//div[text()='" + $gm + "']"));
			visbility(driver, $removeusermovescn$, 60);

			actions("move to element", $removeusermovescn$);

		} catch (Exception e) { // TODO: handle exception

		}
		sleep(2000);

		WebElement $removeuserfrmedituser$ = driver
				.findElement(By.xpath("//div[text()='" + $gm + "']//following::div[2]"));

		visbility(driver, $removeuserfrmedituser$, 60);

		actions("click", $removeuserfrmedituser$);

		WebElement $addMoreuser = driver.findElement(By.xpath("(//button[@title='Add More Premium users'])[2]"));
		visbility(driver, $addMoreuser, 60);
		javascriptclick($addMoreuser);

		WebElement $usertxtbx = driver.findElement(By.xpath("//input[@id='userPartySearch0']"));
		visbility(driver, $usertxtbx, 60);
		sendkeys($usertxtbx, $userKp);
		sleep(3000);
		keypress();
		keyenter();

		WebElement $proceedpay$lte = driver.findElement(By.xpath("(//button[text()='Proceed Payment'])[3]"));
		visbility(driver, $proceedpay$lte, 60);
		javascriptclick($proceedpay$lte);
		sleep(2500);
	}

	@Test(priority = 5)
	public void payementpageAndCardDetail$lte() throws InterruptedException {
		for (int i = 1; i <= 5; i++) {
			try {
				WebElement basicsub = driver.findElement(By.xpath("//span[text()='$ 19']"));
				actions("move to element", basicsub);
				visbility(driver, basicsub, 60);
				javascriptclick(basicsub);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		sleep(4000);
		// card details

		driver.switchTo().frame(driver.findElement(By.xpath("//div[@id='card-details']//iframe")));
		System.out.println("switch in frame");

		for (int i = 1; i <= 5; i++) {
			try {
				driver.findElement(By.name("cardnumber")).sendKeys("4242 4242 4242 4242");
				System.out.println("card num iden");

				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		WebElement expyr = driver.findElement(By.name("exp-date"));
		visbility(driver, expyr, 60);
		sendkeys(expyr, "424");
		WebElement cvc = driver.findElement(By.name("cvc"));
		visbility(driver, cvc, 60);
		sendkeys(cvc, "242");

		WebElement zipcode = driver.findElement(By.name("postal"));
		visbility(driver, zipcode, 60);
		sendkeys(zipcode, "42424");

		defaultcontent();

		driver.findElement(By.id("save_btn")).click();

		while (true) {

			try {
				WebElement $finishLite = driver.findElement(By.xpath("//span[text()='Finish']"));
				if ($finishLite.isDisplayed()) {
					visbility(driver, $finishLite, 60);
					javascriptclick($finishLite);
					break;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}

	////// $$$$$$$$$$$$$$$$$$$$$$$$$lite
	////// ends$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$////////////////////////////////////////

	// basic package..

	@Test(priority = 6)
	private void $manageuser$basic() throws IOException, InterruptedException {

		visbility(driver, pom.getInstanceSetting().clickSettings, 60);
		javascriptclick(pom.getInstanceSetting().clickSettings);

		WebElement manageuser = driver.findElement(By.xpath("//button[@onclick='setting.userList()']"));
		visbility(driver, manageuser, 60);
		manageuser.click();
		WebElement adduser = driver.findElement(By.xpath("//button[@onclick='Health.user_new()']"));
		visbility(driver, adduser, 60);
		adduser.click();
		sleep(2000);
		WebElement trp14 = driver.findElement(By.xpath("//input[@id='Firstname']"));
		visbility(driver, trp14, 60);
		sendkeys(trp14, Sub_Manager.getInstanecSubManager().getInstanceSubReader().firstname());
		WebElement trp15 = driver.findElement(By.xpath("//input[@id='LastName']"));
		visbility(driver, trp15, 60);
		sendkeys(trp15, Sub_Manager.getInstanecSubManager().getInstanceSubReader().lastname());
		sleep(2000);
		WebElement trp16 = driver.findElement(By.xpath("//input[@id='UserLoginId']"));
		visbility(driver, trp16, 60);
		sendkeys(trp16, Sub_Manager.getInstanecSubManager().getInstanceSubReader().$bas$usmail());
		// .sendKeys("Akashn1212@gmail.com");
		sleep(2000);
		WebElement trp17 = driver.findElement(By.xpath("//button[@id='user_dropdown']"));
		visbility(driver, trp17, 60);
		click(trp17);// .click();
		List<WebElement> usserdrp = driver.findElements(By.xpath("//button[@id='user_dropdown']//following::ul[1]/li"));
		for (WebElement web : usserdrp) {
			if (web.getText().trim().equals("Standard User")) {
				visbility(driver, web, 60);
				web.click();
				break;
			}

		}
		sleep(2000);

		WebElement createuser = driver.findElement(By.xpath("(//button[@id='createButton'])[2]"));
		visbility(driver, createuser, 60);

		WebElement canceluser = driver.findElement(By.xpath("(//button[@onclick='window.history.back()'])[2]"));
		visbility(driver, canceluser, 60);
		// canceluser.click(); //
		createuser.click();
		WebElement user_dr = driver.findElement(By.xpath("(//td[@id='val-kdid'])[2]"));
		visbility(driver, user_dr, 60);
		$userKp = user_dr.getText();
		// System.out.println(id);

	}

	@Test(priority = 7)
	private void basicManageSubscription$$() throws InterruptedException, IOException {

		visbility(driver, pom.getInstanceSetting().clickSettings, 60);
		javascriptclick(pom.getInstanceSetting().clickSettings);

		visbility(driver, pom.getInstanceSetting().$activeuser$, 60);
		click(pom.getInstanceSetting().$activeuser$);

		WebElement $upgradeplnui$ = driver.findElement(By.xpath("(//span[@id='manage-sub-text'])[1]/a/img"));
		visbility(driver, $upgradeplnui$, 60);
		actions("click", $upgradeplnui$);
		System.out.println("link clicked");
		sleep(2000);

		WebElement $editusers$ = driver.findElement(By.xpath("//button[@id='edit-user-btn']"));
		visbility(driver, $editusers$, 60);
		javascriptclick($editusers$);
		System.out.println("edit user clicked");
		sleep(2000);

		WebElement $createusericon$ = driver.findElement(By.xpath("//div[@id='add-new-user']/i"));
		visbility(driver, $createusericon$, 60);
		click($createusericon$);

		// create a user from manage subscription..

		WebElement trp14 = driver.findElement(By.xpath("//input[@id='Firstname']"));
		visbility(driver, trp14, 60);
		sendkeys(trp14, Sub_Manager.getInstanecSubManager().getInstanceSubReader().firstname());
		WebElement trp15 = driver.findElement(By.xpath("//input[@id='LastName']"));
		visbility(driver, trp15, 60);
		sendkeys(trp15, Sub_Manager.getInstanecSubManager().getInstanceSubReader().lastname());
		sleep(2000);
		WebElement trp16 = driver.findElement(By.xpath("//input[@id='UserLoginId']"));
		visbility(driver, trp16, 60);
		sendkeys(trp16, Sub_Manager.getInstanecSubManager().getInstanceSubReader().$bas$drmail());
		// .sendKeys("Akashn1212@gmail.com");
		sleep(2000);
		WebElement trp17 = driver.findElement(By.xpath("//button[@id='user_dropdown']"));
		visbility(driver, trp17, 60);
		click(trp17);
		// .click();
		List<WebElement> usserdrp = driver.findElements(By.xpath("//button[@id='user_dropdown']//following::ul[1]/li"));
		for (WebElement web : usserdrp) {
			if (web.getText().trim().equals("Standard User")) {
				visbility(driver, web, 60);
				web.click();
				break;
			}

		}
		sleep(2000);

		WebElement createuser = driver.findElement(By.xpath("(//button[@id='createButton'])[2]"));
		visbility(driver, createuser, 60);

		WebElement canceluser = driver.findElement(By.xpath("(//button[@onclick='window.history.back()'])[2]"));
		visbility(driver, canceluser, 60);
		// canceluser.click(); //
		createuser.click();
		WebElement user_dr = driver.findElement(By.xpath("(//td[@id='val-kdid'])[2]"));
		visbility(driver, user_dr, 60);
		$drKp = user_dr.getText();

		WebElement $drgm = driver
				.findElement(By.xpath("(//span[text()='Basic Information'])[4]/following::table[1]/tbody/tr[2]/td[3]"));
		$gm = $drgm.getText();
		System.out.println($gm);

	}

	@Test(priority = 8)
	private void activeuserAndPayement$bas$() throws InterruptedException {
		driver.navigate().to("https://localhost:8443/health/#allPaymentHistory");
		sleep(5000);
		driver.navigate().to("https://localhost:8443/health/#allSubscriptionActiveUsers");
		sleep(2000);

	}

	@Test(priority = 9)
	private void activateDeactivateuser$bas$() throws InterruptedException, IOException {

		String $user = $userKp.replace("-", "");
		// System.out.println($user);

		for (int i = 1; i <= 5; i++) {
			try {
				WebElement ids = driver.findElement(By.xpath("//div[text()='" + $user + "']"));

				actions("move to element", ids);
				// System.out.println("moved to element:" + ids);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		WebElement userdcact = driver.findElement(By.xpath("//div[text()='" + $user + "']//following::span[3]"));
		// System.out.println(userdcact);

		for (int i = 1; i <= 5; i++) {
			try {
				visbility(driver, userdcact, 60);
				actions("click", userdcact);
				//
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		List<WebElement> cnclacdrp = driver
				.findElements(By.xpath("//div[text()='" + $user + "']//following::span[3]//following::ul[1]/li"));
		for (WebElement web : cnclacdrp) {

			if (web.getText().trim().equals("Cancel Subscription")) {

				visbility(driver, web, 60);
				web.click();

				break;
			}

		}

		sleep(2500);
		// activate the same user..
		WebElement $deacusericon = driver.findElement(By.xpath("//div[@id='menu-deactivated-user']"));
		visbility(driver, $deacusericon, 60);
		actions("click", $deacusericon);
		sleep(2000);

		WebElement $deusrmv = driver.findElement(By.xpath("//div[text()='" + $user + "']"));

		actions("move to element", $deusrmv);

		for (int i = 1; i <= 5; i++) {
			try {

				WebElement $dcacElipse = driver
						.findElement(By.xpath("//div[text()='" + $user + "']//following::span[3]"));
				actions("move to element", $dcacElipse);

				visbility(driver, $dcacElipse, 60);
				actions("click", $dcacElipse);

				break;
			} catch (Exception e) {
				System.out.println(e);
			}
		}

		List<WebElement> $dcacelipsedrp = driver
				.findElements(By.xpath("//div[text()='" + $user + "']//following::span[3]//following::ul[1]/li/a"));
		for (WebElement web : $dcacelipsedrp) {
			if (web.getText().trim().equals("Activate Subscription")) {
				click(web);

				break;
			}

		}
		// verify userto act with pass..

		WebElement $verifypasstoact = driver.findElement(By.xpath("//input[@id='userPasswordEir-1']"));
		visbility(driver, $verifypasstoact, 60);
		sendkeys($verifypasstoact, ConfigManager.getconfigManager().getInstanceConfigReader().getpass());

		WebElement $submitpass = driver.findElement(By.xpath("//input[@id='userPasswordEir-1']//following::button[2]"));
		visbility(driver, $submitpass, 60);
		click($submitpass);
		sleep(5000);

		//

		for (int i = 1; i <= 5; i++) {
			try {
				WebElement ids = driver.findElement(By.xpath("//div[text()='" + $user + "']"));

				actions("move to element", ids);

				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		WebElement userdcact1 = driver.findElement(By.xpath("//div[text()='" + $user + "']//following::span[3]"));
		System.out.println(userdcact1);

		for (int i = 1; i <= 5; i++) {
			try {
				visbility(driver, userdcact1, 60);
				actions("click", userdcact1);

				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		List<WebElement> cnclacdrp1 = driver
				.findElements(By.xpath("//div[text()='" + $user + "']//following::span[3]//following::ul[1]/li"));
		for (WebElement web : cnclacdrp1) {

			if (web.getText().trim().equals("Cancel Subscription")) {

				visbility(driver, web, 60);
				web.click();

				break;
			}
		}
	}

	@Test(priority = 10)
	private void upgradepln$bas() throws InterruptedException, AWTException {

		WebElement $upgradeplnui$ = driver.findElement(By.xpath("(//span[@id='manage-sub-text'])[1]/a/img"));
		visbility(driver, $upgradeplnui$, 60);
		javascriptclick($upgradeplnui$);

		sleep(5000);

		WebElement $editusers$ = driver.findElement(By.xpath("//button[@id='edit-user-btn']"));
		visbility(driver, $editusers$, 60);
		javascriptclick($editusers$);

		sleep(2000);

		WebElement $removeusermovescn$ = driver.findElement(By.xpath("//div[text()='" + $gm + "']"));

		while (true) {
			if ($removeusermovescn$.isDisplayed()) {
				break;
			}
		}

		try {
			visbility(driver, $removeusermovescn$, 60);

			actions("move to element", $removeusermovescn$);

		} catch (Exception e) { // TODO: handle exception

		}
		sleep(2000);

		WebElement $removeuserfrmedituser$ = driver
				.findElement(By.xpath("//div[text()='" + $gm + "']//following::div[2]"));

		visbility(driver, $removeuserfrmedituser$, 60);

		actions("click", $removeuserfrmedituser$);

		WebElement $addMoreuser = driver.findElement(By.xpath("(//button[@title='Add More Premium users'])[2]"));
		visbility(driver, $addMoreuser, 60);
		javascriptclick($addMoreuser);

		WebElement $usertxtbx = driver.findElement(By.xpath("//input[@id='userPartySearch0']"));
		visbility(driver, $usertxtbx, 60);
		sendkeys($usertxtbx, $userKp);
		sleep(3000);
		keypress();
		keyenter();

		WebElement $proceedpay$lte = driver.findElement(By.xpath("(//button[text()='Proceed Payment'])[3]"));
		visbility(driver, $proceedpay$lte, 60);
		javascriptclick($proceedpay$lte);
		sleep(2500);

	}

	@Test(priority = 11)
	private void paymentAndCrdDetails$() throws InterruptedException {
		for (int i = 1; i <= 5; i++) {
			try {
				WebElement basicsub = driver.findElement(By.xpath("//span[text()='$ 55']"));
				actions("move to element", basicsub);
				visbility(driver, basicsub, 60);
				javascriptclick(basicsub);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		sleep(4000);

		driver.findElement(By.id("update_basic_btn")).click();

		while (true) {
			try {
				WebElement $returnhmpage$ = driver
						.findElement(By.xpath("//a[text()='Click here to return to the login Page']"));

				if ($returnhmpage$.isDisplayed()) {

					javascriptclick($returnhmpage$);
					break;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}

		}

	}

	// $$$$$$$$$premium$$$$$$$$$//

	@Test(priority = 12)
	private void $manageuser$premium() throws IOException, InterruptedException {

		visbility(driver, pom.getInstanceSetting().clickSettings, 60);
		javascriptclick(pom.getInstanceSetting().clickSettings);

		WebElement manageuser = driver.findElement(By.xpath("//button[@onclick='setting.userList()']"));
		visbility(driver, manageuser, 60);
		manageuser.click();
		WebElement adduser = driver.findElement(By.xpath("//button[@onclick='Health.user_new()']"));
		visbility(driver, adduser, 60);
		adduser.click();
		sleep(2000);
		WebElement trp14 = driver.findElement(By.xpath("//input[@id='Firstname']"));
		visbility(driver, trp14, 60);
		sendkeys(trp14, Sub_Manager.getInstanecSubManager().getInstanceSubReader().firstname());
		WebElement trp15 = driver.findElement(By.xpath("//input[@id='LastName']"));
		visbility(driver, trp15, 60);
		sendkeys(trp15, Sub_Manager.getInstanecSubManager().getInstanceSubReader().lastname());
		sleep(2000);
		WebElement trp16 = driver.findElement(By.xpath("//input[@id='UserLoginId']"));
		visbility(driver, trp16, 60);
		sendkeys(trp16, Sub_Manager.getInstanecSubManager().getInstanceSubReader().$pre$usmail());
		// .sendKeys("Akashn1212@gmail.com");
		sleep(2000);
		WebElement trp17 = driver.findElement(By.xpath("//button[@id='user_dropdown']"));
		visbility(driver, trp17, 60);
		click(trp17);// .click();
		List<WebElement> usserdrp = driver.findElements(By.xpath("//button[@id='user_dropdown']//following::ul[1]/li"));
		for (WebElement web : usserdrp) {
			if (web.getText().trim().equals("Standard User")) {
				visbility(driver, web, 60);
				web.click();
				break;
			}

		}
		sleep(2000);

		WebElement createuser = driver.findElement(By.xpath("(//button[@id='createButton'])[2]"));
		visbility(driver, createuser, 60);

		WebElement canceluser = driver.findElement(By.xpath("(//button[@onclick='window.history.back()'])[2]"));
		visbility(driver, canceluser, 60);
		// canceluser.click(); //
		createuser.click();
		WebElement user_dr = driver.findElement(By.xpath("(//td[@id='val-kdid'])[2]"));
		visbility(driver, user_dr, 60);
		$userKp = user_dr.getText();
		// System.out.println(id);

	}

	@Test(priority = 13)
	private void $premiumManageSubscription() throws InterruptedException, IOException {

		visbility(driver, pom.getInstanceSetting().clickSettings, 60);
		javascriptclick(pom.getInstanceSetting().clickSettings);

		WebElement $manageSubscription$ = driver.findElement(By.xpath("//button[text()='Manage Subscription']"));
		visbility(driver, $manageSubscription$, 60);
		javascriptclick($manageSubscription$);

		WebElement $createusericon$ = driver.findElement(By.xpath("//div[@id='add-new-user']/i"));
		visbility(driver, $createusericon$, 60);
		click($createusericon$);

		// create a user from manage subscription..

		WebElement trp14 = driver.findElement(By.xpath("//input[@id='Firstname']"));
		visbility(driver, trp14, 60);
		sendkeys(trp14, Sub_Manager.getInstanecSubManager().getInstanceSubReader().firstname());
		WebElement trp15 = driver.findElement(By.xpath("//input[@id='LastName']"));
		visbility(driver, trp15, 60);
		sendkeys(trp15, Sub_Manager.getInstanecSubManager().getInstanceSubReader().lastname());
		sleep(2000);
		WebElement trp16 = driver.findElement(By.xpath("//input[@id='UserLoginId']"));
		visbility(driver, trp16, 60);
		sendkeys(trp16, Sub_Manager.getInstanecSubManager().getInstanceSubReader().$pre$drmail());
		// .sendKeys("Akashn1212@gmail.com");
		sleep(2000);
		WebElement trp17 = driver.findElement(By.xpath("//button[@id='user_dropdown']"));
		visbility(driver, trp17, 60);
		click(trp17);
		// .click();
		List<WebElement> usserdrp = driver.findElements(By.xpath("//button[@id='user_dropdown']//following::ul[1]/li"));
		for (WebElement web : usserdrp) {
			if (web.getText().trim().equals("Standard User")) {
				visbility(driver, web, 60);
				web.click();
				break;
			}

		}
		sleep(2000);

		WebElement createuser = driver.findElement(By.xpath("(//button[@id='createButton'])[2]"));
		visbility(driver, createuser, 60);

		WebElement canceluser = driver.findElement(By.xpath("(//button[@onclick='window.history.back()'])[2]"));
		visbility(driver, canceluser, 60);
		// canceluser.click(); //
		createuser.click();
		WebElement user_dr = driver.findElement(By.xpath("(//td[@id='val-kdid'])[2]"));
		visbility(driver, user_dr, 60);
		$drKp = user_dr.getText();

		WebElement $drgm = driver
				.findElement(By.xpath("(//span[text()='Basic Information'])[4]/following::table[1]/tbody/tr[2]/td[3]"));
		$gm = $drgm.getText();
		System.out.println($gm);

	}

	@Test(priority = 14)
	private void activeuserAndPayement$premium$() throws InterruptedException {
		driver.navigate().to("https://localhost:8443/health/#allPaymentHistory");
		sleep(5000);
		driver.navigate().to("https://localhost:8443/health/#allSubscriptionActiveUsers");
		sleep(2000);

	}

	String $preplsdc;

	@Test(priority = 15)
	private void activateDeactivateuser$premium$() throws InterruptedException, IOException {

		String $user = $userKp.replace("-", "");
		System.out.println($user);
		$preplsdc = $user;

		for (int i = 1; i <= 5; i++) {
			try {
				WebElement ids = driver.findElement(By.xpath("//div[text()='" + $user + "']"));

				actions("move to element", ids);

				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		WebElement userdcact = driver.findElement(By.xpath("//div[text()='" + $user + "']//following::span[3]"));
		System.out.println(userdcact);

		for (int i = 1; i <= 5; i++) {
			try {
				visbility(driver, userdcact, 60);
				actions("click", userdcact);

				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		List<WebElement> cnclacdrp = driver
				.findElements(By.xpath("//div[text()='" + $user + "']//following::span[3]//following::ul[1]/li"));
		for (WebElement web : cnclacdrp) {

			if (web.getText().trim().equals("Cancel Subscription")) {

				visbility(driver, web, 60);
				web.click();

				break;
			}

		}

		sleep(2500);
		// activate the same user..
		WebElement $deacusericon = driver.findElement(By.xpath("//div[@id='menu-deactivated-user']"));
		visbility(driver, $deacusericon, 60);
		actions("click", $deacusericon);
		sleep(2000);

		WebElement $deusrmv = driver.findElement(By.xpath("//div[text()='" + $user + "']"));

		actions("move to element", $deusrmv);

		for (int i = 1; i <= 5; i++) {
			try {

				WebElement $dcacElipse = driver
						.findElement(By.xpath("//div[text()='" + $user + "']//following::span[3]"));
				actions("move to element", $dcacElipse);

				visbility(driver, $dcacElipse, 60);
				actions("click", $dcacElipse);

				break;
			} catch (Exception e) {
				System.out.println(e);
			}
		}

		List<WebElement> $dcacelipsedrp = driver
				.findElements(By.xpath("//div[text()='" + $user + "']//following::span[3]//following::ul[1]/li/a"));
		for (WebElement web : $dcacelipsedrp) {
			if (web.getText().trim().equals("Activate Subscription")) {
				click(web);

				break;
			}

		}
		// verify userto act with pass..

		WebElement $verifypasstoact = driver.findElement(By.xpath("//input[@id='userPasswordEir-1']"));
		visbility(driver, $verifypasstoact, 60);
		sendkeys($verifypasstoact, ConfigManager.getconfigManager().getInstanceConfigReader().getpass());

		WebElement $submitpass = driver.findElement(By.xpath("//input[@id='userPasswordEir-1']//following::button[2]"));
		visbility(driver, $submitpass, 60);
		click($submitpass);
		sleep(5000);

		//

		for (int i = 1; i <= 5; i++) {
			try {
				WebElement ids = driver.findElement(By.xpath("//div[text()='" + $user + "']"));

				actions("move to element", ids);

				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		WebElement userdcact1 = driver.findElement(By.xpath("//div[text()='" + $user + "']//following::span[3]"));
		System.out.println(userdcact1);

		for (int i = 1; i <= 5; i++) {
			try {
				visbility(driver, userdcact1, 60);
				actions("click", userdcact1);

				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		List<WebElement> cnclacdrp1 = driver
				.findElements(By.xpath("//div[text()='" + $user + "']//following::span[3]//following::ul[1]/li"));
		for (WebElement web : cnclacdrp1) {

			if (web.getText().trim().equals("Cancel Subscription")) {

				visbility(driver, web, 60);
				web.click();

				break;
			}
		}
		sleep(4000);
	}

	@Test(priority = 16)
	private void upgradepln$premium79() throws InterruptedException, AWTException {

		visbility(driver, pom.getInstanceSetting().clickSettings, 60);
		javascriptclick(pom.getInstanceSetting().clickSettings);

		WebElement $marketplace = driver.findElement(By.xpath("//button[text()='Market Place']"));
		javascriptclick($marketplace);
		visbility(driver, pom.getInstanceSetting().$eirsystembutton$, 60);
		javascriptclick(pom.getInstanceSetting().$eirsystembutton$);

		visbility(driver, pom.getInstanceSetting().$upgradenowineir$, 60);
		javascriptclick(pom.getInstanceSetting().$upgradenowineir$);

		WebElement $editusers$ = driver.findElement(By.xpath("//button[@id='edit-user-btn']"));
		visbility(driver, $editusers$, 60);
		javascriptclick($editusers$);

		sleep(2000);

		WebElement $removeusermovescn$ = driver.findElement(By.xpath("//div[text()='" + $gm + "']"));

		while (true) {
			if ($removeusermovescn$.isDisplayed()) {
				break;
			}
		}

		try {
			visbility(driver, $removeusermovescn$, 60);

			actions("move to element", $removeusermovescn$);

		} catch (Exception e) { // TODO: handle exception

		}
		sleep(2000);

		WebElement $removeuserfrmedituser$ = driver
				.findElement(By.xpath("//div[text()='" + $gm + "']//following::div[2]"));

		visbility(driver, $removeuserfrmedituser$, 60);

		actions("click", $removeuserfrmedituser$);

		WebElement $addMoreuser = driver.findElement(By.xpath("(//button[@title='Add More Premium users'])[2]"));
		visbility(driver, $addMoreuser, 60);
		javascriptclick($addMoreuser);

		WebElement $usertxtbx = driver.findElement(By.xpath("//input[@id='userPartySearch0']"));
		visbility(driver, $usertxtbx, 60);
		sendkeys($usertxtbx, $userKp);
		sleep(3000);
		keypress();
		keyenter();

		WebElement $proceedpay$lte = driver.findElement(By.xpath("(//button[text()='Proceed Payment'])[3]"));
		visbility(driver, $proceedpay$lte, 60);
		javascriptclick($proceedpay$lte);
		sleep(2500);

		driver.findElement(By.id("update-subscription-btn")).click();

		while (true) {

			try {
				WebElement $finishpln = driver.findElement(By.xpath("//span[text()='Finish']"));

				if ($finishpln.isDisplayed()) {
					javascriptclick($finishpln);
					break;

				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}

////////$$$$$$$$$$$$$$premium$79....????/////////////

	@Test(priority = 17)
	private void $manageuser$premium79() throws IOException, InterruptedException {

		visbility(driver, pom.getInstanceSetting().clickSettings, 60);
		javascriptclick(pom.getInstanceSetting().clickSettings);

		WebElement manageuser = driver.findElement(By.xpath("//button[@onclick='setting.userList()']"));
		visbility(driver, manageuser, 60);
		manageuser.click();
		WebElement adduser = driver.findElement(By.xpath("//button[@onclick='Health.user_new()']"));
		visbility(driver, adduser, 60);
		adduser.click();
		sleep(2000);
		WebElement trp14 = driver.findElement(By.xpath("//input[@id='Firstname']"));
		visbility(driver, trp14, 60);
		sendkeys(trp14, Sub_Manager.getInstanecSubManager().getInstanceSubReader().firstname());
		WebElement trp15 = driver.findElement(By.xpath("//input[@id='LastName']"));
		visbility(driver, trp15, 60);
		sendkeys(trp15, Sub_Manager.getInstanecSubManager().getInstanceSubReader().lastname());
		sleep(2000);
		WebElement trp16 = driver.findElement(By.xpath("//input[@id='UserLoginId']"));
		visbility(driver, trp16, 60);
		sendkeys(trp16, Sub_Manager.getInstanecSubManager().getInstanceSubReader().$prepls$usmail());
		// .sendKeys("Akashn1212@gmail.com");
		sleep(2000);
		WebElement trp17 = driver.findElement(By.xpath("//button[@id='user_dropdown']"));
		visbility(driver, trp17, 60);
		click(trp17);// .click();
		List<WebElement> usserdrp = driver.findElements(By.xpath("//button[@id='user_dropdown']//following::ul[1]/li"));
		for (WebElement web : usserdrp) {
			if (web.getText().trim().equals("Standard User")) {
				visbility(driver, web, 60);
				web.click();
				break;
			}

		}
		sleep(2000);

		WebElement createuser = driver.findElement(By.xpath("(//button[@id='createButton'])[2]"));
		visbility(driver, createuser, 60);

		WebElement canceluser = driver.findElement(By.xpath("(//button[@onclick='window.history.back()'])[2]"));
		visbility(driver, canceluser, 60);
		// canceluser.click(); //
		createuser.click();
		WebElement user_dr = driver.findElement(By.xpath("(//td[@id='val-kdid'])[2]"));
		visbility(driver, user_dr, 60);
		$userKp = user_dr.getText();
		// System.out.println(id);

	}

	@Test(priority = 18)
	private void $premiumManageSubscription79() throws InterruptedException, IOException {

		visbility(driver, pom.getInstanceSetting().clickSettings, 60);
		javascriptclick(pom.getInstanceSetting().clickSettings);

		WebElement $manageSubscription$ = driver.findElement(By.xpath("//button[text()='Manage Subscription']"));
		visbility(driver, $manageSubscription$, 60);
		javascriptclick($manageSubscription$);

		WebElement $createusericon$ = driver.findElement(By.xpath("//div[@id='add-new-user']/i"));
		visbility(driver, $createusericon$, 60);
		click($createusericon$);

		// create a user from manage subscription..

		WebElement trp14 = driver.findElement(By.xpath("//input[@id='Firstname']"));
		visbility(driver, trp14, 60);
		sendkeys(trp14, Sub_Manager.getInstanecSubManager().getInstanceSubReader().firstname());
		WebElement trp15 = driver.findElement(By.xpath("//input[@id='LastName']"));
		visbility(driver, trp15, 60);
		sendkeys(trp15, Sub_Manager.getInstanecSubManager().getInstanceSubReader().lastname());
		sleep(2000);
		WebElement trp16 = driver.findElement(By.xpath("//input[@id='UserLoginId']"));
		visbility(driver, trp16, 60);
		sendkeys(trp16, Sub_Manager.getInstanecSubManager().getInstanceSubReader().$prepls$drmail());
		// .sendKeys("Akashn1212@gmail.com");
		sleep(2000);
		WebElement trp17 = driver.findElement(By.xpath("//button[@id='user_dropdown']"));
		visbility(driver, trp17, 60);
		click(trp17);
		// .click();
		List<WebElement> usserdrp = driver.findElements(By.xpath("//button[@id='user_dropdown']//following::ul[1]/li"));
		for (WebElement web : usserdrp) {
			if (web.getText().trim().equals("Standard User")) {
				visbility(driver, web, 60);
				web.click();
				break;
			}

		}
		sleep(2000);

		WebElement createuser = driver.findElement(By.xpath("(//button[@id='createButton'])[2]"));
		visbility(driver, createuser, 60);

		WebElement canceluser = driver.findElement(By.xpath("(//button[@onclick='window.history.back()'])[2]"));
		visbility(driver, canceluser, 60);
		// canceluser.click(); //
		createuser.click();
		WebElement user_dr = driver.findElement(By.xpath("(//td[@id='val-kdid'])[2]"));
		visbility(driver, user_dr, 60);
		$drKp = user_dr.getText();

		WebElement $drgm = driver
				.findElement(By.xpath("(//span[text()='Basic Information'])[4]/following::table[1]/tbody/tr[2]/td[3]"));
		$gm = $drgm.getText();
		System.out.println($gm);

	}

	@Test(priority = 19)
	private void activeuserAndPayement$premium79$() throws InterruptedException {
		driver.navigate().to("https://localhost:8443/health/#allPaymentHistory");
		sleep(5000);
		driver.navigate().to("https://localhost:8443/health/#allSubscriptionActiveUsers");
		sleep(4000);

	}

	@Test(priority = 20)
	private void activateDeactivateuser$79() throws InterruptedException, IOException {

		String $user = $userKp.replace("-", "");
		System.out.println($user);

		for (int i = 1; i <= 5; i++) {
			try {
				WebElement ids = driver.findElement(By.xpath("//div[text()='" + $user + "']"));

				actions("move to element", ids);

				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		WebElement userdcact = driver.findElement(By.xpath("//div[text()='" + $user + "']//following::span[3]"));
		System.out.println(userdcact);

		for (int i = 1; i <= 5; i++) {
			try {
				visbility(driver, userdcact, 60);
				actions("click", userdcact);

				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		List<WebElement> cnclacdrp = driver
				.findElements(By.xpath("//div[text()='" + $user + "']//following::span[3]//following::ul[1]/li"));
		for (WebElement web : cnclacdrp) {

			if (web.getText().trim().equals("Cancel Subscription")) {

				visbility(driver, web, 60);
				web.click();

				break;
			}

		}

		sleep(2500);
		// activate the same user..
		WebElement $deacusericon = driver.findElement(By.xpath("//div[@id='menu-deactivated-user']"));
		visbility(driver, $deacusericon, 60);
		actions("click", $deacusericon);
		sleep(2000);

		WebElement $deusrmv = driver.findElement(By.xpath("//div[text()='" + $user + "']"));

		actions("move to element", $deusrmv);

		for (int i = 1; i <= 5; i++) {
			try {

				WebElement $dcacElipse = driver
						.findElement(By.xpath("//div[text()='" + $user + "']//following::span[3]"));
				actions("move to element", $dcacElipse);

				visbility(driver, $dcacElipse, 60);
				actions("click", $dcacElipse);

				break;
			} catch (Exception e) {
				System.out.println(e);
			}
		}

		List<WebElement> $dcacelipsedrp = driver
				.findElements(By.xpath("//div[text()='" + $user + "']//following::span[3]//following::ul[1]/li/a"));
		for (WebElement web : $dcacelipsedrp) {
			if (web.getText().trim().equals("Activate Subscription")) {
				click(web);

				break;
			}

		}
		// verify userto act with pass..

		WebElement $verifypasstoact = driver.findElement(By.xpath("//input[@id='userPasswordEir-1']"));
		visbility(driver, $verifypasstoact, 60);
		sendkeys($verifypasstoact, ConfigManager.getconfigManager().getInstanceConfigReader().getpass());

		WebElement $submitpass = driver.findElement(By.xpath("//input[@id='userPasswordEir-1']//following::button[2]"));
		visbility(driver, $submitpass, 60);
		click($submitpass);
		sleep(5000);

		//

		for (int i = 1; i <= 5; i++) {
			try {
				WebElement ids = driver.findElement(By.xpath("//div[text()='" + $user + "']"));

				actions("move to element", ids);

				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		WebElement userdcact1 = driver.findElement(By.xpath("//div[text()='" + $user + "']//following::span[3]"));
		System.out.println(userdcact1);

		for (int i = 1; i <= 5; i++) {
			try {
				visbility(driver, userdcact1, 60);
				actions("click", userdcact1);

				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		List<WebElement> cnclacdrp1 = driver
				.findElements(By.xpath("//div[text()='" + $user + "']//following::span[3]//following::ul[1]/li"));
		for (WebElement web : cnclacdrp1) {

			if (web.getText().trim().equals("Cancel Subscription")) {

				visbility(driver, web, 60);
				web.click();

				break;
			}
		}
		sleep(4000);

	}

	@Test(priority = 21)
	private void lst() throws InterruptedException, AWTException {

		visbility(driver, pom.getInstanceSetting().clickSettings, 60);
		javascriptclick(pom.getInstanceSetting().clickSettings);

		while (true) {
			try {
				WebElement $manageSubscription$ = driver
						.findElement(By.xpath("//button[text()='Manage Subscription']"));

				javascriptclick($manageSubscription$);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		WebElement $addMoreuser = driver.findElement(By.xpath("(//button[@title='Add More Premium users'])[2]"));
		visbility(driver, $addMoreuser, 60);
		System.out.println("done...");
		javascriptclick($addMoreuser);

		WebElement $usertxtbx = driver.findElement(By.xpath("//input[@id='userPartySearch0']"));
		visbility(driver, $usertxtbx, 60);
		sendkeys($usertxtbx,$preplsdc);
		sleep(3000);
		keypress();
		keyenter();

	}
}
