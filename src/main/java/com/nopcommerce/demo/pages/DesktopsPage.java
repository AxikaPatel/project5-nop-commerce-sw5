package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;

public class DesktopsPage extends Utility
{

    @CacheLookup
    @FindBy(xpath = "//img[@title='Show products in category Desktops']")
    WebElement desktops;

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Desktops')]")
    WebElement verifyDesktops;

    public void clickOnDesktopClick()
    {
        Reporter.log("Click on Desktop");
        clickOnElement(desktops);
        CustomListeners.test.log(Status.PASS,"Click on Desktop");
    }

    public void verifyDesktopText()
    {
        Reporter.log("Verify Desktop text");
        String expectedMessage = "Desktops";
        String actualMessage = getTextFromElement(verifyDesktops);
        Assert.assertEquals(expectedMessage,actualMessage);
        CustomListeners.test.log(Status.PASS,"Verify Desktop text");
    }

}
