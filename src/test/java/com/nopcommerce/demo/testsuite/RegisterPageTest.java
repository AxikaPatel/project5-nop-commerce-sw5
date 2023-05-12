package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.RegisterPage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class RegisterPageTest extends BaseTest
{
    HomePage homePage;
    RegisterPage registerPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt()
    {
        homePage = new HomePage();
        registerPage = new RegisterPage();
    }

    @Test(groups = {"sanity","regression"})
    public void verifyUserShouldNavigateToRegisterPageSuccessfully()
    {
        homePage.clickOnRegisterLink();
        registerPage.verifyRegisterPage();
    }

    @Test(groups = {"smoke","regression"})
    public void verifyThatFirstNameLastNameEmailOasswordAndConfirmPasswordFieldsAreMandetory()
    {
        homePage.clickOnRegisterLink();
        registerPage.clickOnRegisterButton();
        registerPage.verifyFirstNameError();
        registerPage.verifyLastNameError();
        registerPage.verifyEmailError();
        registerPage.verifyPasswordError();
        registerPage.verifyConfirmPasswordError();
    }

    @Test(groups = "regression")
    public void verifyThatUserShouldCreateAccountSuccessfully()
    {
        homePage.clickOnRegisterLink();
        registerPage.genderButton();
        registerPage.enterFirstName("Prime");
        registerPage.enterLastName("Testing");
        registerPage.selectDayMonthYear();
        registerPage.userDetail("prime123" +getAlphaNumericString(2)+"@gmail.com","Prime@123","Prime@123");
        registerPage.clickOnRegisterButton();
    }
}
