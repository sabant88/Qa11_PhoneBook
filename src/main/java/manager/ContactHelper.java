package manager;

import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ContactHelper extends BaseHelper{
    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    Logger loger = LoggerFactory.getLogger(BaseHelper.class);


    public void openContactForm() {
        click(By.xpath("//a[@href='/add']"));
    }

    public void fillContactForm(Contact contact) {

        type(By.xpath("//input[@placeholder='Name']"), contact.getName());
        type(By.xpath("//input[@placeholder='Last Name']"), contact.getLastName());
        type(By.xpath("//input[@placeholder='Phone']"), contact.getPhone());
        type(By.xpath("//input[@placeholder='email']"), contact.getEMail());
        type(By.xpath("//input[@placeholder='Address']"), contact.getAddress());
        type(By.xpath("//input[@placeholder='description']"), contact.getDescription());

    }

    public void saveContact() {
        click(By.xpath("//b"));
    }

    public int countOfContacts() {
        return wd.findElements(By.cssSelector(".contact-item_card__2SOIM")).size();//not count
   }

    public boolean isContactCreateByName(String name) {
        List<WebElement> list = wd.findElements(By.cssSelector("h2"));

        for (WebElement e:list) {
          if(e.getText().equals(name))
          return true;
        }
        return false;
    }

    public boolean isContactCreateByPhone(String phone) {
        List<WebElement> list = wd.findElements(By.cssSelector("h3"));

        for (WebElement e:list) {
            if(e.getText().equals(phone))
            return true;
        }
        return false;

    }

    public void deleteContact() {
        WebElement contact = wd.findElement(By.cssSelector(".contact-item_card__2SOIM"));
        contact.click();
        click(By.xpath("//button[.='Remove']"));
    }

    public int deleteContactCount(){
        int countBefore= countOfContacts();
        loger.info("before remove contact tests- contact was ---->"+countBefore);

        if(!isContactsListIsEmpty()){
            String phone=wd.findElement(By.cssSelector(".contact-item_card__2SOIM h3")).getText();
            loger.info("the removed number was ----> "+phone);
            wd.findElement(By.cssSelector(".contact-item_card__2SOIM")).click();
            wd.findElement(By.xpath("//button[.='Remove']")).click();
            pause(1000);
        }
        int countAfter=countOfContacts();
        loger.info("After removing one contact the count is --->"+countAfter);

        return countAfter-countBefore;
    }

    public boolean isContactsListIsEmpty() {
        return wd.findElements(By.cssSelector(".contact-item_card__2SOIM h3")).isEmpty();
    }

    public void providerOfContacts() {
        if(countOfContacts()<3){
            int index = (int)(System.currentTimeMillis()/1000)%3600;
            for(int i =0;i<3;i++){
                Contact contact = Contact.builder()
                        .name("Tolik")
                        .lastName("Popkin")
                        .phone("101"+i+index)
                        .eMail("pop"+i+index+"@kin.com")
                        .address("Africa")
                        .description("Hot Place").build();

                openContactForm();
                fillContactForm(contact);
                saveContact();
                pause(2000);

            }
        }
    }

    public void removeAllContactsNotWork() {
        List <WebElement> list = wd.findElements(By.cssSelector(".contact-item_card__2SOIM"));

        for (WebElement el:list){
            el.click();
            wd.findElement(By.xpath("//button[text()='Remove']")).click();
            pause(500);
        }
    }

    public void deleteAllContacts() {

        while (wd.findElements(By.cssSelector(".contact-item_card__2SOIM")).size()!=0){
            deleteContactCount();
        }
    }
}
