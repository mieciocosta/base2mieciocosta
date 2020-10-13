/*
 * Classe ReportIssueActionFF responsável pelas ações do Firefox na tela <<bug_report_page.php>>
 * realizadas sem necessidade de execução do browser 
 * Essa classe pode ser executada pelo TestNG tanto pelo próprio arquivo quando pelo testng_mantis.xml
 */

package br.com.mantisprova.base2.firefox;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.net.URL;
import java.io.File;
import java.net.MalformedURLException;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * @version 1.0
 * @author Miécio Santos Costa
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ReportIssueActionTest {

	// path do geckodriver localizado na máquina
	@BeforeClass
	public static void start() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", File.separator + "home" + File.separator + "miecio"
				+ File.separator + "eclipse-workspace" + File.separator +"AutoMantis" + File.separator + "jars"+ File.separator + "geckodriver");
	}
	
	// Chamada do teste a ser execucado
	@Test(invocationCount = 1)
	public void inserirReportIssueFF() throws MalformedURLException, InterruptedException {

		DesiredCapabilities ff=new DesiredCapabilities();
		ff.setBrowserName(BrowserType.FIREFOX);
		
		// chamada da url do seleniumgrid
		WebDriver driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), ff);
		Thread.sleep(2000);
		
		// chamada do método <<login>> da classe <<LoginAction>>
		br.com.mantisprova.base2.utils.LoginAction.login(driver);
		driver.get("https://mantis-prova.base2.com.br/bug_report_page.php");

		// Chama método que preenche os campos de combos aleatoriamente
		br.com.mantisprova.base2.utils.SelecionaCombos.selecionaItemCombos(driver);

		// Preenche campos
		driver.findElement(By.name("summary")).sendKeys("[BE_FF_09] - Teste campo Sumário");
		driver.findElement(By.name("description")).sendKeys("[SRC_FF_3] - Teste campo Descrição");
		driver.findElement(By.name("steps_to_reproduce")).sendKeys("[SRC_FF_3] - Teste campo passos para reprodução");
		driver.findElement(By.name("additional_info")).sendKeys("[SRC_FF_3] - Teste campo informações adicionais");

		// Click botão submit
		driver.findElement(By.cssSelector("body > div:nth-child(6) > form > table > tbody > tr:nth-child(15) > td.center > input")).click();

	}

}
