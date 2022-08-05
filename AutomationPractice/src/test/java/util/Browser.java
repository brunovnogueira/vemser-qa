package util;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class Browser {
    public static WebDriver driver;
    public static WebDriverWait wait;

    @Before //antes dos testes
    public void iniciarBrowser(){
        String url = "http://automationpractice.com/index.php";

        System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");

        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        driver = new ChromeDriver(capabilities); //instancia e cria um browser
        wait = new WebDriverWait(driver, 30); //delay
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(6000, TimeUnit.MILLISECONDS);//define tempo para iniciar
        driver.manage().window().maximize();//maximiza a janela do browser
    }

    @After //depois dos testes
    public void finalizarBrowser(){
        driver.manage().timeouts().implicitlyWait(6000, TimeUnit.MILLISECONDS);
        driver.quit();//finaliza o browser
    }
}
