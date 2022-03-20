package tests;

import manager.MyDataProvider;
import models.Contact;
import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase{

    @BeforeMethod (alwaysRun = true)
    public void preCondition() {
        if (app.getUserHelper().isLogged()) {
            app.getUserHelper().logOut();
        }
    }

//    @Test
//    public void LoginPositiveTest(){
//        ////*[text()='LOGIN']
//        WebElement loginBtn = app.getUserHelper().findElement(By.linkText("LOGIN"));
//        //CLICK
//        loginBtn.click();
//
//        //FIND E-MAIL
//        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
//        wd.findElement(By.xpath("//input[1]"));
//
//        //CLICK E-MAIL
//        emailInput.click();
//        emailInput.clear();
//        emailInput.sendKeys("noa@gmail.com");
//
//        //find password
//        WebElement passInput = wd.findElement(By.xpath("//input[2]"));
//        passInput.click();
//        passInput.clear();
//        passInput.sendKeys("Nnoa12345$");
//
//        //find Login Button
//        WebElement clickLogin=wd.findElement(By.xpath("//button[1]"));
//        clickLogin.click();
//
//        //check sign out in present
//          Assert.assertTrue(wd.findElement(By.xpath("//button[text()='Sign Out']")).isDisplayed());



 //   }

 @Test(dataProvider = "loginValidData",dataProviderClass = MyDataProvider.class)
 public void loginPositiveTestDataProvider(String email, String password){

     loger.info("User starts login test with e-mail: "+email+
             " && password: "+password);

     app.getUserHelper().openLoginRegForm();
     app.getUserHelper().fillRegForm(email,password);
     app.getUserHelper().submitLoginForm();

     Assert.assertTrue(app.getUserHelper().isLogged());

 }

    @Test(dataProvider = "loginValidData",dataProviderClass = MyDataProvider.class)
    public void loginPositiveTestModelDataProvider(User user){

        loger.info("User starts login test with data: ----> "+user.toString());

        app.getUserHelper().openLoginRegForm();
        app.getUserHelper().fillRegForm(user);
        app.getUserHelper().submitLoginForm();

        Assert.assertTrue(app.getUserHelper().isLogged());

    }

    @Test(groups = {"web"})
    public void loginTest2(){
        User user = new User().setPassword("Nnoa12345$").setWithMail("noa@gmail.com");
//        String eMail = "noa@gmail.com";
//        String password = "Nnoa12345$";

        app.getUserHelper().openLoginRegForm();
        app.getUserHelper().fillRegForm(user);
        app.getUserHelper().submitLoginForm();

        Assert.assertTrue(app.getUserHelper().isLogged());

    }

    @Test
    public void loginTestWrongEmail(){
        User user = new User().setPassword("Nnoa12345$").setWithMail("noagmail.com");
//        String eMail = "noagmail.com";
//        String password = "Nnoa12345$";

        app.getUserHelper().openLoginRegForm();
        app.getUserHelper().fillRegForm(user);
        app.getUserHelper().submitLoginForm();

        Assert.assertTrue(app.getUserHelper().isAlertPresent());
        Assert.assertFalse(app.getUserHelper().isLogged());

    }




}
