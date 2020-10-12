/*
* Classe VerificaProjeto tem o intuito de "exugar" os códigos que necessitam
*  estar selecionado um projeto específico da tela após o login
*  podendo ser reutilizada chamando a mesma.
*/

package br.com.mantisprova.base2.utils;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class VerificaProjeto {

	// Chamada do teste a ser execucado
	@Test
	public static void verificaProjeto(WebDriver driver) {
		
		//Seleciona um projeto específco na combo
		Select comboProjeto = new Select(driver.findElement(By.name("project_id")));
		comboProjeto.selectByValue("200");
		
		// Click no botão <<Swith>>
		driver.findElement(By.cssSelector("body > table.hide > tbody > tr > td.login-info-right > form > input"))
				.click();
	}
}
