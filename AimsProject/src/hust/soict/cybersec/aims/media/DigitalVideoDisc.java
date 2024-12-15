package media;

import exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable{
    public DigitalVideoDisc(int id, String title, String category, float cost, int length, String director) {
        super(id, title, category, cost, length, director);
    }

    @Override
    public String toString() {
        return this.getId() +". DVD - "+ this.getTitle() +" - "+ this.getCategory() +" - "
                + this.getDirector() +" - "+ this.getLength() +": "+ this.getCost() +"$";
    }

    public boolean isMatch(String title){
        return this.getTitle().contains(title);
    }

    @Override
    public void play() throws PlayerException{
        if (this.getLength() > 0) {
            System.out.println("Playing DVD: " + this.getTitle());
            System.out.println("DVD length: " + this.getLength());
        } else {
            throw new PlayerException("ERROR: DVD length is non-positive");
        }
    }
}
