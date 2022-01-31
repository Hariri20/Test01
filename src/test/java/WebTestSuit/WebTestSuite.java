package WebTestSuit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ui.*;

public class WebTestSuite extends BaseTestSuit
{
    @Test
    public void test01() {
            Menu myMenu = new Menu(driver);
            myMenu.clickForms();
            FormsPage myForm = new FormsPage(driver);
            myForm.clickSubmit();
            Assertions.assertEquals("Your name is required", myForm.getNameErrorMessage());
            Assertions.assertEquals("Your email is required", myForm.getEmailErrorMessage());
            Assertions.assertEquals("You must agree to continue", myForm.getNameAgreeMessage());
    }
    @Test
    public void test02()
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
}




