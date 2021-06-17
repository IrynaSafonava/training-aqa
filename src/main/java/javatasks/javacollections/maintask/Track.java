package javatasks.javacollections.maintask;

public class Track implements Comparable<Track>{

    private String title;
    private double duration;
    private Genre genre;

    public Track(){
    }

    public Track(String title, double duration, Genre genre) {
        this.title = title;
        this.duration = duration;
        this.genre = genre;
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
