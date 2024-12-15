package screen.updateStore.Controller;

import cart.Cart;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import media.CompactDisc;
import screen.StoreScreen;
import store.Store;


public class AddCompactDiscController {
    private Store store;
    private Cart cart;

    @FXML
    private TextField tfArtist;

    @FXML
    private TextField tfCategory;

    @FXML
    private TextField tfCost;

    @FXML
    private TextField tfDirector;

    @FXML
    private TextField tfID;

    @FXML
    private TextField tfTitle;

    public AddCompactDiscController(Store store, Cart cart){
        super();
        this.store = store;
        this.cart = cart;
    }


    @FXML
    void addCD(ActionEvent event) {
        store.addMedia(new CompactDisc(Integer.parseInt(tfID.getText()), tfTitle.getText(),
                tfCategory.getText(), Float.parseFloat(tfCost.getText()), 0, tfDirector.getText(),
                tfArtist.getText()));
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Add CD");
        alert.setHeaderText("Add CD Successfully!");
        alert.showAndWait();
    }

    @FXML
    void viewStore(ActionEvent event) {
        new StoreScreen(store, cart);
    }
}
