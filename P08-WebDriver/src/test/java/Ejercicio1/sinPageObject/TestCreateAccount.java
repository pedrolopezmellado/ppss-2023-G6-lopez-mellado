package Ejercicio1.sinPageObject;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCreateAccount {

    WebDriver driver;

    @BeforeEach
    public void setup(){
        driver = new ChromeDriver();
        driver.get("http://demo-store.seleniumacademy.com/");
    }

    @Test
    @Tag("OnlyOnce")
    public void createAccount(){

        Assertions.assertEquals("Madison Island", driver.getTitle());
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a")).click();
        Assertions.assertEquals("Customer Login", driver.getTitle());

        driver.findElement(By.cssSelector("#login-form > div > div.col-1.new-users > div.buttons-set > a")).click();

        Assertions.assertEquals("Create New Customer Account", driver.getTitle());
        driver.findElement(By.name("firstname")).sendKeys("Pedro");
        driver.findElement(By.name("middlename")).sendKeys("Lopez");
        driver.findElement(By.name("lastname")).sendKeys("Mellado");
        driver.findElement(By.name("email")).sendKeys("pedro@ua.es");
        driver.findElement(By.name("password")).sendKeys("Pedro123");
        driver.findElement(By.cssSelector("#form-validate > div.buttons-set > button")).click();
        Assertions.assertEquals("This is a required field.", driver.findElement(By.id("advice-required-entry-confirmation")).getText()) ;
        driver.findElement(By.name("confirmation")).sendKeys("Pedro123");

        driver.findElement(By.cssSelector("#form-validate > div.buttons-set > button")).click();
        Assertions.assertEquals("My Account", driver.getTitle());
    }

    @AfterEach
    public void tearDown() {
        driver.close();
    }
}
