package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboarPage extends BasePage{
    @FindBy(xpath = "//a[normalize-space()='Logout']")
    @CacheLookup
    private WebElement btnLogout;

    public DashboarPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void clickLogout() {
        wait.until(ExpectedConditions.visibilityOf(btnLogout));
        btnLogout.click();
    }
}
