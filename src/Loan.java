public class Loan {

private String title;
    // Constructor
    public Loan(String title) {
        this.title = title;
    }

    // Getter method (used to access private attribute)


    // Setter method (used to change name if needed)
    public void setDate(String title) {
         this.title = title;
    }

    // toString method (called automatically when printing object)
    @Override
    public String toString() {
        return "Loan:"  + title;
    }
}
