package ubb.com.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.support.FindBy;

//Page URL
@DefaultUrl("https://trello.com/login")
public class LoginPage extends PageObject {

    // Page Elements
    @FindBy(id = "user")
    private WebElementFacade usernameField;
    @FindBy(id = "password")
    private WebElementFacade passwordField;
    @FindBy(id = "login-submit")
    private WebElementFacade logInButton;
    @FindBy(id = "header")
    private WebElementFacade headerDiv;
    @FindBy(css = "input#login")
    private WebElementFacade loginFirstButton;


    // Methods
    public void setUsernameField(String username) {
        waitFor(usernameField);
        typeInto(usernameField, username);
    }

    public void setPasswordField(String password) {
        waitFor(passwordField);
        passwordField.waitUntilClickable();
        typeInto(passwordField, password);
    }

    public void clickLoginButton() {
        logInButton.click();
    }

    public void waitForLoggedIn() {
//        waitFor(headerDiv);
    }

    public void clickLoginFirst(){
        waitFor(loginFirstButton);
        clickOn(loginFirstButton);
    }
}
