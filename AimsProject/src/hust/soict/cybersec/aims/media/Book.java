package media;

import java.util.ArrayList;

public class Book extends Media {
    private ArrayList<String> authors = new ArrayList<String>();

    public Book(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }

    public void addAuthor(String authorName){
        if(authors.contains(authorName)){
            System.out.println("This author has been added before!");
        }

        else {
            authors.add(authorName);
            System.out.println("This author has been added successful!");
        }
    }

    public void removeAuthor(String authorName){
        if(!authors.contains(authorName)){
            System.out.println("This author has not been added before!");
        }

        else {
            authors.add(authorName);
            System.out.println("This author has been removed successful!");
        }
    }

    @Override
    public String toString() {
        return this.getId() +". Book - "+ this.getTitle() + " - "
                + this.getCategory() + " - "
                + this.getCost()+"$";
    }
}
