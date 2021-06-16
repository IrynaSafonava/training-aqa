package javatasks.javacollections.maintask;

public class Music extends Track {
    private String composer;

    public Music(String title, double duration, Genre genre, String composer, double size) {
        super(title, duration, size, genre);
        this.composer = composer;
    }

    public String getComposer() {
        return composer;
    }

    public void setComposer(String composer) {
        this.composer = composer;
    }

    @Override
    public String toString() {
        return "Music{" +
                "composer='" + composer + '\'' +
                '}';
    }


}
