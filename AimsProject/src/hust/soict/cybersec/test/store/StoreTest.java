public class StoreTest {
    public static void main(String[] args) {
        Store s = new Store();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King","Animation",
                "Roger Allers",87,19.95f);

        s.addDVD(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction",
                "George Lucas",87,24.95f);
        s.addDVD(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Animation", "Aladin", 18.99f);
        s.addDVD(dvd3);

        s.removeDVD(dvd1);
        s.removeDVD(dvd3);
    }
}
