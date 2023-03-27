package ubb.com.features.trello;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.Qualifier;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import ubb.com.steps.api.ApiSetup;
import ubb.com.steps.serenity.UiTestSteps;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = "testdata/data.csv")
public class TrelloDemoTest {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    private String username, password, key, token;
    private String boardName = "TestBoardName";
    private String listName = "TestListName";
    private String cardName = "TestCardName";

    @Qualifier
    public String qualifier() {
        return username;
    }

    @Steps
    public ApiSetup setup;

    @Steps
    public UiTestSteps user;

    @Test
    public void checkTheDragAndDropFunctionality() {
        setup.setUserKeyAndToken(key, token);
        user.logsIn(username, password);
        setup.createBoard(boardName);
        user.selectsTheCreatedBoard(boardName);
        setup.createListOnTheBoard(listName);
        setup.createCardOnTheList(cardName);
        user.selectsTheCardAndMovesIt(cardName);
        setup.closeTheCreatedBoard();
        user.deletesTheBoard();
    }

     @Pending @Test @Ignore
    public void checkTheDragAndDropFunctionalityFailingTest() {
        user.logsIn(username, password);
        user.selectsTheCreatedBoard(boardName);
        user.selectsTheCardAndMovesIt(cardName);
        user.deletesTheBoard();
    }

    @Pending @Test @Ignore
    public void checkTheDragAndDropFunctionalityPendingTest() {
        user.logsIn(username, password);
        user.selectsTheCreatedBoard(boardName);
        user.selectsTheCardAndMovesIt(String.valueOf(12));
//        TODO: finish this!
    }

}
