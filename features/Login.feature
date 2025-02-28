Feature: Login

Scenario: Successful Login with Valid Credentials
  Given User Launch Chrome Browser
  When User opens URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
  And User enters email as "admin@yourstore.com" and Password as "admin"
  And Click on Login
  Then Page title should be "Dashboard / nopCommerce administration"
  When User click on Logout link
  Then Page title should be "nopCommerce demo store. Login"
  And Close browser