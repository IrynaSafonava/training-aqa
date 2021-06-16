package javatasks.javacollections.maintask;

public enum Genre {
    CLASSIC_MUSIC ("Classic music"),
    ROCK ("Rock"),
    METAL ("Metal"),
    JAZZ ("Jazz"),
    POP ("Pop"),
    RAP ("Rap/Hip-Hop"),
    ELECTRONIC("Electronic dance music");

    private String name;

    Genre(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
