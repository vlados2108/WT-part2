package Classes.Task14Classes;

import java.util.Comparator;
import Classes.Book;

public class SortByAuthorThenTitleThenPrice implements Comparator<Book> {

    private  Comparator<Book> comparator;

    public SortByAuthorThenTitleThenPrice(){

        comparator = new SortByAuthorThenTitle().thenComparing(new SortByPrice());

    }

    @Override
    public int compare(Book book1, Book book2) {
        if ((book1 == null) || (book2 == null)) {
            throw new IllegalArgumentException("Both books shouldn't be null");
        }

        return comparator.compare(book1, book2);
    }
}
