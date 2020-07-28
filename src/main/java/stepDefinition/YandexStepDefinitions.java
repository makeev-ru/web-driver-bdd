package stepDefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import pages.yandexMail.YandexMailHomeMenuPage;
import pages.yandexMail.YandexMailHomeMessageArea;
import pages.yandexMail.YandexMailLoginForm;
import pages.yandexMail.YandexMailNewMessageModal;

import java.util.ArrayList;
import java.util.List;

public class YandexStepDefinitions {
    private static final String USERNAME = System.getenv("YANDEX_USERNAME");
    private static final String PASSWORD = System.getenv("YANDEX_PASSWORD");

    private String send_to = USERNAME + "@yandex.ru";

    private String subject;
    private String body;

    @Given("I opened Yandex Mail login page")
    public void iOpenedYandexMailLoginPage() {
        new YandexMailLoginForm().open();
    }

    @When("I click on Login button")
    public void iClickLoginButton() {
        new YandexMailLoginForm().clickLoginButton();
    }

    @And("I enter username")
    public void iEnterUsername() {
        new YandexMailLoginForm().enterUsername(USERNAME);
    }

    @And("I enter password")
    public void iEnterPassword() {
        new YandexMailLoginForm().enterPasswordAndSubmit(PASSWORD);
    }

    @Then("The login is successful")
    public void loginIsSuccessful() {
        String urlPart = "inbox";
        Assert.assertTrue(new YandexMailHomeMenuPage().isUrlContains(urlPart));
    }

    @When("I login to Yandex Mail")
    public void iLoginToYandexMail() {
        new YandexMailLoginForm().
                clickLoginButton().
                enterUsername(USERNAME).
                enterPasswordAndSubmit(PASSWORD);

    }

    @And("I logoff from Yandex Mail")
    public void iLogoffFromYandexMail() {
        new YandexMailHomeMenuPage().
                clickUserIcon().
                clickLogoffButton();
    }

    @Then("Authorization page is opened")
    public void authorizationPageIsOpened() {
        String urlPart = "/auth/welcome";
        Assert.assertTrue(new YandexMailHomeMenuPage().isUrlContains(urlPart));
    }

    @And("I click on Compose button")
    public void iClickOnComposeButton() {
        new YandexMailHomeMenuPage().clickComposeButton();
    }

    @And("I fill out New Message Form")
    public void iFillOutNewMessageForm() {
        subject = RandomStringUtils.randomAlphanumeric(5);
        body = RandomStringUtils.randomAlphanumeric(20);
        new YandexMailNewMessageModal().fillNewMessageForm(send_to, subject, body).clickCloseIcon();
    }

    @And("^I enter addressee: ([^@]+@[^.]+\\..+)$")
    public void iEnterAddressee(String send_to) {
        this.send_to = send_to;
        new YandexMailNewMessageModal().enterAddressee(send_to);
    }

    @And("^I enter subject: ([^\"]*)$")
    public void iEnterSubject(String subject) {
        this.subject = subject;
        new YandexMailNewMessageModal().enterSubject(subject);
    }

    @And("^I enter body: ([^\"]*)$")
    public void iEnterBody(String body) {
        this.body = body;
        new YandexMailNewMessageModal().enterBody(body);
    }

    @And("I go to Drafts folder")
    public void iGoToDraftsFolder() {
        new YandexMailHomeMenuPage().clickDraftsLink();
    }

    @And("I open recently created Draft message")
    public void iOpenRecentlyCreatedDraftMessage() {
        new YandexMailHomeMenuPage().clickUpdateButton().clickMessageLinkBySubject(subject);
    }

    @Then("Message content is the same")
    public void messageContentIsTheSame() {
        List<String> actualMessageContentList = new YandexMailNewMessageModal().getMessageContent_to_subject_body();

        List<String> expectedMessageContentList = new ArrayList<>();
        expectedMessageContentList.add(send_to);
        expectedMessageContentList.add(subject);
        expectedMessageContentList.add(body);

        Assert.assertEquals("Content doesn't match", expectedMessageContentList, actualMessageContentList);
    }

    @And("I send the message")
    public void iSendTheMessage() {
        new YandexMailNewMessageModal().clickSendButton().clickBackToInboxButton();
    }

    @Then("The message is disappeared from Drafts")
    public void theMessageIsDisappearedFromDrafts() {
        int actual = new YandexMailHomeMessageArea().getAmountOfMessagesBySubject(subject);
        boolean isMessageInFolder = actual > 0;
        Assert.assertFalse("The message is still in Drafts", isMessageInFolder);
    }

    @And("I go to Sent folder")
    public void iGoToSentFolder() {
        new YandexMailHomeMenuPage().clickSentLink();
    }

    @Then("The message is present in Sent folder")
    public void theMessageIsPresentInSentFolder() {
        int actual = new YandexMailHomeMessageArea().getAmountOfMessagesBySubjectWithWaiter(subject);
        boolean isMessageInFolder = actual == 1;
        Assert.assertTrue("The is no sent message in Sent folder", isMessageInFolder);
    }

    @And("I click Close icon")
    public void iClickCloseIcon() {
        new YandexMailNewMessageModal().clickCloseIcon();
    }


//    @When("^I search ([\\w ]+)$")
//    public void iSearch(String query) {
//        new HomePage().fillSearchInput(query).startSearch();
//    }
//
//
//    @And("^I open item page$")
//    public void iOpenItemPage() {
//        new SearchResultsPage().openFirstSearchResult();
//    }
//
//    @Then("^Item price is lower \\$(\\d+)$")
//    public void itemPriceIsLower$(int expectedPrice) {
//        double actualPrice = new ItemPage().readItemPrice();
//        Assert.assertTrue(actualPrice < expectedPrice);
//    }
}
