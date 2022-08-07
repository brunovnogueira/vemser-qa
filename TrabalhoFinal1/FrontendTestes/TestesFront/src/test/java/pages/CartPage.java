package pages;

import org.openqa.selenium.By;
import util.BaseTest;

public class CartPage {
    private static final By productCart = By.cssSelector("#item_4_title_link > div");

    public String validarProdutoCarrinho(){
        return BaseTest.getText(productCart);
    }
}
