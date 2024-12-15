package screen;

import cart.Cart;
import media.Media;
import media.Playable;

import javax.naming.LimitExceededException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MediaStore extends JPanel {
    private Media media;

    public MediaStore(Media media, Cart cart){
        this.media = media;
        System.out.println(media.toString());
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont((new Font(title.getFont().getName(),Font.PLAIN,20)));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel(""+media.getCost()+" $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton btnAddToCart = new JButton("Add to cart");
        btnAddToCart.addActionListener(e -> {
            System.out.println(media.toString());
            try {
                cart.addMedia(media);
            } catch (LimitExceededException ex) {
                throw new RuntimeException(ex);
            }
            JOptionPane.showMessageDialog(null,
                    media.getTitle() + " has been added to the cart!",
                    "Add to Cart",
                    JOptionPane.INFORMATION_MESSAGE);
        });

        container.add(btnAddToCart);


        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}
