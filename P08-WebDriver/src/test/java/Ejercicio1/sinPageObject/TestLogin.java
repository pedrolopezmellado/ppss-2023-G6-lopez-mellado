package Ejercicio1.sinPageObject;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestLogin {

    WebDriver driver;

    @BeforeEach
    public void setup(){
        driver = new ChromeDriver();
        driver.get("http://demo-store.seleniumacademy.com/");
    }

    @Test
    @Tag("OnlyOnce")
    public void loginOK(){
        Assertions.assertEquals("Madison Island", driver.getTitle());
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a")).click();
        Assertions.assertEquals("Customer Login", driver.getTitle());
        driver.findElement(By.name("login[username]")).sendKeys("pedro@ua.es");
        driver.findElement(By.id("send2")).click();
        Assertions.assertEquals("This is a required field.", driver.findElement(By.id("advice-required-entry-pass")).getText()) ;
        driver.findElement(By.name("login[password]")).sendKeys("Pedro123");
        driver.findElement(By.id("send2")).click();
        Assertions.assertEquals("My Account", driver.getTitle());
    }

    @Test
    @Tag("OnlyOnce")
    public void loginFailed(){
        Assertions.assertEquals("Madison Island", driver.getTitle());
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a")).click();
        Assertions.assertEquals("Customer Login", driver.getTitle());
        driver.findElement(By.name("login[username]")).sendKeys("pedro@ua.es");
        driver.findElement(By.name("login[password]")).sendKeys("Pedro123123");
        driver.findElement(By.id("send2")).click();
        Assertions.assertEquals("Invalid login or password.", driver.findElement(By.cssSelector("body > div.wrapper > div.page > div.main-container.col1-layout > div > div > div.account-login > ul > li > ul > li > span")).getText());
    }

    @AfterEach
    public void tearDown() {
        driver.close();
    }


}