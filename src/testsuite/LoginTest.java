package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class LoginTest extends Utility {
    String baseUrl = "https://www.saucedemo.com/";
    @Before
    public void setUrl() {
        openBrowser(baseUrl);
    }
    @Test
    public void userSholdLoginSuccessfullyWithValid() {
        sendKeyToElement(By.id("user-name"), "standard_user");
        sendKeyToElement(By.name("password"), "secret_sauce");
        clickButton(By.xpath("//input[@id='login-button']"));
        String expectedMessage = "Products";

        String actualMessage = getTextFromElement(By.xpath("//span[@class='title']"));
        Assert.assertEquals("Text not matching", expectedMessage, actualMessage);
    }
    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        sendKeyToElement(By.id("user-name"), "standard_user");
        sendKeyToElement(By.name("password"), "secret_sauce");
        clickButton(By.xpath("//input[@id='login-button']"));

        List<WebElement> lst = driver.findElements(By.className("inventory_item_name"));

        for (int i = 0; i < lst.size(); i++) {
            System.out.println(lst.get(i).getText());
        }
    }
    @After
    public void tesrDown() {
        closeBrowser();
    }
}
