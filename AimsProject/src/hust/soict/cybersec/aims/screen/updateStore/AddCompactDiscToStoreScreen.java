package screen.updateStore;

import cart.Cart;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import screen.updateStore.Controller.AddBookController;
import screen.updateStore.Controller.AddCompactDiscController;
import store.Store;


import javax.swing.*;
import java.io.IOException;

public class AddCompactDiscToStoreScreen extends JFrame {
    public AddCompactDiscToStoreScreen(Store store, Cart cart){
        super();

        this.setSize(1094, 768);

        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);

        this.setTitle("Add CD");
        this.setVisible(true);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass()
                            .getResource("/screen/updateStore/fxml/addCompactDisc.fxml"));
                    AddCompactDiscController controller =
                            new AddCompactDiscController(store,cart);

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


