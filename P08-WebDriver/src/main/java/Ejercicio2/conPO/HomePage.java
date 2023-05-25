package Ejercicio2.conPO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
    WebDriver driver;
    WebElement accountButton;
    WebElement loginButton;
    String pTitle;

    public HomePage (WebDriver driver){
        this.driver = driver;
        this.driver.get("http://demo-store.seleniumacademy.com/");
        accountButton = driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a"));
        pTitle = driver.getTitle();
    }

    public CustomerLoginPage goToLoginPage() {
        accountButton.click();
        loginButton = driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a"));
        loginButton.click();
        return new CustomerLoginPage(driver);
    }

    public String getLoginTitle(){
        return pTitle;
    }
}
