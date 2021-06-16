package javatasks.javacollections.maintask;

public class Track implements Comparable<Track>{

    private String title;
    private double duration;
    private double size;
    private Genre genre;

    public Track(String title, double duration, double size, Genre genre) {
        this.title = title;
        this.duration = duration;
        this.genre = genre;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Track{" +
                "title='" + title + '\'' +
                ", duration=" + duration +
                ", size=" + size +
                ", genre=" + genre +
                '}';
    }

    @Override
    public int compareTo(Track o) {
        int result = genre.compareTo(o.genre);
        if(result == 0){
            result = genre.compareTo(o.genre);
        }
        return result;
    }
}
