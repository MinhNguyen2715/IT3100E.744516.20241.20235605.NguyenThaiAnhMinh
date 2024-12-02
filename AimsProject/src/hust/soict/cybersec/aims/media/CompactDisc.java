package media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable{
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<Track>();

    public String getArtist() {
        return artist;
    }

    public CompactDisc(int id, String title, String category, float cost, int length, String director, String artist) {
        super(id, title, category, cost, length, director);
        this.artist = artist;
    }

    public void addTrack(Track track){
        if(tracks.contains(track)){
            System.out.println("This track has been added before!");
        }

        else {
            tracks.add(track);
            System.out.println("This track has been added successful!");
        }
    }

    public void removeAuthor(Track track){
        if(!tracks.contains(track)){
            System.out.println("This track has not been added before!");
        }

        else {
            tracks.add(track);
            System.out.println("This track has been removed successful!");
        }
    }

    public int getLength(){
        int total = 0;
        for(Track x : tracks){
            total += x.getLength();
        }
        return total;
    }

    @Override
    public void play() {
        System.out.println("Artist: " + this.artist);
        int cnt = 1;
        for(Track x : tracks){
            System.out.println(cnt+".");
            System.out.println("Playing DVD: " + x.getTitle());
            System.out.println("DVD length: " + x.getLength());
            cnt++;
        }
    }
}
