package ubb.com.pages;


import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import ubb.com.util.TrelloConstants;

import java.util.List;

public class BoardsPage extends PageObject {

    @FindBy(className = "boards-page-board-section-list-item")
    public List<WebElementFacade> boardList;


    public void selectBoard(String boardName) {
        getDriver().get("https://trello.com/cosminciocan1/boards");
//        waitABit(1000);
        waitFor(boardList.get(0));
        for (WebElementFacade element : boardList) {
            if (element.getText().toLowerCase().contains(boardName.toLowerCase())) {
                TrelloConstants.myBoardUrl = element.findElement(By.cssSelector(".board-tile")).getAttribute("href");
                element.click();
                break;
            }
        }
    }
}
