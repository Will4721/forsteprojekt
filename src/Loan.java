public abstract class Loan {

    private String title;
    private int date;
//hi
    // Constructor
    public Loan(String title, int date) {

        this.title = title;
        this.date = date;
    }

    // Getter method (used to access private attribute)


    // Setter method (used to change name if needed)
    public void setDate(String title, int date) {

        this.title = title;
        this.date = date;
    }

    // toString method (called automatically when printing object)
    @Override
    public String toString() {
        return "Loan: " + title;
    }
}
