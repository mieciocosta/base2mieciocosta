/*
 * Classe LoginAction responsável pelas ações do login do usuário no sistema mantis
 * essa classe é reutilizada por outras classes no projeto.
 */

package br.com.mantisprova.base2.login;

import java.util.concurrent.TimeUnit;
import org.apache.commons.codec.binary.Base64;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @version 1.0
 * @author Miécio Santos Costa
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginActionE2e {

	/*
	 * Criada string para decodificação da senha do usuário. Mais informações em:
	 * br.com.mantisprova.base2.utils.PasswordEnconding.java
	 */
	public static String decodePassword(String passWord) {

		byte[] decodePassword = Base64.decodeBase64(passWord);
		return new String(decodePassword);
	}

	// Chamada do teste a ser execucado
	@Test
	public static void login(WebDriver driver) throws InterruptedException {

		// chama a url do sistema mantis
		driver.get("http://mantis-prova.base2.com.br/");
		driver.manage().timeouts().pageLoadTimeout(2, TimeUnit.SECONDS);

		// utilização do decodificador de senha
		String passWord = decodePassword("MjMwNTA3");
		driver.manage().timeouts().pageLoadTimeout(2, TimeUnit.SECONDS);

		// Setando as informações de do usuário e senha na tela de login.
		driver.findElement(By.name("username")).sendKeys("miecio.costa");
		driver.findElement(By.name("password")).sendKeys(passWord);

		// Click no botão para logar
		driver.findElement(
				By.cssSelector("body > div:nth-child(5) > form > table > tbody > tr:nth-child(6) > td > input"))
				.click();

		/*
		 * Chamada para verificação do projeto após usuário logar no sistema. Mais
		 * informações em: br.com.mantisprova.base2.utils.VerificaProjeto.java
		 */
		br.com.mantisprova.base2.utils.VerificaProjeto.verificaProjeto(driver);
	}

}