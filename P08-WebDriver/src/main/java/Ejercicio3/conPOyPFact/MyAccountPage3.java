package Ejercicio3.conPOyPFact;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage3 {
    WebDriver driver;
    @FindBy(className="level0 has-children") WebElement accessoriesMenu;
    @FindBy(className="level1") WebElement shoes;
    String pTitle;

    public MyAccountPage3 (WebDriver driver){
        this.driver = driver;
        pTitle = driver.getTitle();
    }

    public ShoesPage goToShoesPage(){
        Actions builder = new Actions(driver);
        builder.moveToElement(accessoriesMenu);
        builder.perform();
        shoes.click();

        return PageFactory.initElements(driver, ShoesPage.class);
    }

    public String getLoginTitle(){
        return pTitle;
    }
}
