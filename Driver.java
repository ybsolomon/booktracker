import java.util.*;

public class Driver {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Book> books = new ArrayList<>();
        
        System.out.println( """
            Welcome to the Book Store!
            To add a book into storage please enter the following information fomatted as below:

            (title) (author) (genre) (number of times read) (start date MMDDYYYY like 05232022) 
            (finish date same format as start) (summary) (rating out of 10 with no decimals)

            Be sure to write all of this information on one line, pressing enter will submit the entry whether you want it to or not!
            Happy storing!

            P.S. You can type the word quit at any time to exit the Book Store.

            Please enter your first book:
            """);

        while (true) {
            String input = in.nextLine();
            if (input.equalsIgnoreCase("quit")) {
                break;
            }
            String[] info = input.split("(?is)(\\) \\()|\\)|\\("); 

            System.out.println(Arrays.toString(info));

            if (info.length != 9) {
                if (info.length == 1 && info[0] == "") {
                    continue;
                }
                System.out.println("Please re-enter the information (enclosed in parenthesis)\n");
                continue;
            } else {
                // public Book(String title, Genre genre, int reads, Dates start, Dates finish, String summary, int rating)
                
                Book book = new Book(info[1], info[2], new Genre(info[3]), Integer.parseInt(info[4]), new Dates(info[5]), new Dates(info[6]), info[7], Integer.parseInt(info[8]));
                books.add(book);

                System.out.print("\nWould you like to add another book? (y/n): ");
                if (in.nextLine().charAt(0) == 'n') {
                    break;
                }
                
                System.out.println("\nPlease enter your book information:");
            }
        }

        System.out.print("Would you like to sort your books? (y/n): ");

        if (in.next().charAt(0) == 'y') {
            System.out.print("Sort by GENRE (1), AUTHOR (2), FINISH DATE (3), TIMES READ (4), or RATING (5): ");
            char sort = in.next().charAt(0);
            
            switch (sort) {
                case '1': 
                    Collections.sort(books, Book.GENRE_COMP);
                    break;
                case '2': 
                    Collections.sort(books, Book.AUTHOR_COMP);
                    break;
                case '3':
                    Collections.sort(books, Book.DATE_COMP);
                    break;
                case '4':
                    Collections.sort(books, Book.READS_COMP);
                    break;
                case '5':
                    Collections.sort(books, Book.RATINGS_COMP);
                    break;
            }
        }

        in.close();

        System.out.println("You entered the following books:\n");
        books.stream().forEach(System.out::println);

        System.out.println("Thank you for using Book Store!");
    }
}