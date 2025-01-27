public class Book {



    private String title;
    private String author;
    private long ISBN;
    private double price;
    private static int bookCount = 0;

    public Book(String title, String author, long ISBN, double price) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.price = price;
        bookCount++;
    }

    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public long getISBN() {
        return ISBN;
    }
    public double getPrice() {
        return price;
    }


    public void setTitle(String title) {
        this.title = title;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setISBN(long ISBN) {
        this.ISBN = ISBN;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public int findNumberOfCreatedBooks() {
        return bookCount;
    }


    public boolean equals(Book otherBook) {
        return (this.ISBN == otherBook.ISBN &&
                this.price == otherBook.price);
    }

    @Override
    public String toString() {
        return "Book [title=" + title + ", author=" + author + ", ISBN=" + ISBN + ", price=" + price + "]";
    }



















































}
