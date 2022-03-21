package ubb.com.steps.serenity;


import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;
import ubb.com.pages.BoardsPage;
import ubb.com.pages.LoginPage;
import ubb.com.pages.MyBoardPage;
import ubb.com.util.TrelloConstants;

public class UiTestSteps extends ScenarioSteps {

    private BoardsPage boardsPage;
    private LoginPage loginPage;
    private MyBoardPage myBoardPage;


    @Step
    public void logsIn(String username, String password) {
        loginPage.open();
        waitABit(TrelloConstants.defaultWait);
        loginPage.setUsernameField(username);
        loginPage.clickLoginFirst();
        loginPage.setPasswordField(password);
        loginPage.clickLoginButton();
        loginPage.waitForLoggedIn();
    }

    @Step
    public void selectsTheCreatedBoard(String boardName) {
        boardsPage.selectBoard(boardName);
    }

    @Step
    public void selectsTheCardAndMovesIt(String cardName) {
        waitABit(TrelloConstants.defaultWait);
        Assert.assertTrue("The created card not found! ",
                myBoardPage.myCardDisplayed());
        myBoardPage.selectMyCard(cardName);
        waitABit(TrelloConstants.defaultWait);
    }

    @Step
    public void deletesTheBoard() {
        waitABit(TrelloConstants.defaultWait);
        myBoardPage.deleteAllBoards();
    }

}


