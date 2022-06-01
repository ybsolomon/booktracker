public class Dates implements Comparable<Dates> {
    int month;
    int day;
    int year;

    public Dates(String date) {
        this.month = Integer.parseInt(date.substring(0, 2));
        this.day = Integer.parseInt(date.substring(2, 4));
        this.year = Integer.parseInt(date.substring(4, 8));
    }

    public String toString() {
        return month + "/" + day + "/" + year;
    }

    @Override
    public int compareTo(Dates other) {
        int comp = Integer.compare(this.year, other.year);
        System.out.println(comp);

        if (comp == 0) {
            comp = Integer.compare(this.month, other.month);
            System.out.println(comp);

            if (comp == 0) {
                comp = Integer.compare(this.day, other.day);
                System.out.println(comp);
            }
        }

        return comp;
    }
}
