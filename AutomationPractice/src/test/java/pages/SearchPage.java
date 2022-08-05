package pages;

import org.openqa.selenium.By;
import util.BaseTest;

public class SearchPage {
    private static final By productName = By.cssSelector("#center_column > ul > li > div > div.right-block > h5 > a");
    private static final By btnProduct = By.cssSelector("#center_column > ul > li > div > div.left-block > div > a.product_img_link > img");
    public static final By hover = By.cssSelector("#center_column > ul > li > div > div.left-block > div > a.product_img_link > img");
    private static final By btnAddToCart = By.cssSelector("#center_column > ul > li > div > div.right-block > div.button-container > a.button.ajax_add_to_cart_button.btn.btn-default > span");
    private static final By btnCheckout = By.cssSelector("#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > a > span");


    public String validarProduto() {
        return BaseTest.getText(productName);
    }
    public void clicarBtnAddToCart(){
        BaseTest.click(btnAddToCart);
    }
    public void hoverAddToCart(){
        BaseTest.hover(hover);
    }
    public void clicarBtnCheckout(){
        BaseTest.click(btnCheckout);
    }
}
