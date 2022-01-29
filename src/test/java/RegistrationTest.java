import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase {

        @Test
        public void regTestPositive () {
            int i = (int) (System.currentTimeMillis() / 1000) % 3600;
            String eMail = "noa" + i + "@gmail.com";
            String password = "Nnoa12345$";
            System.out.println("Email: " + eMail);

            openLoginRegForm();
            fillRegForm(eMail,password);
            submitRegForm();

            Assert.assertTrue(isElementPresent(By.xpath("//button[text()='Sign Out']")));

        }

         @Test
        public void regTestNegativeWrongEmail() {
            int i = (int) (System.currentTimeMillis() / 1000) % 3600;
            String eMail = "noa" + i + "gmail.com";
            String password = "Nnoa12345$";
            System.out.println("Email: " + eMail);

            openLoginRegForm();
            fillRegForm(eMail, password);
            submitRegForm();

           Assert.assertTrue(isElementPresent(By.linkText("LOGIN")));
    }

}

