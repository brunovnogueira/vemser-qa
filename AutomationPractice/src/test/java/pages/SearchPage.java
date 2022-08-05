package pages;

import org.openqa.selenium.By;
import util.BaseTest;

public class SearchPage {
    private static final By productName = By.cssSelector("#center_column > ul > li > div > div.right-block > h5 > a");

    public String validarProduto() {
        return BaseTest.getText(productName);
    }
}
