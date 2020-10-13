/*
 * Classe ReportIssueActionChrome responsável pelas ações do Chrome na tela <<bug_report_page.php>>
 * realizadas com execução do browser 
 * Essa classe pode ser executada pelo TestNG tanto pelo próprio arquivo quando pelo testng_mantis.xml
 */

package br.com.mantisprova.base2.chrome;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.io.File;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * @version 1.0
 * @author Miécio Santos Costa
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class E2eReportIssueAction {

	//path do chromedriver localizado na máquina
	@BeforeClass
	public static void start() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", File.separator + "home" + File.separator + "miecio"
				+ File.separator + "Documentos" + File.separator +"GitHub" + File.separator + "base2mieciocosta"+ File.separator +"base2mieciocosta"+ File.separator + "jars"+ File.separator + "chromedriver");
	}
	
	//Chamada do teste a ser execucado
	@Test(invocationCount = 1)
	public void inserirReportIssue() throws InterruptedException {

		//Definindo o capabilities do chrome a ser executado
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.addArguments("disable-infobars");
		WebDriver driver = new ChromeDriver(options);
		
		//chamada do método <<login>> da classe <<LoginAction>>
		br.com.mantisprova.base2.utils.LoginAction.login(driver);
		driver.get("https://mantis-prova.base2.com.br/bug_report_page.php");

		// Chama método que preenche os campos de combos aleatoriamente
		br.com.mantisprova.base2.utils.SelecionaCombos.selecionaItemCombos(driver);

		// Preenche campos
		driver.findElement(By.name("summary")).sendKeys("[E2E_CR_03] - Teste campo Sumário");
		driver.findElement(By.name("description")).sendKeys("[SRC_CR] - Teste campo Descrição");
		driver.findElement(By.name("steps_to_reproduce")).sendKeys("[SRC_CR] - Teste campo passos para reprodução");
		driver.findElement(By.name("additional_info")).sendKeys("[SRC_CR] - Teste campo informações adicionais");

		// Click botão submit
		driver.findElement(By.cssSelector("body > div:nth-child(6) > form > table > tbody > tr:nth-child(15) > td.center > input")).click();
		
		// Fecha a janela do navegador
		driver.quit();

	}

}
