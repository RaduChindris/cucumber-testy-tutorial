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
    public void validareLoginTest() {
        openBrowser();


        try {
            WebElement logoutBtn = driver.findElement(By.linkText("Logout"));
            logoutBtn.click();

        } catch (NoSuchElementException er) {
            Assert.fail("Could not log in log button could not be radu found");
        }
    }


    @Test
    public void validateErrorMessageNoEmailPassword() {
        openBrowser();


        WebElement loginBtn = driver.findElement(By.className("login-btn"));
        loginBtn.click();
        WebElement mesajeroare = driver.findElement(By.className("error-msg"));
        Assert.assertEquals(mesajeroare.getText(), "Please enter your email!", "Not the same cand nu este nici adresa nici email");
    }

    @Test
    public void validateErrorMessageNoPassword() {
        openBrowser();


        WebElement email = driver.findElement(By.id("email"));
        WebElement loginBtn = driver.findElement(By.className("login-btn"));
        WebElement mesajeroare = driver.findElement(By.className("error-msg"));

        email.sendKeys("eu@fast.com");
        loginBtn.click();
        Assert.assertEquals(mesajeroare.getText(), "Please enter your password!", "Not the same cand lipseste adresa");

    }

    @Test
    public void validateErrorMessageNoEmail() {
        openBrowser();


        WebElement password = driver.findElement(By.name("password"));
        WebElement loginBtn = driver.findElement(By.className("login-btn"));
        WebElement mesajeroare = driver.findElement(By.className("error-msg"));

        password.sendKeys("eu.pass");
        loginBtn.click();
        Assert.assertEquals(mesajeroare.getText(), "Please enter your email!", "Not the same cand lipseste adresa");

    }

    @Test
    public void validareWrongEmail() {
        openBrowser();

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
        openBrowser();

        login("eu@fast.com", "euradu.pass");
        WebElement mesajeroare = driver.findElement(By.className("error-msg"));
        // Assert.assertEquals(mesajeroare.getText(),"Invalid user or password!");
        assertThat(mesajeroare.getText(), is("Invalid user or password!"));

    }



    public void login(String email,String password){
        WebElement emailfield = driver.findElement(By.id("email"));
        WebElement passField = driver.findElement(By.name("password"));
        WebElement loginBtn = driver.findElement(By.className("login-btn"));

        System.out.println("enter email:"+email);
        emailfield.sendKeys(email);
        System.out.println("ennter password:" + password);
        passField.sendKeys(password);
        System.out.println("log in");
        loginBtn.click();


    }

    private void openBrowser() {
        System.out.println("ready");
        driver.get("https://rawgit.com/sdl/Testy/master/src/test/functional/app-demo/login.html");
    }
}




