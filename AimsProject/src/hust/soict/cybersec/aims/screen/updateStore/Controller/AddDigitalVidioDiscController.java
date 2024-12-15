package screen.updateStore.Controller;

import cart.Cart;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import media.CompactDisc;
import media.DigitalVideoDisc;
import screen.StoreScreen;
import store.Store;

public class AddDigitalVidioDiscController {
    private Store store;
    private Cart cart;
    @FXML
    private TextField tfCategory;

    @FXML
    private TextField tfCost;

    @FXML
    private TextField tfDirector;

    @FXML
    private TextField tfID;

    @FXML
    private TextField tfLength;

    @FXML
    private TextField tfTitle;

    public AddDigitalVidioDiscController(Store store, Cart cart){
        super();
        this.store = store;
        this.cart = cart;
    }

    @FXML
    void addDVD(ActionEvent event) {
        store.addMedia(new DigitalVideoDisc(Integer.parseInt(tfID.getText()), tfTitle.getText(),
                tfCategory.getText(), Float.parseFloat(tfCost.getText()), 0, tfDirector.getText()));
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Add DVD");
        alert.setHeaderText("Add DVD Successfully!");
        alert.showAndWait();
    }

    @FXML
    void viewStore(ActionEvent event) {
        new StoreScreen(store, cart);
    }
}
