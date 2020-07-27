package pages.yandexMail;

import org.openqa.selenium.By;
import pages.AbstractPage;

public class YandexMailHomeMessageArea extends AbstractPage {

    private By messageLinkBySubject;

    public YandexMailNewMessageModal clickMessageLinkBySubject(String subject) {
        String locator = "//span[@title='" + subject + "']/ancestor::div[@class='mail-MessageSnippet-Content']";

        messageLinkBySubject = By.xpath(locator);
        waitForElementsClickable(messageLinkBySubject);
        driver.findElement(messageLinkBySubject).click();
        return new YandexMailNewMessageModal();
    }

    public int getAmountOfMessagesBySubject(String subject) {
        String locator = "//span[@title='" + subject + "']/ancestor::div[@class='mail-MessageSnippet-Content']";
        messageLinkBySubject = By.xpath(locator);
        return driver.findElements(messageLinkBySubject).size();
    }

    public int getAmountOfMessagesBySubjectWithWaiter(String subject) {
        String locator = "//span[@title='" + subject + "']/ancestor::div[@class='mail-MessageSnippet-Content']";
        messageLinkBySubject = By.xpath(locator);
        waitForElementsPresent(messageLinkBySubject);
        return driver.findElements(messageLinkBySubject).size();
    }

}
