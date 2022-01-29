import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase{

    @Test
    public void LoginPositiveTest(){
        ////*[text()='LOGIN']
        WebElement loginBtn = wd.findElement(By.linkText("LOGIN"));
        //CLICK
        loginBtn.click();

        //FIND E-MAIL
        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
        wd.findElement(By.xpath("//input[1]"));

        //CLICK E-MAIL
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys("noa@gmail.com");

        //find password
        WebElement passInput = wd.findElement(By.xpath("//input[2]"));
        passInput.click();
        passInput.clear();
        passInput.sendKeys("Nnoa12345$");

        //find Login Button
        WebElement clickLogin=wd.findElement(By.xpath("//button[1]"));
        clickLogin.click();

        //check sign out in present
          Assert.assertTrue(wd.findElement(By.xpath("//button[text()='Sign Out']")).isDisplayed());



    }

    @Test
    public void loginTest2(){
        String eMail = "noa@gmail.com";
        String password = "Nnoa12345$";

        openLoginRegForm();
        fillRegForm(eMail,password);
        submitLoginForm();

        Assert.assertTrue(isElementPresent(By.xpath("//button[text()='Sign Out']")));

    }


}
