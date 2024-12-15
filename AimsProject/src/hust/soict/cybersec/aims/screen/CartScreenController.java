package screen;

import cart.Cart;
import exception.PlayerException;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import media.*;

import javafx.event.ActionEvent;
import store.Store;

public class CartScreenController {
    private Cart cart;
    private Store store;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediacategory;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private TextField tfFilter;

    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;

    @FXML
    private Label totalCost;


    public CartScreenController(Store store, Cart cart){
        super();
        this.store = store;
        this.cart = cart;
    }

    @FXML
    private void initialize() {
        updateTotalCost();
        colMediaTitle.setCellValueFactory(
                new PropertyValueFactory<Media, String>("title"));
        colMediacategory.setCellValueFactory(
                new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(
                new PropertyValueFactory<Media, Float>("cost"));
        tblMedia.setItems(this.cart.getItemsOrdered());
//        FilteredList<Media> mediaFilteredList = new FilteredList<>(this.cart.getItemsOrdered(),b->true);


        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        tblMedia.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Media>() {
                    @Override
                    public void changed(ObservableValue<? extends Media> observable, Media oldValue,
                                        Media newValue) {
                        if (newValue != null){
                            updateButtonBar(newValue);
                        }

                    }
                }
        );

        updateTotalCost();

//        tfFilter.textProperty().addListener(new ChangeListener<String>() {
//            @Override
//            public void changed(ObservableValue<? extends String> observableValue, String oldValue,
//                                String newValue) {
//                showFilterMedia(newValue);
//            }
//        });

    }

    void updateButtonBar(Media media){
        btnRemove.setVisible(true);
        if (media instanceof Playable){
            btnPlay.setVisible(true);
        }
        else {
            btnPlay.setVisible(false);
        }
    }

    @FXML
    void removeMedia(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia(media);
        updateTotalCost();
    }

    @FXML
    void playMedia(ActionEvent event) throws PlayerException {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        try{
            if (media instanceof DigitalVideoDisc) {
                ((DigitalVideoDisc) media).play();
                ;
            } else if (media instanceof CompactDisc) {
                ((CompactDisc) media).play();
            }
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Play Media");
            alert.setHeaderText(media.toString());
            alert.showAndWait();

        } catch (PlayerException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Cannot play media!");
            alert.setHeaderText("ERROR: CD length is non-positive!");
            alert.showAndWait();
        }

    }

    @FXML
    void placeOrder(ActionEvent event){
        cart.removeCart();
        updateTotalCost();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Place Order");
        alert.setHeaderText("Your order has been placed!");
        alert.showAndWait();
    }

    void updateTotalCost(){
        String str = String.format("%.02f",cart.totalCost());
        if(str!=null && !str.isEmpty()) {
            totalCost.setText(str + " $");
        }
    }

    @FXML
    void viewStore(ActionEvent event) {
        new StoreScreen(store, cart);
    }

}
