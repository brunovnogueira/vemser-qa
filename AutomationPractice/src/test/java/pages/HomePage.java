package pages;

import org.openqa.selenium.By;
import util.BaseTest;

public class HomePage {
    private static final By btnSignUp = By.cssSelector("#header > div.nav > div > div > nav > div.header_user_info > a");

    public void clicarSignUp(){
        BaseTest.click(btnSignUp);
    }
}
