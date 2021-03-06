package com.accesshq.test.WebTestSuit;
import com.accesshq.test.ui.FormsPage;
import com.accesshq.test.ui.Menu;
import com.accesshq.test.ui.States;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebTest extends BaseTest
{

    @Test
    public void ValidationErrorsAreDisplayed()
    {
            Menu myMenu = new Menu(driver);
            myMenu.clickForms();
            FormsPage myForm = new FormsPage(driver);
            myForm.clickSubmit();
            Assertions.assertEquals("Your name is required", myForm.getNameErrorMessage());
            Assertions.assertEquals("Your email is required", myForm.getEmailErrorMessage());
            Assertions.assertEquals("You must agree to continue", myForm.getNameAgreeMessage());
    }


    @Test
    public void SubmitFormTest()
    {
        Menu myMenu = new Menu(driver);
        myMenu.clickForms();
        FormsPage myForm = new FormsPage(driver);
        myForm.setName("Iman");
        myForm.setEmail("iman@email.com");
        myForm.openStateComboBox();
        myForm.SelectState(States.VIC.toString());
        myForm.selectAgree();
        myForm.clickSubmit();
    }

    @Test
    public void submitFormAndVerifyThankYOu()
    {
        //arrange
        Menu myMenu = new Menu(driver);
        myMenu.clickForms();
        FormsPage myForm = new FormsPage(driver);

        //act
        //enter value into
        String name = "Iman";
        myForm.setName(name);
        myForm.setEmail("iman@email.com");
        myForm.openStateComboBox();
        myForm.SelectState(States.VIC.toString());
        myForm.selectAgree();
        myForm.clickSubmit();

        new WebDriverWait(driver,10).until(d -> myForm.isPopupIsVisible());

        String expected = "Thanks for your feedback "+ name;
        // asset that the thanks message pop-up with the right message

        Assertions.assertEquals(expected,myForm.getPopupMessage());
    }
}




