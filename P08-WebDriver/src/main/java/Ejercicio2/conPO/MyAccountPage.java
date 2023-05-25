package Ejercicio2.conPO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccountPage {
    WebDriver driver;
    String pTitle;

    public MyAccountPage (WebDriver driver){
        this.driver = driver;
        pTitle = driver.getTitle();
    }

    public String getLoginTitle(){
        return pTitle;
    }
}
