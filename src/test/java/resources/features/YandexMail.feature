Feature: Yandex mail

  Background:
    Given I opened Yandex Mail login page

  Scenario: Login to Yandex Mail
    When I click on Login button
    And I enter username
    And I enter password
    Then The login is successful


  Scenario: Verify draft content
    When I login to Yandex Mail
    And I click on Compose button
    And I fill out New Message Form
    And I go to Drafts folder
    And I open recently created Draft message
    Then Message content is the same

  Scenario: Mail disappeared from Drafts after sending
    When I login to Yandex Mail
    And I click on Compose button
    And I fill out New Message Form
    And I go to Drafts folder
    And I open recently created Draft message
    And I send the message
    And I go to Drafts folder
    Then The message is disappeared from Drafts

  Scenario: Mail is in Sent folder after sending
    When I login to Yandex Mail
    And I click on Compose button
    And I fill out New Message Form
    And I go to Drafts folder
    And I open recently created Draft message
    And I send the message
    And I go to Sent folder
    Then The message is present in Sent folder

  Scenario: Logoff from Yandex Mail
    When I login to Yandex Mail
    And I logoff from Yandex Mail
    Then Authorization page is opened


#  Scenario Outline: Searching items on Amazon
#    When I search <item>
#    And I open item page
#    Then Item price is lower $<price>
#
#    Examples:
#      | item      | price |
#      | iPhone SE | 200   |
#      | iPhone 7  | 500   |
#      | iPhone 8  | 700   |



