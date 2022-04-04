@Chrome
Feature: Validate Parallel run

  Background: user launches webpage
    Given JW webpage is launched in "chrome"

  @FunctionalFlows
Scenario Outline: JW Login Validation
    When user clicks on login button
    And user enters a "<username>" and "<password>"
    And clicks on login arrow button
    Then login is successful

  Examples:
    |username|password|
    |admin   |admin   |

  @FunctionalFlows
  Scenario Outline: JW Design a new app
    When user clicks on login button
    And user enters a "<username>" and "<password>"
    And clicks on login arrow button
    And login is successful
    And click on design new app button
    And enter "<appId>" and "<appName>"
    And click save button
    And publish the app
    Then validate if "<appName>" app is published successfully

    Examples:
      |username|password|appId            |appName          |
      |admin   |admin   |testappID3       |testappName3   |

  @FunctionalFlows
  Scenario Outline: JW Delete an existing app
    When user clicks on login button
    And user enters a "<username>" and "<password>"
    And clicks on login arrow button
    And login is successful
    And click on admin arrow button
    And click on all apps
    And click on "<appName>"
    Then delete the app

    Examples:
      |username|password|appName          |
      |admin   |admin   |testappName3     |