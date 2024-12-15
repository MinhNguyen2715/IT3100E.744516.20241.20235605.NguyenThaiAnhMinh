package screen.updateStore;

import cart.Cart;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import screen.updateStore.Controller.AddBookController;
import store.Store;

import javax.swing.*;
import java.io.IOException;

public class AddBookToStoreScreen extends JFrame {
    public AddBookToStoreScreen(Store store, Cart cart){
        super();

        this.setSize(1094, 768);

        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);

        this.setTitle("Add Book");
        this.setVisible(true);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass()
                            .getResource("/screen/updateStore/fxml/addBook.fxml"));
                    AddBookController controller =
                            new AddBookController(store,cart);
                    loader.setController(controller);
                    Parent root = loader.load();
                    fxPanel.setScene(new Scene(root));
                    ;

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}


