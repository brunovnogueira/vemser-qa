package pages;

import org.openqa.selenium.By;
import util.BaseTest;

public class DeletePage {
    private static final By btnDelete = By.cssSelector("body > div > div > form > div > input");

    public void clicarDelete(){
        BaseTest.click(btnDelete);
    }
}
