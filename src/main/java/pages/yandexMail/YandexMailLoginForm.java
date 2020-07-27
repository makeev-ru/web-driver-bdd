package pages.yandexMail;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractPage;


public class YandexMailLoginForm extends AbstractPage {

    private static final String URL = "https://mail.yandex.com/";

    public YandexMailLoginForm open() {
        driver.get(URL);
        return this;
    }

    @FindBy(xpath = "//span[text()='Log in']/parent::a")
    private WebElement loginButton;

    @FindBy(id = "passp-field-login")
    private WebElement usernameInput;

    @FindBy(id = "passp-field-passwd")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginToContinueButton;

    public YandexMailLoginForm clickLoginButton () {
        waitForElementsClickable(loginButton);
        loginButton.click();

        return new YandexMailLoginForm();
    }

    public YandexMailLoginForm enterUsername (String username) {
        waitForElementsVisible(usernameInput);
        usernameInput.sendKeys(username);
        usernameInput.sendKeys(Keys.ENTER);

        return new YandexMailLoginForm();
    }

    public YandexMailHomeMenuPage enterPasswordAndSubmit(String password) {
        waitForElementsVisible(passwordInput);
        passwordInput.sendKeys(password);

        waitForElementsClickable(loginToContinueButton);
        loginToContinueButton.submit();

        return new YandexMailHomeMenuPage();
    }
}
