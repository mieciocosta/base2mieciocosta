/*
* Classe SelecionaCombos tem o intuito de "exugar" os códigos que necessitam preencher combos
* da tela <bug_report_page.php>> podendo ser reutilizada chamando a mesma.
*/

package br.com.mantisprova.base2.utils;

import java.util.Random;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * @version 1.0
 * @author Miécio Santos Costa
 */

public class SelecionaCombos {

	// Chamada do teste a ser execucado
	@Test
	public static void selecionaItemCombos(WebDriver driver) {

		// Seleciona aleatoriamente uma categoria na combo
		WebElement comboCategory;
		comboCategory = driver.findElement(By.name("category_id"));
		Select selectComboCategory = new Select(comboCategory);
		int randomCategory = new Random().nextInt(selectComboCategory.getOptions().size());
		selectComboCategory.selectByIndex(randomCategory);

		// Seleciona aleatoriamente uma reprodutibilidade na combo
		WebElement comboReproducibility;
		comboReproducibility = driver.findElement(By.name("reproducibility"));
		Select selectComboReproducibility = new Select(comboReproducibility);
		int randomReproducibility = new Random().nextInt(selectComboReproducibility.getOptions().size());
		selectComboReproducibility.selectByIndex(randomReproducibility);

		// Seleciona aleatoriamente uma severidade na combo
		WebElement comboSeverity;
		comboSeverity = driver.findElement(By.name("severity"));
		Select selectComboSeverity = new Select(comboSeverity);
		int randomSeverity = new Random().nextInt(selectComboSeverity.getOptions().size());
		selectComboSeverity.selectByIndex(randomSeverity);

		// Seleciona aleatoriamente uma prioridade na combo
		WebElement comboPriority;
		comboPriority = driver.findElement(By.name("priority"));
		Select selectComboPriority = new Select(comboPriority);
		int randomPriority = new Random().nextInt(selectComboPriority.getOptions().size());
		selectComboPriority.selectByIndex(randomPriority);

		// Seleciona aleatoriamente um perfil na combo
		WebElement comboProfile;
		comboProfile = driver.findElement(By.name("profile_id"));
		Select selectComboProfile = new Select(comboProfile);
		int randomProfile = new Random().nextInt(selectComboProfile.getOptions().size());
		selectComboProfile.selectByIndex(randomProfile);
	}
}
