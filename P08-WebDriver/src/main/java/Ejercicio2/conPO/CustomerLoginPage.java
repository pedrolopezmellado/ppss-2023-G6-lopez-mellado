package Ejercicio2.conPO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CustomerLoginPage {
    WebDriver driver;
    WebElement username;
    WebElement password;
    WebElement loginButton;
    WebElement errorLogin;
    String pTitle;

    public CustomerLoginPage (WebDriver driver){
        this.driver = driver;
        loginButton = driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a"));
        username = driver.findElement(By.name("login[username]"));
        password = driver.findElement(By.name("login[password]"));
        loginButton = driver.findElement(By.id("send2"));
        pTitle = driver.getTitle();
    }

    public MyAccountPage loginOK(String username, String password) {
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        loginButton.click();
        return new MyAccountPage(driver);
    }

    public String loginFail(String username, String wrongPassword) {
        this.username.sendKeys(username);
        this.password.sendKeys(wrongPassword);
        loginButton.click();
        errorLogin = driver.findElement(By.cssSelector("body > div.wrapper > div.page > div.main-container.col1-layout > div > div > div.account-login > ul > li > ul > li > span"));
        return errorLogin.getText();
    }

    public String getLoginTitle(){
        return pTitle;
    }
}
