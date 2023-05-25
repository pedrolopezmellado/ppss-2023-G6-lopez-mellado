package Ejercicio2.conPO;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestLogin2 {

    WebDriver driver;
    HomePage homePage;
    CustomerLoginPage customerPage;
    MyAccountPage myAccountPage;

    @BeforeEach
    public void setup(){
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
    }

    @Test
    @Tag("OnlyOnce")
    public void test_Login_Correct(){
        Assertions.assertEquals("Madison Island", homePage.getLoginTitle());
        customerPage = homePage.goToLoginPage();
        Assertions.assertEquals("Customer Login", customerPage.getLoginTitle());
        myAccountPage = customerPage.loginOK("pedro@ua.es", "Pedro123");
        Assertions.assertEquals("My Account", myAccountPage.getLoginTitle());
    }

    @Test
    @Tag("OnlyOnce")
    public void test_Login_Incorrect(){
        Assertions.assertEquals("Madison Island", homePage.getLoginTitle());
        customerPage = homePage.goToLoginPage();
        Assertions.assertEquals("Customer Login", customerPage.getLoginTitle());
        String error = customerPage.loginFail("pedro@ua.es", "Pedro456");
        Assertions.assertEquals("Invalid login or password.", error);
    }

    @AfterEach
    public void tearDown() {
        driver.close();
    }
}
