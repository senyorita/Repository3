package Test.QATestLab3;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Script extends DriverChrome {

	public static void main(String[] args) {

		EventFiringWebDriver eventDriver = getEventDriver(url);

		WebElement loginWeb = eventDriver.findElement(By.id("email"));
		loginWeb.sendKeys(login);

		WebElement passwordWeb = eventDriver.findElement(By.id("passwd"));
		passwordWeb.sendKeys(password);

		WebElement buttonWeb = eventDriver.findElement(By.name("submitLogin"));
		buttonWeb.click();

		WebDriverWait waitElement = new WebDriverWait(eventDriver, 20);

		WebElement catalog = waitElement
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@id='subtab-AdminCatalog']/a")));

		Actions act = new Actions(eventDriver);

		act.moveToElement(catalog).perform();

		WebElement category = waitElement
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@id='subtab-AdminCategories']/a")));

		act.click(category).perform();

		WebElement addCategory = waitElement.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='page-header-desc-category-new_category']")));

		addCategory.click();

		WebElement fieldNameCatogory = waitElement
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='name_1']")));

		fieldNameCatogory.sendKeys(newCategory);

		WebElement buttonSave = waitElement
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='category_form_submit_btn']")));

		buttonSave.click();

		WebElement messageDone = waitElement
				.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//*[@id='content']/div[3]/div"))));

		System.out.println(messageDone.getText());

		WebElement buttonClose = waitElement
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='content']/div[3]/div/button")));

		buttonClose.click();

		WebElement buttonUp = waitElement.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//*[@id='table-category']/thead/tr[1]/th[3]/span/a[2]")));

		buttonUp.click();

		List<WebElement> nameCategory = waitElement.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//table[@id = 'table-category']//td[3]")));

		for (WebElement elem : nameCategory) {

			if (newCategory.equals(elem.getText()))
				System.out.println("\n" + "Созданная пользователем категория " + "\"" + newCategory + "\""
						+ " находится в таблице категорий.");

		}

		eventDriver.quit();

	}

}
