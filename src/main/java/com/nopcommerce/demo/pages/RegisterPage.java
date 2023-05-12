package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class RegisterPage extends Utility
{
    public RegisterPage()
    {
        PageFactory.initElements(driver,this);
    }

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Register')]")
    WebElement verifyRegisterPage;

    @CacheLookup
    @FindBy(xpath = "//button[@id='register-button']")
    WebElement clickOnRegisterButton;

    @CacheLookup
    @FindBy(xpath ="//span[@data-valmsg-for='FirstName']")
    WebElement verifyFirstName;

    @CacheLookup
    @FindBy(xpath = "//span[@id='LastName-error']")
    WebElement verifyLastName;

    @CacheLookup
    @FindBy(xpath = "//span[@id='Email-error']")
    WebElement verifyEmailAddress;

    @CacheLookup
    @FindBy(xpath = "//span[@id='Password-error']")
    WebElement verifyPassword;

    @CacheLookup
    @FindBy(xpath = "//span[@id='ConfirmPassword-error']")
    WebElement verifyConfirmPassword;

    @CacheLookup
    @FindBy(xpath = "//input[@id='gender-female']")
    WebElement selectGenderButton;

    @CacheLookup
    @FindBy(xpath = "//input[@id='FirstName']")
    WebElement enterFirstName;

    @CacheLookup
    @FindBy(xpath = "//input[@id='LastName']")
    WebElement enterLastName;

    @CacheLookup
    @FindBy(xpath = "//select[@name='DateOfBirthDay']")
    WebElement selectDate;

    @CacheLookup
    @FindBy(xpath = "//select[@name='DateOfBirthMonth']")
    WebElement selectMonth;

    @CacheLookup
    @FindBy(xpath = "//select[@name='DateOfBirthYear']")
    WebElement selectYear;

    @CacheLookup
    @FindBy(xpath = "//input[@id='Email']")
    WebElement enterEmailAddress;

    @CacheLookup
    @FindBy(xpath = "//input[@id='Password']")
    WebElement enterPassword;

    @CacheLookup
    @FindBy(xpath = "//input[@id='ConfirmPassword']")
    WebElement enterConfirmPassword;


    public void verifyRegisterPage()
    {
        Reporter.log("Verify RegisterPage");
        String expectedErrorMessage = "Register";
        String actualErrorMessage = getTextFromElement(verifyRegisterPage);
        Assert.assertEquals( expectedErrorMessage, actualErrorMessage,"Verify RegisterPage");
        CustomListeners.test.log(Status.PASS,"Verify RegisterPage");
    }

    public void clickOnRegisterButton()
    {
        Reporter.log("Click On Register Button");
        clickOnElement(clickOnRegisterButton);
        CustomListeners.test.log(Status.PASS,"Click On Register Button");
    }

    public void verifyFirstNameError(){
        Reporter.log("First name is required.");
        String expectedFirstNameError = "First name is required.";
        String actualFirstNameError=getTextFromElement(verifyFirstName);
        Assert.assertEquals(expectedFirstNameError,actualFirstNameError);
        CustomListeners.test.log(Status.PASS,"First name is required.");
    }
    public void verifyLastNameError(){
        Reporter.log("Last name is required.");
        String expectedLastNameError = "Last name is required.";
        String actualLastNameError = getTextFromElement(verifyLastName);
        Assert.assertEquals(expectedLastNameError,actualLastNameError);
        CustomListeners.test.log(Status.PASS,"Last name is required.");
    }
    public void verifyEmailError(){
        Reporter.log("Email is required.");
        String expectedEmailError = "Email is required.";
        String actualEmailError = getTextFromElement(verifyEmailAddress);
        Assert.assertEquals(expectedEmailError,actualEmailError);
        CustomListeners.test.log(Status.PASS,"Email is required.");
    }
    public void verifyPasswordError(){
        Reporter.log("Password is required.");
        String expectedPasswordError = "Password is required.";
        String actualPasswordError = getTextFromElement(verifyPassword);
        Assert.assertEquals(expectedPasswordError,actualPasswordError);
        CustomListeners.test.log(Status.PASS,"Password is required.");
    }
    public void verifyConfirmPasswordError(){
        Reporter.log("Password is required.");
        String expectedConfirmPasswordError = "Password is required.";
        String actualConfirmPasswordError=getTextFromElement(verifyConfirmPassword);
        Assert.assertEquals(expectedConfirmPasswordError,actualConfirmPasswordError);
        CustomListeners.test.log(Status.PASS,"Password is required.");
    }

    public void genderButton()
    {
        Reporter.log("Select gender Female");
        clickOnElement(selectGenderButton);
        CustomListeners.test.log(Status.PASS,"Select gender Female");
    }

    public void enterFirstName(String firstName)
    {
        Reporter.log("Enter firstname");
        sendTextToElement(enterFirstName, firstName);
        CustomListeners.test.log(Status.PASS,"Enter firstname");
    }

    public void enterLastName(String lastName)
    {
        Reporter.log("Enter lastName");
        sendTextToElement(enterLastName,lastName);
        CustomListeners.test.log(Status.PASS,"Enter lastName");
    }

    public void selectDayMonthYear()
    {
        Reporter.log("select Day Month Year");
        sendTextToElement(selectDate,"4");
        sendTextToElement(selectMonth,"12");
        sendTextToElement(selectYear,"1999");
        CustomListeners.test.log(Status.PASS,"selectDayMonthYear");
    }

    public void userDetail(String email,String password,String confirmPassword)
    {
        Reporter.log("User Details");
        sendTextToElement(enterEmailAddress,email);
        sendTextToElement(enterPassword, password);
        sendTextToElement(enterConfirmPassword,confirmPassword);
        CustomListeners.test.log(Status.PASS,"User Details");
    }







}
