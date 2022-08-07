package pages;

import org.openqa.selenium.By;
import util.BaseTest;

public class LoggedPage {
    private static final By btnMenu = By.cssSelector("#react-burger-menu-btn");
    private static final By productsTitle = By.cssSelector("#header_container > div.header_secondary_container > span");
    private static final By btnAddToCartBackpack = By.cssSelector("#add-to-cart-sauce-labs-backpack");
    private static final By btnCart = By.cssSelector("#shopping_cart_container > a");
    private static final By btnLogout = By.cssSelector("#logout_sidebar_link");


    public void clicarMenu(){
        BaseTest.click(btnMenu);
    }

    public String validarTitle(){
        return BaseTest.getText(productsTitle);
    }

    public void clicarBtnAddToCart(){
        BaseTest.click(btnAddToCartBackpack);
    }

    public void clicarBtnCart(){
        BaseTest.click(btnCart);
    }

    public void clicarBtnLogout(){
        BaseTest.click(btnLogout);
    }
}
