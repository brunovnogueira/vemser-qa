package pages;

import org.openqa.selenium.By;
import util.BaseTest;

public class CheckoutPage {
    private static final By productCheckout = By.cssSelector("#product_1_1_0_728991 > td.cart_description > p > a");
    public String validarProdutoCheckout() {
        return BaseTest.getText(productCheckout);
    }
}
