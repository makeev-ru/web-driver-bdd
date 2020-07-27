package pages.yandexMail;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class YandexMailHomeMenuPage extends YandexMailHomeMessageArea {

    @FindBy(xpath = "//a[@title='Compose (w, c)']")
    private WebElement composeButton;

    @FindBy(xpath = "//span[@title='Check for new messages (F9)']")
    private WebElement updateButton;

    @FindBy(xpath = "//span[text()='Drafts']")
    private WebElement draftsButton;

    @FindBy(xpath = "//*[@class='mail-NestedList-Item-Name' and text()='Sent']")
    private WebElement sentButton;

    @FindBy(xpath = "//a/div[@class='user-pic user-pic_has-plus_ user-account__pic']")
    private WebElement usernameLoginTitle;

    @FindBy(xpath = "//span[text()='Log out']/parent::a")
    private WebElement logoffButton;

    public YandexMailNewMessageModal clickComposeButton() {
        waitForElementsClickable(composeButton);
        composeButton.click();
        return new YandexMailNewMessageModal();
    }

    public YandexMailHomeMenuPage clickUpdateButton() {
        waitForElementsClickable(updateButton);
        updateButton.click();
        return new YandexMailHomeMenuPage();
    }

    public YandexMailHomeMenuPage clickDraftsLink() {
        waitForElementsClickable(draftsButton);
        draftsButton.click();
        return new YandexMailHomeMenuPage();
    }

    public YandexMailHomeMenuPage clickSentLink() {
        waitForElementsClickable(sentButton);
        sentButton.click();
        return new YandexMailHomeMenuPage();
    }

    public boolean isUrlContains(String urlPart) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.urlContains(urlPart));
    }

    public YandexMailHomeMenuPage clickUserIcon() {
        waitForElementsVisible(usernameLoginTitle);
        usernameLoginTitle.click();
        return new YandexMailHomeMenuPage();
    }

    public YandexMailHomeMenuPage clickLogoffButton() {
        waitForElementsVisible(logoffButton);
        logoffButton.click();
        return new YandexMailHomeMenuPage();
    }

    public YandexMailHomeMenuPage waitUntilPageLoad() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return new YandexMailHomeMenuPage();
    }





}
