package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends BaseHelper {

    public UserHelper(WebDriver wd) {
        super(wd);
    }

    public void submitRegForm() {
        click(By.xpath("//button[2]"));
    }


    public void fillRegForm(String eMail, String password) {
        type(By.xpath("//input[1]"), eMail);

        type(By.xpath("//input[2]"), password);

    }

    public void fillRegForm(User user) {
        type(By.xpath("//input[1]"), user.geteMail());

        type(By.xpath("//input[2]"), user.getPassword());

    }


    public void openLoginRegForm() {
        if(wd.findElement(By.linkText("LOGIN")).isDisplayed()) {
            click(By.linkText("LOGIN"));
        }
    }


    public void submitLoginForm() {
        click(By.xpath("//button[1]"));
    }

    public boolean isLogged() {

        return isElementPresent(By.xpath("//button[text()='Sign Out']"));
    }

    public void logOut() {

        click(By.xpath("//button[text()='Sign Out']"));

    }


    public void login(User user) {
        openLoginRegForm();
        fillRegForm(user);
        submitLoginForm();
        pause(2000);

    }
}

