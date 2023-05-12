package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class BuildYourOwnComputerPage extends Utility {
    public BuildYourOwnComputerPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(id = "product_attribute_1")
    WebElement selectProcessor;

    @CacheLookup
    @FindBy(id = "product_attribute_2")
    WebElement selectRam;

    @CacheLookup
    @FindBy(id = "product_attribute_input_3")
    WebElement selectHdd;

    @CacheLookup
    @FindBy(id = "product_attribute_3_6")
    WebElement hdd320GB;

    @CacheLookup
    @FindBy(id = "product_attribute_3_7")
    WebElement hdd400GB;

    @CacheLookup
    @FindBy(id = "product_attribute_4_8")
    WebElement osVistaHome;

    @CacheLookup
    @FindBy(id = "product_attribute_4_9")
    WebElement osVistaPremium;

    @CacheLookup
    @FindBy(id = "product_attribute_input_4")
    WebElement selectOs;

    @CacheLookup
    @FindBy(id = "product_attribute_input_5")
    WebElement selectSoftware;

    @CacheLookup
    @FindBy(id = "add-to-cart-button-1")
    WebElement addToCart;

    @CacheLookup
    @FindBy(id = "product_attribute_5_11")
    WebElement selectAcrobatReader;

    @CacheLookup
    @FindBy(id = "product_attribute_5_12")
    WebElement selectTotalCommander;

    @CacheLookup
    @FindBy(id = "product_attribute_5_10")
    WebElement selectSoftwareMicrosoftOffice;

    @CacheLookup
    @FindBy(xpath = "//p[@class='content']")
    WebElement addToCartVerifyMsg;


    @CacheLookup
    @FindBy(xpath = "//h2[@class='product-title']//a[normalize-space()='Build your own computer']")
    WebElement clickOnBuildYourOwnComputer;

    public void clickONProductBuildYourOwnComputer() {
        Reporter.log("Click on product name Build your own computer");
        clickOnElement(clickOnBuildYourOwnComputer);
        CustomListeners.test.log(Status.PASS, "Click on product name Build your own computer");
    }


    public void buildYourOwnComputerSelection(String processor, String ram) {

        Reporter.log("Select processor processor,ram,os,");
        selectByVisibleTextFromDropDown(selectProcessor, processor);
        selectByVisibleTextFromDropDown(selectRam, ram);
        CustomListeners.test.log(Status.PASS, "Select processor processor and ram");
    }

    public void buildHdd(String hdd) {
        clickOnElement1(selectHdd, hdd);
    }

    public void buildOs(String os) {
        clickOnElement1(selectOs, os);
    }

    public void buildSoftware(String software) {
        clickOnElement1(selectSoftware, software);
    }

    public void buildAddToCArt() {
        clickOnElement(addToCart);
    }

    public void clickOnHDD320GB() {
        clickOnElement(hdd320GB);
    }

    public void clickOnHDD400GB() {
        clickOnElement(hdd400GB);
    }

    public void setOsVistaHome() {
        clickOnElement(osVistaHome);
    }

    public void setOsVistaPremium() {
        clickOnElement(osVistaPremium);
    }

    public void setAcrobatReader() {
        clickOnElement(selectAcrobatReader);
    }

    public void setMsOffice() {
        clickOnElement(selectSoftwareMicrosoftOffice);
    }

    public void setCommander() {
        clickOnElement(selectTotalCommander);
    }

    public String getAddToCartVerifyMsg() {
        return getTextFromElement(addToCartVerifyMsg);
    }

}

