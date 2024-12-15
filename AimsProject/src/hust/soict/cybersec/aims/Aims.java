import cart.*;
import exception.PlayerException;
import media.*;
import screen.StoreScreen;
import store.Store;

import javax.naming.LimitExceededException;


public class Aims {
    public static void main(String[] args) throws LimitExceededException, PlayerException {
        Store store = new Store();
        Cart cart = new Cart();

        DigitalVideoDisc a = new DigitalVideoDisc(1,"B","Cate1",12.2f,0,"D1");
        Book b = new Book(2,"D","Cate2",6.47f);
        Disc c = new Disc(3,"A","Cate3",9.24f,12,"D3");
        CompactDisc d = new CompactDisc(4,"E","Cate4",55.23f,321,"D4","abc");
        DigitalVideoDisc e = new DigitalVideoDisc(5,"F","Cate1",12.2f,12,"D1");
        Book f = new Book(6,"G","Cate2",6.47f);
        Disc g = new Disc(7,"H","Cate3",9.24f,12,"D3");
        CompactDisc h = new CompactDisc(8,"I","Cate4",55.23f,321,"D4","abc");
        DigitalVideoDisc i = new DigitalVideoDisc(9,"K","Cate1",12.2f,12,"D1");
        Book k = new Book(10,"L","Cate2",6.47f);
        Disc l = new Disc(11,"M","Cate3",9.24f,12,"D3");

        store.addMedia(a);
        store.addMedia(b);
        store.addMedia(c);
        store.addMedia(d);
        store.addMedia(e);
        store.addMedia(f);
        store.addMedia(g);
        store.addMedia(h);
        store.addMedia(i);
        store.addMedia(k);
        store.addMedia(l);

        new StoreScreen(store, cart);
    }
}
