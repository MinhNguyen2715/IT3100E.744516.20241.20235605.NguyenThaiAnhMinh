public class Aims {
    public static void main(String[] args) {
        // Create a cart
        Cart anOrder = new Cart();

        // Create a disc and add to cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King","Animation",
                                                        "Roger Allers",87,19.95f);
        anOrder.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction",
                                                        "George Lucas",87,24.95f);
        anOrder.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Animation", "Aladin", 18.99f);
        anOrder.addDigitalVideoDisc(dvd3);

        // Print total cost of the items in the cart
        System.out.print("The total cost is: ");
        System.out.println(anOrder.totalCost());

        anOrder.removeDigitalVideoDisc(dvd2);

        System.out.println(anOrder.totalCost());

    }
}
