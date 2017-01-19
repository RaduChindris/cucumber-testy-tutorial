package org.fasttrackit.Automations;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import org.fasttrackit.util.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
    @Test
    public void validareLoginTest() {
        System.out.println("ready");
        driver.get("https://rawgit.com/sdl/Testy/master/src/test/functional/app-demo/login.html");

        WebElement emailfield = driver.findElement(By.id("email"));
        WebElement passField = driver.findElement(By.name("password"));
        WebElement loginBtn = driver.findElement(By.className("login-btn"));

        System.out.println("enter email");
        emailfield.sendKeys("eu@fast.com");
        System.out.println("ennter password");
        passField.sendKeys("eu.pass");
        System.out.println("log in");
        loginBtn.click();

        try {
            WebElement logoutBtn = driver.findElement(By.linkText("Logout"));
            logoutBtn.click();

        } catch (NoSuchElementException er) {
            Assert.fail("Could not log in log button could not be radu found");
        }
    }

    @Test
    public void validateErrorMessageNoEmailPassword() {
        System.out.println("ready");
        driver.get("https://rawgit.com/sdl/Testy/master/src/test/functional/app-demo/login.html");


        WebElement loginBtn = driver.findElement(By.className("login-btn"));
        loginBtn.click();
        WebElement mesajeroare = driver.findElement(By.className("error-msg"));
        Assert.assertEquals( mesajeroare.getText(), "Please enter your email!","Not the same cand nu este nici adresa nici email");
    }

    @Test
    public void validateErrorMessageNoPassword() {
        System.out.println("ready");
        driver.get("https://rawgit.com/sdl/Testy/master/src/test/functional/app-demo/login.html");


        WebElement email = driver.findElement(By.id("email"));
        WebElement loginBtn = driver.findElement(By.className("login-btn"));
        WebElement mesajeroare = driver.findElement(By.className("error-msg"));

        email.sendKeys("eu@fast.com");
        loginBtn.click();
        Assert.assertEquals(mesajeroare.getText(), "Please enter your password!","Not the same cand lipseste adresa");

    }

    @Test
    public void validateErrorMessageNoEmail() {
        System.out.println("ready");
        driver.get("https://rawgit.com/sdl/Testy/master/src/test/functional/app-demo/login.html");


        WebElement password = driver.findElement(By.name("password"));
        WebElement loginBtn = driver.findElement(By.className("login-btn"));
        WebElement mesajeroare = driver.findElement(By.className("error-msg"));

        password.sendKeys("eu.pass");
        loginBtn.click();
        Assert.assertEquals(mesajeroare.getText(), "Please enter your email!", "Not the same cand lipseste adresa");

    }

    @Test
    public void validareWrongEmail() {
        System.out.println("ready");
        driver.get("https://rawgit.com/sdl/Testy/master/src/test/functional/app-demo/login.html");

        WebElement emailfield = driver.findElement(By.id("email"));
        WebElement passField = driver.findElement(By.name("password"));
        WebElement loginBtn = driver.findElement(By.className("login-btn"));
        WebElement mesajeroare=driver.findElement(By.className("error-msg"));



        emailfield.sendKeys("euradu@fast.com");
        passField.sendKeys("eu.pass");
        loginBtn.click();
        Assert.assertEquals(mesajeroare.getText(),"Invalid user or password!","Adresa de email gresita");

    }

    @Test
    public void validareWrongPssword() {
        System.out.println("ready");
        driver.get("https://rawgit.com/sdl/Testy/master/src/test/functional/app-demo/login.html");

        WebElement emailfield = driver.findElement(By.id("email"));
        WebElement passField = driver.findElement(By.name("password"));
        WebElement loginBtn = driver.findElement(By.className("login-btn"));
        WebElement mesajeroare=driver.findElement(By.className("error-msg"));



        emailfield.sendKeys("eu@fast.com");
        passField.sendKeys("euradu.pass");
        loginBtn.click();
        Assert.assertEquals(mesajeroare.getText(),"Invalid user or password!","Adresa de email gresita");

    }
}




