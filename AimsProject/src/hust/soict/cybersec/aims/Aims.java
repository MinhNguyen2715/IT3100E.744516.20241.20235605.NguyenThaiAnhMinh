import cart.*;
import media.*;
import store.Store;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Scanner;

public class Aims {
    public static void main(String[] args) {
        Store store = new Store();
        Cart cart = new Cart();


        DigitalVideoDisc a = new DigitalVideoDisc(1,"B","Cate1",12.2f,12,"D1");
        Book b = new Book(2,"D","Cate2",6.47f);
        Disc c = new Disc(3,"A","Cate3",9.24f,12,"D3");
        CompactDisc d = new CompactDisc(4,"C","Cate4",55.23f,321,"D4","abc");
        store.addMedia(a);
        store.addMedia(b);
        store.addMedia(c);
        store.addMedia(d);

        cart.addMedia(a);
        cart.addMedia(b);
        cart.addMedia(c);
        cart.addMedia(d);

        showMenu(store,cart);
    }
    public static void showMenu(Store store, Cart cart){
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");

        Scanner scanner = new Scanner(System.in);
        String respond = scanner.nextLine();
        switch (respond){
            case "1":
                store.print();
                storeMenu(store,cart);
                break;
            case "2":
                System.out.println("--------------------------------");
                System.out.println("1. Add a media");
                System.out.println("2. Remove a media");
                System.out.println("0. Exit");
                System.out.println("--------------------------------");
                System.out.println("Please choose a number: 0-1-2");
                respond = scanner.nextLine();
                if (Objects.equals(respond, "1")){
                    System.out.println("Enter the media's title: ");
                    respond = scanner.nextLine();
                    Media check = store.searchMedia(respond);
                    if (check != null) {
                        store.addMedia(check);
                    }
                    showMenu(store,cart);
                } else if (Objects.equals(respond, "2")) {
                    System.out.println("Enter the media's title: ");
                    respond = scanner.nextLine();
                    Media check = store.searchMedia(respond);
                    if (check != null) {
                        store.removeMedia(check);
                    }
                    showMenu(store,cart);
                } else {showMenu(store,cart);}

                break;
            case "3":
                cart.print();
                cartMenu(store,cart);
                break;
            case "0":
                System.out.println("Thanks for shopping!");
                break;
            default:
                System.out.println("Invalid choice, please try again.");
                showMenu(store, cart);
                break;
        }

    }

    public static void storeMenu(Store store, Cart cart){
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");

        Scanner scanner = new Scanner(System.in);
        String respond = scanner.nextLine();
        switch (respond){
            case "1":
                System.out.println("Enter the media's title: ");
                respond = scanner.nextLine();
                Media check = store.searchMedia(respond);
                if (check != null) {
                    mediaDetailsMenu(store, cart, check);
                }
                break;
            case "2":
                System.out.println("Enter the media's title: ");
                respond = scanner.nextLine();
                Media x = store.searchMedia(respond);
                if (x != null) {
                    cart.addMedia(x);
                }
                break;
            case "3":
                System.out.println("Enter the media's title: ");
                respond = scanner.nextLine();
                Media disc = store.searchMedia(respond);
                if (disc != null) {
                    System.out.println(disc.getClass());
                    if (disc instanceof Playable playableDisc) {
                        playableDisc.play();
                    }
                    else {
                        System.out.println("Cannot play this media!");
                    }
                }
                storeMenu(store,cart);
                break;
            case "4":
                cart.print();
                cartMenu(store,cart);
                break;
            case "0":
                showMenu(store,cart);
                break;
            default:
                System.out.println("Invalid choice, please try again.");
                showMenu(store, cart);
                break;
        }
    }

    public static void mediaDetailsMenu(Store store, Cart cart, Media title) {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");

        Scanner scanner = new Scanner(System.in);
        String respond = scanner.nextLine();
        switch (respond){
            case "1":
                cart.addMedia(title);
                break;
            case "2":
                if (title instanceof Playable playableDisc) {
                    playableDisc.play();
                }
                else {
                    System.out.println("Cannot play this media!");
                }
                storeMenu(store,cart);
                break;
            case "0":
                showMenu(store,cart);
                break;
            default:
                System.out.println("Invalid choice, please try again.");
                showMenu(store, cart);
                break;
        }
    }

    public static void cartMenu(Store store, Cart cart) {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");

        Scanner scanner = new Scanner(System.in);
        String respond = scanner.nextLine();

        switch (respond){
            case "1":
                System.out.println("1. Filtering by ID");
                System.out.println("2. Filtering by title");
                String option = scanner.nextLine();
                if(Objects.equals(option, "1")){
                    System.out.println("Enter ID:");
                    int id = scanner.nextInt();
                    Media check = cart.searchMedia(id);
                }

                else {
                    System.out.println("Enter title:");
                    String title = scanner.nextLine();
                    Media check = cart.searchMedia(title);
                }
                break;

            case "2":
                System.out.println("1. Sorting by title");
                System.out.println("2. Sorting by cost");
                String sort = scanner.nextLine();
                if(Objects.equals(sort, "1")) {
                    ArrayList<Media> list = cart.getItemsOrdered();
                    Collections.sort(list, Media.COMPARE_BY_TITLE_COST);
                    for (Media media : list) {
                        System.out.println(media.toString());
                    }
                    cartMenu(store,cart);
                }
                else if (Objects.equals(sort, "2")){
                    ArrayList<Media> list = cart.getItemsOrdered();
                    Collections.sort(list, Media.COMPARE_BY_COST_TITLE);
                    for (Media media : list) {
                        System.out.println(media.toString());;
                    }
                    cartMenu(store,cart);
                }
                break;

            case "3":
                System.out.println("Enter the media's title: ");
                respond = scanner.nextLine();
                Media tmp = store.searchMedia(respond);
                if (tmp != null) {
                    cart.removeMedia(tmp);
                }
                break;

            case "4":
                System.out.println("Enter the media's title: ");
                respond = scanner.nextLine();
                Media disc = store.searchMedia(respond);
                if (disc != null) {
                    if (disc instanceof Playable playableDisc) {
                        playableDisc.play();
                    }
                    else {
                        System.out.println("Cannot play this media!");
                    }
                }
                cartMenu(store,cart);
                break;

            case "5":
                System.out.println("Your order has been placed successfully!");
                cart.removeCart();
                showMenu(store,cart);
                break;

            case "0":
                showMenu(store,cart);
                break;

            default:
                System.out.println("Invalid choice, please try again.");
                showMenu(store, cart);
                break;
        }
    }
}
