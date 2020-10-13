/*
 * Classe LoginActionBackEnd responsável pelas ações do login do usuário no sistema mantis
 * realizadas sem necessidade de execução do browser 
 * Essa classe pode ser executada pelo TestNG tanto pelo próprio arquivo quando pelo testng_mantis.xml
 */
package br.com.mantisprova.base2.chrome;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * @version 1.0
 * @author Miécio Santos Costa
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginActionChrome {

	// path do chromedriver localizado na máquina
	@BeforeClass
	public static void startCr() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				File.separator + "home" + File.separator + "miecio" + File.separator + "eclipse-workspace"
						+ File.separator + "AutoMantis" + File.separator + "jars" + File.separator + "chromedriver");
	}

	// Chamada do teste a ser execucado pelo Chrome
	@Test(invocationCount = 1)
	public void loginChromeBackEnd() throws MalformedURLException, InterruptedException {

		DesiredCapabilities crm = new DesiredCapabilities();
		crm.setBrowserName(BrowserType.CHROME);

		// chamada da url do seleniumgrid
		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), crm);
		Thread.sleep(2000);

		// chamada do método <<login>> da classe <<LoginAction>>
		br.com.mantisprova.base2.utils.LoginAction.login(driver);

	}
}
