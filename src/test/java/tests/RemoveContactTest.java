package tests;

import models.User;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTest extends TestBase{
    //before if login
    @BeforeMethod(alwaysRun = true)
    public void preCondition(){
        if(!app.getUserHelper().isLogged()){
            app.getUserHelper().login(new User().setWithMail("noa@gmail.com").setPassword("Nnoa12345$"));

            app.getContactHelper().providerOfContacts();

        }
    }



    //delete contact
    @Test(priority = 1)
    public void removeContact(){
        app.getContactHelper().deleteContact();


    }

    @Test(priority = 2)
    public void removeContactCount(){
        Assert.assertEquals(app.getContactHelper().deleteContactCount(),-1);
    }


    //delete all contacts
    @Test(priority = 3)
    public void removeAllContactsTest(){
        app.getContactHelper().deleteAllContacts();
        Assert.assertTrue(app.getContactHelper().isContactsListIsEmpty());

    }

}
