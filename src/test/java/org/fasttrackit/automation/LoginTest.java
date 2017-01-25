package org.fasttrackit.automation;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import org.fasttrackit.util.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LoginTest extends TestBase {



    @Test
    public void validateErrorMessageNoEmailPassword() {
        SeleniumTestsUtil.openBrowser(driver);


        WebElement loginBtn = driver.findElement(By.className("login-btn"));
        loginBtn.click();
        WebElement mesajeroare = driver.findElement(By.className("error-msg"));
        Assert.assertEquals(mesajeroare.getText(), "Please enter your email!", "Not the same cand nu este nici adresa nici email");
    }

    @Test
    public void validateErrorMessageNoPassword() {
        SeleniumTestsUtil.openBrowser(driver);


        WebElement email = driver.findElement(By.id("email"));
        WebElement loginBtn = driver.findElement(By.className("login-btn"));
        WebElement mesajeroare = driver.findElement(By.className("error-msg"));

        email.sendKeys("eu@fast.com");
        loginBtn.click();
        Assert.assertEquals(mesajeroare.getText(), "Please enter your password!", "Not the same cand lipseste adresa");

    }

    @Test
    public void validateErrorMessageNoEmail() {
        SeleniumTestsUtil.openBrowser(driver);


        WebElement password = driver.findElement(By.name("password"));
        WebElement loginBtn = driver.findElement(By.className("login-btn"));
        WebElement mesajeroare = driver.findElement(By.className("error-msg"));

        password.sendKeys("eu.pass");
        loginBtn.click();
        Assert.assertEquals(mesajeroare.getText(), "Please enter your email!", "Not the same cand lipseste adresa");

    }

    @Test
    public void validareWrongEmail() {
        SeleniumTestsUtil.openBrowser(driver);

        WebElement emailfield = driver.findElement(By.id("email"));
        WebElement passField = driver.findElement(By.name("password"));
        WebElement loginBtn = driver.findElement(By.className("login-btn"));
        WebElement mesajeroare = driver.findElement(By.className("error-msg"));


        emailfield.sendKeys("euradu@fast.com");
        passField.sendKeys("eu.pass");
        loginBtn.click();
        Assert.assertEquals(mesajeroare.getText(), "Invalid user or password!", "Adresa de email gresita");

    }

    @Test
    public void validareWrongPssword() {
        SeleniumTestsUtil.openBrowser(driver);

        SeleniumTestsUtil.login("eu@fast.com", "euradu.pass",driver);
        WebElement mesajeroare = driver.findElement(By.className("error-msg"));
        // Assert.assertEquals(mesajeroare.getText(),"Invalid user or password!");
        assertThat(mesajeroare.getText(), is("Invalid user or password!"));

    }


}




