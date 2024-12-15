package screen.updateStore.Controller;
import cart.Cart;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import media.Book;
import screen.StoreScreen;
import store.Store;

public class AddBookController {
    private Store store;
    private Cart cart;
    @FXML
    private TextField tfID;

    @FXML
    private TextField tfCategory;

    @FXML
    private TextField tfCost;

    @FXML
    private TextField tfTitle;

    public AddBookController(Store store, Cart cart){
        super();
        this.store = store;
        this.cart = cart;
    }

    @FXML
    void addBook(ActionEvent event) {
        store.addMedia(new Book(Integer.parseInt(tfID.getText()), tfTitle.getText(),
                tfCategory.getText(), Float.parseFloat(tfCost.getText())));
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Add Book");
        alert.setHeaderText("Add Book Successfully!");
        alert.showAndWait();
    }

    @FXML
    void viewStore(ActionEvent event) {
        new StoreScreen(store, cart);
    }

}
