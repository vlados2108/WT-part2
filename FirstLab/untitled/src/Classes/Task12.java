package Classes;

public class Task12 {
    public static void main(String[] args) {
        Book book1;
        Book book2;


        System.out.print("Enter book edition: ");
        Book.setEdition(InputData.inputPositiveInt());

        try {

            System.out.println("Set information about first book");
            book1 = InputData.setInformationAboutBook();

            System.out.println("Set information about second book");
            book2 = InputData.setInformationAboutBook();

        } catch (IllegalArgumentException e) {

            System.out.println( e.getMessage());
            return;
        }


        System.out.println("Books hash codes:");
        System.out.println("Classes.Book 1 hashCode: " + book1.hashCode());
        System.out.println("Classes.Book 2 hashCode: " + book2.hashCode());

        System.out.println("Are books equal? " + book1.equals(book2));

        System.out.println("Compare books: " + book1.compareTo(book2));
    }
}

