public class Books extends Loan {
    private String author;

    public Books(String title, int date, String author) {
        super(title, date);
        this.author = author;
    }

    //hi ajfgasfjafjaklsf
    @Override
    public String toString() {
        return "Type: Books \nTitle: " + getTitle() + "\nAuthor: " + author;
    }

}
