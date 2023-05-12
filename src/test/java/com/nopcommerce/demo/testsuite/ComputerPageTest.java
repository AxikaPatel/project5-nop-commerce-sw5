package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.pages.BuildYourOwnComputerPage;
import com.nopcommerce.demo.pages.ComputerPage;
import com.nopcommerce.demo.pages.DesktopsPage;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.testdata.TestData;

@Listeners(CustomListeners.class)
public class ComputerPageTest extends BaseTest
{
    HomePage homePage;
    ComputerPage computerPage;
    DesktopsPage desktopsPage;
    BuildYourOwnComputerPage buildYourOwnComputerPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt()
    {
        homePage = new HomePage();
        computerPage = new ComputerPage();
        desktopsPage = new DesktopsPage();
        buildYourOwnComputerPage = new BuildYourOwnComputerPage();

    }

    @Test
    public void  verifyUserShouldNavigateToComputerPageSuccessfully()
    {
        computerPage.clickOnComputerLink();
        computerPage.verifyComputerText();
    }

    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully()
    {
        computerPage.clickOnComputerLink();
        desktopsPage.clickOnDesktopClick();
        desktopsPage.verifyDesktopText();
    }

    @Test(dataProvider = "Build your own Compute",dataProviderClass = TestData.class,groups = {"sanity","regression"})

    public  void VerifyThatUserShouldBuildYouOwnComputerAndAddThemToCartSuccessfully(String processor, String ram, String hdd, String os, String software)
    {
        verifyUserShouldNavigateToDesktopsPageSuccessfully();
        buildYourOwnComputerPage.clickONProductBuildYourOwnComputer();
        buildYourOwnComputerPage.buildYourOwnComputerSelection(processor,ram);
        if (hdd.equalsIgnoreCase("320 GB")){
            buildYourOwnComputerPage.clickOnHDD320GB();
        }else {
            buildYourOwnComputerPage.clickOnHDD400GB();
        }

        if (os.equalsIgnoreCase("Vista Home [+$50.00]")){
            buildYourOwnComputerPage.setOsVistaHome();
        }else {
            buildYourOwnComputerPage.setOsVistaPremium();
        }
        buildYourOwnComputerPage.buildOs(os);

        buildYourOwnComputerPage.setMsOffice();
        if(software.equalsIgnoreCase("Microsoft Office [+$50.00]")){
            buildYourOwnComputerPage.setMsOffice();
        } else if (software.equalsIgnoreCase("Acrobat Reader [+$10.00]")) {
            buildYourOwnComputerPage.setAcrobatReader();

        }else {
            buildYourOwnComputerPage.setCommander();
        }
        buildYourOwnComputerPage.buildAddToCArt();
    }


    }

