import java.util.Comparator;

public class Book { 
    
    private String title;
    private String author;
    private Genre genre;
    private int reads;
    private Dates start;
    private Dates finish;
    private String summary;
    private int rating;

    public Book(String title, String author, Genre genre, int reads, Dates start, Dates finish, String summary, int rating) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.reads = reads;
        this.start = start;
        this.finish = finish;
        this.summary = summary;
        this.rating = rating;
    }

    public static Comparator<Book> AUTHOR_COMP = new Comparator<Book>() {
        @Override
        public int compare(Book o1, Book o2) {
            return o1.author.compareToIgnoreCase(o2.author);
        }
    };

    public static Comparator<Book> GENRE_COMP = new Comparator<Book>() {
        @Override
        public int compare(Book o1, Book o2) {
            return o1.genre.compareTo(o2.genre);
        }
    };

    public static Comparator<Book> READS_COMP = new Comparator<Book>() {
        @Override
        public int compare(Book o1, Book o2) {
            return o1.reads == o2.reads ? 0 : o1.reads > o2.reads ? 1 : -1;
        }
    };

    public static Comparator<Book> DATE_COMP = new Comparator<Book>() {
        @Override
        public int compare(Book o1, Book o2) {
            return o1.finish.compareTo(o2.finish);
        }
    };

    public static Comparator<Book> RATINGS_COMP = new Comparator<Book>() {
        @Override
        public int compare(Book o1, Book o2) {
            return Integer.compare(o1.rating, o2.rating);
        }
    };

    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("Title: " + this.title + "\n");
        builder.append("Author: " + this.author + "\n");
        builder.append("Genre: " + this.genre + "\n");
        builder.append("Number of reads: " + this.reads + "\n");
        builder.append("Start Date: " + this.start + "\n");
        builder.append("Finish Date: " + this.finish + "\n");
        builder.append("Summary: " + this.summary + "\n");
        builder.append("Rating (1-10): " + this.rating + "\n");

        return builder.toString();
    }
}