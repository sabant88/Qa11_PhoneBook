package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase {

    @BeforeMethod(alwaysRun = true)
    public void preCondition() {

        if (app.getUserHelper().isLogged()) {
            app.getUserHelper().logOut();
        }
    }

    @Test(groups = {"web"})
    public void regTestPositive() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        String eMail = "noa" + i + "@gmail.com";
        String password = "Nnoa12345$";
        System.out.println("Email: " + eMail);

        app.getUserHelper().openLoginRegForm();
        app.getUserHelper().fillRegForm(eMail, password);
        app.getUserHelper().submitRegForm();
        app.getUserHelper().pause(1000);

        Assert.assertTrue(app.getUserHelper().isLogged());

    }

    @Test
    public void regTestNegativeWrongEmail() {
        app.getUserHelper().takeScreenShots("src/test/screenshots");

        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        String eMail = "noa" + i + "gmail.com";
        String password = "Nnoa12$" + i;
        System.out.println("Email: " + eMail);

        app.getUserHelper().openLoginRegForm();
        app.getUserHelper().fillRegForm(eMail, password);
        app.getUserHelper().submitRegForm();
      //  app.getUserHelper().pause(3000);

        Assert.assertTrue(app.getUserHelper().isAlertPresent());

        Assert.assertTrue(app.getUserHelper().isElementPresent(By.linkText("LOGIN")));
    }


}

