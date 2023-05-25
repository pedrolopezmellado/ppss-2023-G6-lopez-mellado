package Ejercicio3.conPOyPFact;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;

public class ShoesPage {

    WebDriver driver;
    @FindBy(css="body > div.wrapper > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(5) > div > div.actions > ul > li:nth-child(2) > a")
    WebElement wingtipShoe;
    @FindBy(css="body > div.wrapper > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(6) > div > div.actions > ul > li:nth-child(2) > a")
    WebElement suedeShoe;
    @FindBy(css = "body > div.wrapper > div.page > div.main-container.col3-layout > div > div.col-right.sidebar > div > div.block-content > div > button")
    WebElement compareButton;
    String pTitle;
    String myHandleId = driver.getWindowHandle();

    public ShoesPage (WebDriver driver){
        this.driver = driver;
        pTitle = driver.getTitle();
    }

    public ProductsComparisonPage goToProducts(){
        selectShoeToCompare(5);
        selectShoeToCompare(6);
        String myHandleId = driver.getWindowHandle();
        compareButton.click();

        Set<String> setIds = driver.getWindowHandles();
        String[] handleIds = setIds.toArray(new String[setIds.size()]);
        System.out.println("ID 0: "+handleIds[0]); //manejador de la ventana ShoesPage
        System.out.println("ID 1: "+handleIds[1]);

        return PageFactory.initElements(driver, ProductsComparisonPage.class);
    }

    public void selectShoeToCompare(int number) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        switch (number) {
            case 5: jse.executeScript("arguments[0].scrollIntoView();", wingtipShoe);
                wingtipShoe.click();
                break;
            case 6: jse.executeScript("arguments[0].scrollIntoView();", suedeShoe);
                suedeShoe.click();
                break;
        }
    }

    public String getLoginTitle(){
        return pTitle;
    }
}
