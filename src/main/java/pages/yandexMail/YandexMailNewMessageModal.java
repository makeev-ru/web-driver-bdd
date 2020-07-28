package pages.yandexMail;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractPage;

import java.util.ArrayList;
import java.util.List;


public class YandexMailNewMessageModal extends AbstractPage {

    @FindBy(xpath = "//span[text()='To']/following::div[@class='composeYabbles'][1]")
    private WebElement toInput;

    @FindBy(xpath = "//input[@name='subject']")
    private WebElement subjectInput;

    @FindBy(xpath = "//div[@placeholder='Write something']")
    private WebElement bodyInput;

    @FindBy(xpath = "//div[@class='ComposeYabble-Text'][1]")
    private WebElement toDraftInput;

    @FindBy(xpath = "//div[@class='composeHeader composeHeader_expanded']/div/span/span")
    private WebElement subjectDraftTabTitle;

    @FindBy(xpath = "//*[@placeholder='Write something']/following::div[@role='textbox']/div")
    private WebElement bodyDraftInput;

    @FindBy(xpath = "//button[@class='control button2 button2_view_default button2_tone_default button2_size_l button2_theme_action button2_pin_circle-circle ComposeControlPanelButton-Button ComposeControlPanelButton-Button_action']")
    private WebElement sendButton;

    @FindBy(xpath = "//div[@class='ComposePopup-Content']//button[@class='controlButtons__btn controlButtons__btn--close']")
    private WebElement closeIcon;

    @FindBy(xpath = "//a[@href='#inbox' and text()='Back to \"Inbox\"']")
    private WebElement backToInboxButton;

    public YandexMailNewMessageModal fillNewMessageForm(String send_to, String subject, String body) {
        return enterAddressee(send_to).enterSubject(subject).enterBody(body);
    }

    public YandexMailNewMessageModal enterAddressee(String send_to) {
        waitForElementsClickable(toInput);
        toInput.sendKeys(send_to);

        return new YandexMailNewMessageModal();
    }

    public YandexMailNewMessageModal enterSubject(String subject) {
        waitForElementsClickable(subjectInput);
        subjectInput.sendKeys(subject);

        return new YandexMailNewMessageModal();
    }

    public YandexMailNewMessageModal enterBody(String body) {
        waitForElementsClickable(bodyInput);
        bodyInput.sendKeys(body);

        return new YandexMailNewMessageModal();
    }

    public YandexMailNewMessageModal clickSendButton() {
        waitForElementsClickable(sendButton);
        sendButton.click();
        return new YandexMailNewMessageModal();
    }

    public YandexMailHomeMenuPage clickCloseIcon() {
        waitForElementsClickable(closeIcon);
        closeIcon.click();
        return new YandexMailHomeMenuPage();
    }

    public YandexMailHomeMenuPage clickBackToInboxButton() {
        waitForElementsClickable(backToInboxButton);
        backToInboxButton.click();
        return new YandexMailHomeMenuPage();
    }

    public List<String> getMessageContent_to_subject_body() {
        waitForElementsVisible(toDraftInput);
        waitForElementsVisible(subjectDraftTabTitle);
        waitForElementsVisible(bodyDraftInput);

        List<String> messageContentList = new ArrayList<>();
        messageContentList.add(toDraftInput.getText());
        messageContentList.add(subjectDraftTabTitle.getText());
        messageContentList.add(bodyDraftInput.getText());

        return messageContentList;
    }


}
