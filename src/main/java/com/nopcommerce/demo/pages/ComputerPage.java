package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import java.util.List;

public class ComputerPage extends Utility
{
    public ComputerPage()
    {
        PageFactory.initElements(driver,this);
    }

    @CacheLookup
    @FindBy(xpath = "//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']")
    List<WebElement>computerMenu;

    public void selectMenu(String menu) {
        List<WebElement> topMenuList = computerMenu;
        try {
            for (WebElement element : topMenuList) {
                if (element.getText().equalsIgnoreCase(menu)) {
                    element.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            topMenuList = computerMenu;
        }
    }

    @CacheLookup
    @FindBy(xpath = "//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']")
    WebElement computerTab;

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Computers')]")
    WebElement verifyComputer;




    public void clickOnComputerLink()
    {
        Reporter.log("Click on Computer tab");
        clickOnElement(computerTab);
        CustomListeners.test.log(Status.PASS,"Click on Computer tab");
    }

    public void verifyComputerText()
    {
        Reporter.log("Verify Computer text");
        String expectedMessage = "Computers";
        String actualMessage = getTextFromElement(verifyComputer);
        Assert.assertEquals(expectedMessage,actualMessage);
        CustomListeners.test.log(Status.PASS,"Verify Computer text");

    }


}
