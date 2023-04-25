package utilities;

import browserfactory.BaseTest;
import org.openqa.selenium.By;

public class Utility extends BaseTest {
    public void sendKeyToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    public void clickButton(By by) {
        driver.findElement(by).click();

    }

    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();


    }
}
