package mainPackage;


public class CurrentBook{

    private static BookObject currentBook;


    public static void set(BookObject u) {
        currentBook = u;
    }

    public static BookObject get() {
        return currentBook;
    }

}