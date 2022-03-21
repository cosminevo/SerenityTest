package ubb.com.models;
import ubb.com.models.serializers.*;

public class InitModels {


    public CreateBoard setBoardDetails(String boardName, String key, String token) {
        CreateBoard createBoard = new CreateBoard();
        createBoard.setKey(key);
        createBoard.setName(boardName);
        createBoard.setToken(token);
        return createBoard;
    }


    public CreateList setListDetails(String listName, String key, String token, String boardId) {
        CreateList createList = new CreateList();
        createList.setName(listName);
        createList.setToken(token);
        createList.setKey(key);
        createList.setIdBoard(boardId);
        return createList;
    }

    public CreateCard setCardDetails(String cardName,  String key, String token, String listId ) {
        CreateCard createCard = new CreateCard();
        createCard.setKey(key);
        createCard.setToken(token);
        createCard.setName(cardName);
        createCard.setPos("top");
        createCard.setDue(null);
        createCard.setIdList(listId);
        return createCard;
    }

    public CloseBoard setBoardClosed(String key, String token) {
        CloseBoard closeBoard = new CloseBoard();
        closeBoard.setValue("true");
        closeBoard.setKey(key);
        closeBoard.setToken(token);
        return closeBoard;
    }
}
