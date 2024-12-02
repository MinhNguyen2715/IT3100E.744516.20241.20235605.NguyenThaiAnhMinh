package cart;

import media.Media;
import java.util.ArrayList;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

    public ArrayList<Media> getItemsOrdered() {
        return itemsOrdered;
    }

    public void addMedia(Media media){
        if(itemsOrdered.size() == 20){
            System.out.println("The cart is full!");
        }
        else {
            itemsOrdered.add(media);
            System.out.println("The item is added successfully!");
            if(itemsOrdered.size() == 20){
                System.out.println("The cart is full!");
            }
        }
    }

    public void removeMedia(Media media){
        if(!itemsOrdered.contains(media)){
            System.out.println("This item is not in the cart!");
        }
        else {
            itemsOrdered.remove(media);
            System.out.println("The item is removed successfully!");
        }
    }

    public void removeCart(){
        itemsOrdered.clear();
    }

    public float totalCost(){
        float cost = 0;
        for (Media x : itemsOrdered){
            cost += x.getCost();
        }
        return cost;
    }

    public void print(){
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (Media x : itemsOrdered){
            System.out.println(x.toString());
        }
        System.out.println("Total cost: "+this.totalCost());
        System.out.println("***************************************************");
    }

    public Media searchMedia(int id){
        if(id > itemsOrdered.size()){
            System.out.println("No match media is found!");
            return null;
        }
        else {
            System.out.println(itemsOrdered.get(id - 1).toString());
            return itemsOrdered.get(id-1);
        }
    }

    public Media searchMedia(String title){
        boolean check = false;
        for(Media x : itemsOrdered){
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
}

