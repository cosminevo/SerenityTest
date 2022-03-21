package ubb.com.steps.api;

import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import ubb.com.models.InitModels;
import ubb.com.models.UserDetails;
import ubb.com.models.deserializers.CreatedBoard.CreatedBoard;
import ubb.com.models.deserializers.CreatedCard.CreatedCard;
import ubb.com.models.deserializers.CreatedList.CreatedList;
import ubb.com.models.serializers.*;

import ubb.com.util.TrelloConstants;

public class ApiSetup extends AbstractApiSteps {

    private UserDetails userDetails = new UserDetails();
    private InitModels init = new InitModels();

    @Step
    public void setUserKeyAndToken(String key, String token) {
        userDetails.setKey(key);
        userDetails.setToken(token);
    }

    @Step
    public void createBoard(String boardName) {
        waitABit(TrelloConstants.defaultWait);
        CreateBoard createBoard = init.setBoardDetails(boardName,
                userDetails.getKey(),
                userDetails.getToken());
        userDetails.setBoardId(
                createResource(TrelloConstants.boardsUrl,
                        createBoard,
                        CreatedBoard.class)
                        .getId());
    }

    @Step
    public void createListOnTheBoard(String listname) {
        waitABit(TrelloConstants.defaultWait);
        CreateList createList = init.setListDetails(
                listname,
                userDetails.getKey(),
                userDetails.getToken(),
                userDetails.getBoardId());
        userDetails.setListId(
                createResource(TrelloConstants.listsUrl,
                        createList,
                        CreatedList.class)
                        .getId());
    }

    @Step
    public void createCardOnTheList(String cardName) {
        waitABit(TrelloConstants.defaultWait);
        CreateCard createCard = init.setCardDetails(
                cardName,
                userDetails.getKey(),
                userDetails.getToken(),
                userDetails.getListId()
        );
        createResource(TrelloConstants.cardsUrl,
                createCard,
                CreatedCard.class);
    }

    @Step
    public void closeTheCreatedBoard() {
        waitABit(TrelloConstants.defaultWait);
        CloseBoard closeBoard = init.setBoardClosed(
                userDetails.getKey(),
                userDetails.getToken()
        );
        System.out.println(TrelloConstants.boardsUrl + "/" + userDetails.getBoardId() + "/closed");
        Assert.assertTrue(
                createResourcePut(
                        TrelloConstants.boardsUrl + "/" + userDetails.getBoardId() + "/closed",
                        closeBoard,
                        CreatedCard.class)
                        .getClosed());
    }
}
