package store;

import media.Media;
import java.util.ArrayList;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();

    public void addMedia(Media media){
        if(itemsInStore.contains(media)){
            System.out.println("The item has been added to the store before!");
        }
        else {
            itemsInStore.add(media);
            System.out.println("The item is added successfully!");
        }
    }

    public void removeMedia(Media media){
        if(!itemsInStore.contains(media)){
            System.out.println("This item is not in the store!");
        }
        else {
            itemsInStore.remove(media);
            System.out.println("The item is removed successfully!");
        }
    }

    public Media searchMedia(int id){
        if(id > itemsInStore.size()){
            System.out.println("No match media is found!");
            return null;
        }
        else {
            System.out.println(itemsInStore.get(id - 1).toString());
            return itemsInStore.get(id-1);
        }
    }

    public Media searchMedia(String title){
        boolean check = false;
        for(Media x : itemsInStore){
            if (x.getTitle().equals(title)){
                check = true;
                System.out.println(x.toString());
                return x;
            }
        }
        if(!check){
            System.out.println("No match media is found!");
        }
        return null;
    }

    public void print(){
        System.out.println("***********************STORE***********************");
        System.out.println("Items in store:");
        for (Media x : itemsInStore){
            System.out.println(x.toString());
        }
        System.out.println("***************************************************");
    }
}
