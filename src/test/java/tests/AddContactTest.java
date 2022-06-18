package tests;

import manager.MyDataProvider;
import models.Contact;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTest extends  TestBase{

    @BeforeMethod(alwaysRun = true)
    public void preCondition(){
        if(!app.getUserHelper().isLogged()){
            app.getUserHelper().login(new User().setWithMail("noa@gmail.com").setPassword("Nnoa12345$"));

        }
    }

    @Test (invocationCount = 3,groups = {"web"}) //(invocationCount = 4)
    public void addNewContactSucces(){
//        if(count >3){
//            removeAllContacts;
//        }

        int counterStart = app.getContactHelper().countOfContacts();
        loger.info("the test 'Add new contact' starts with count of contact in the start ----> " + counterStart);

        int i = (int)System.currentTimeMillis()/1000%3600;
        System.out.println();

        Contact contact = Contact.builder()
                .address("Rome")
                .lastName("Totti")
                .name("Franchesco")
                .description("Forza Roma")
                .eMail("totti" + i + "@gmail.com")
                .phone("101010" + i)
                .build();

        app.getContactHelper().openContactForm();
        app.getContactHelper().fillContactForm(contact);
        app.getContactHelper().saveContact();

        int counterEnd = app.getContactHelper().countOfContacts();
        loger.info("the test 'Add new contact' ends with count of contact in the end ----> " + counterEnd);

        app.getUserHelper().pause(2000);

        Assert.assertEquals(counterEnd-counterStart, 1);
        Assert.assertTrue(app.getContactHelper().isContactCreateByName(contact.getName()));
        Assert.assertTrue(app.getContactHelper().isContactCreateByPhone(contact.getPhone()));

    }

    @Test (dataProvider = "dt")
    public void addNewContactSuccesNew(){
//        if(count >3){
//            removeAllContacts;
//        }
        int counterStart = app.getContactHelper().countOfContacts();
        loger.info("the test 'Add new contact' starts with count of contact in the start ----> " + counterStart);

        int i = (int)System.currentTimeMillis()/1000%3600;
        System.out.println();

          Contact contact = Contact.builder()
                .address("Rome")
                .lastName("Totti")
                .name("Franchesco")
                .description("Forza Roma")
                .eMail("totti" + i + "@gmail.com")
                .phone("101010" + i)
                .build();

        app.getContactHelper().openContactForm();
        app.getContactHelper().fillContactForm(contact);
        app.getContactHelper().saveContact();

        int counterEnd = app.getContactHelper().countOfContacts();
        loger.info("the test 'Add new contact' ends with count of contact in the end ----> " + counterEnd);

        app.getUserHelper().pause(2000);

        Assert.assertEquals(counterEnd-counterStart, 1);
        Assert.assertTrue(app.getContactHelper().isContactCreateByName(contact.getName()));
        Assert.assertTrue(app.getContactHelper().isContactCreateByPhone(contact.getPhone()));

    }

    //add contactValidDataCSV
    @Test (dataProvider = "addContactValidDataCSV",dataProviderClass = MyDataProvider.class,groups = {"web"})
    public void addNewContactSuccesCsv(Contact contact){
//        if(count >3){
//            removeAllContacts;
//        }

        int counterStart = app.getContactHelper().countOfContacts();
        loger.info("the test 'Add new contact' starts with count of contact in the start ----> " + counterStart);
        loger.info("the test 'Add new contact' starts with data ----> " + contact.toString());

        app.getContactHelper().openContactForm();
        app.getContactHelper().fillContactForm(contact);
        app.getContactHelper().saveContact();


        int counterEnd = app.getContactHelper().countOfContacts();
        loger.info("the test 'Add new contact' ends with count of contact in the end ----> " + counterEnd);

        app.getUserHelper().pause(2000);

        Assert.assertEquals(counterEnd-counterStart, 1);
        Assert.assertTrue(app.getContactHelper().isContactCreateByName(contact.getName()));
        Assert.assertTrue(app.getContactHelper().isContactCreateByPhone(contact.getPhone()));

    }


}
