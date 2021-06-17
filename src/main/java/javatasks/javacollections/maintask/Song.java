package javatasks.javacollections.maintask;

public class Song extends Track{

    private String singer;

    public Song(){

    }

    public Song(String singer, String title, double duration, Genre genre) {
        super(title, duration, genre);
        this.singer = singer;
    }

    @Override
    public String toString() {
        return "Song{" +
                "singer='" + singer + '\'' +
                '}';
    }
}
