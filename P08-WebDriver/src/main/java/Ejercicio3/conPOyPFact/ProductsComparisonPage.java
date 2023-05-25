package Ejercicio3.conPOyPFact;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsComparisonPage {
    WebDriver driver;
    @FindBy(className="level0 has-children")
    WebElement accessoriesMenu;
    @FindBy(className="level1") WebElement shoes;
    String myHandleId;
    String myHandleIdFROM;
    String pTitle;

    public ProductsComparisonPage(WebDriver driver){
        this.driver = driver;
        pTitle = driver.getTitle();
    }

    public ShoesPage goToShoesPage(){
        buttonClose.click();    ???
        driver.switchTo().window(handleIDFrom);
        return
                PageFactory.initElements(driver,ShoesPage.class);
    }

    public String getLoginTitle(){
        return pTitle;
    }
}
