package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import util.BaseTest;

public class SignUpPage {

    Faker faker = new Faker();
    private static final By btnMale = By.cssSelector("#id_gender1");
    private static final By nameField = By.cssSelector("#customer_firstname");
    private static final By lastNameField = By.cssSelector("#customer_lastname");
    private static final By password = By.cssSelector("#passwd");
    private static final By daysList = By.cssSelector("#days");
    private static final By monthsList = By.cssSelector("#months");
    private static final By yearList = By.cssSelector("#years");
    private static final By firstNameAddress = By.cssSelector("#firstname");
    private static final By lastNameAddress = By.cssSelector("#lastname");
    private static final By address = By.cssSelector("#address1");
    private static final By city = By.cssSelector("#city");
    private static final By stateList = By.cssSelector("#id_state");
    private static final By postCode = By.cssSelector("#postcode");
    private static final By countryList = By.cssSelector("#id_country");
    private static final By mobilePhone = By.cssSelector("#phone_mobile");
    private static final By btnSubmit = By.cssSelector("#submitAccount > span");

    public void clicarBtnMale(){
        BaseTest.click(btnMale);
    }
    public void preencherName(){
        BaseTest.sendKeys(nameField,faker.name().firstName());
    }
    public void preencherLastName(){
        BaseTest.sendKeys(lastNameField,faker.name().lastName());
    }
    public void preencherPassword(){
        BaseTest.sendKeys(password,faker.numerify("#####"));
    }
    public void selecionarDaysList(){
        BaseTest.selecionarLista(daysList,"28");
    }
    public void selecionarMonthsList(){
        BaseTest.selecionarLista(monthsList,"9");
    }
    public void selecionarYearList(){
        BaseTest.selecionarLista(yearList,"2010");
    }
    public void preencherFirstNameAddress(){
        BaseTest.sendKeys(firstNameAddress,faker.name().firstName());
    }
    public void preencherLastNameAddress(){
        BaseTest.sendKeys(lastNameAddress,faker.name().lastName());
    }
    public void preencherAddress(){
        BaseTest.sendKeys(address,faker.address().fullAddress());
    }
    public void preencherCity(){
        BaseTest.sendKeys(city,faker.address().cityName());
    }
    public void selecionarStateList(){
        BaseTest.selecionarLista(stateList,"1");
    }
    public void preencherPostCode(){
        BaseTest.sendKeys(postCode,faker.address().zipCode());
    }
    public void selecionarCountryList(){
        BaseTest.selecionarLista(countryList,"21");
    }
    public void preencherMobilePhone(){
        BaseTest.sendKeys(mobilePhone,faker.phoneNumber().cellPhone());
    }
    public void clicarBtnSubmit(){
        BaseTest.click(btnSubmit);
    }
}
