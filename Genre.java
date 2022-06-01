public class Genre implements Comparable<Genre> {
    public enum GENRE_ENUM {
        HORROR, ROMANCE, ADVENTURE, HIST_FICT, NONFICTION, FANTASY, OTHER;
    };

    private GENRE_ENUM genre;

    public Genre(String genre) {
        String lower = genre.toLowerCase();
        if (lower.equalsIgnoreCase("horror")) {
            this.genre = GENRE_ENUM.HORROR;
        } else if (lower.equalsIgnoreCase("romance")) {
            this.genre = GENRE_ENUM.ROMANCE;
        } else if (lower.equalsIgnoreCase("adventure")) {
            this.genre = GENRE_ENUM.ADVENTURE;
        } else if (lower.equalsIgnoreCase("historical fiction")) {
            this.genre = GENRE_ENUM.HIST_FICT;
        } else if (lower.equalsIgnoreCase("nonfiction")) {
            this.genre = GENRE_ENUM.NONFICTION;
        } else if (lower.equalsIgnoreCase("fantasy")) {
            this.genre = GENRE_ENUM.FANTASY;
        } else {
            this.genre = GENRE_ENUM.OTHER;
        }
    }

    public String toString() {
        return genre.name();
    }

    @Override
    public int compareTo(Genre other) {
        
        return this.genre.name().compareTo(other.genre.name());
    }
}
