package com.sitharaj.test.automation.helloworld;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public class HelloWorldStepdefs {
    private AndroidDriver<MobileElement> driver;
    private WebDriverWait wait;

    @When("^User Pressed HelloWorld Button$")
    public void userPressedHelloWorldButton() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "XT1562");
        capabilities.setCapability("udid", "emulator-5554");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "9.0");
        capabilities.setCapability("appPackage", "com.sitharaj.automation.helloworld");
        capabilities.setCapability("appActivity", "com.sitharaj.automation.helloworld.MainActivity");

        driver = new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), capabilities);

        wait = new WebDriverWait(driver, 10);

        driver.findElement(By.id("com.sitharaj.automation.helloworld:id/helloWorldBtn")).click();
    }

    @Then("^HelloWorld Text Element Should Show HelloWorld Message To User$")
    public void helloworldTextElementShouldShowHelloWorldMessageToUser() {
        Assert.assertTrue(driver.findElement(By.id("com.sitharaj.automation.helloworld:id/helloWorldText")).getText().equalsIgnoreCase("HelloWorld"));
        driver.quit();
    }
}
