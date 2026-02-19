public abstract class Loan {
    private int date;

    // Constructor
    public Loan(int date) {
        this.date = date;
    }

    // Getter method (used to access private attribute)
    public int getDate(){
        return date;
    }

    // Setter method (used to change name if needed)
    public void setDate(int date) {
        this.date = date;
    }

    // toString method (called automatically when printing object)
    @Override
    public String toString() {
        return "Loan: " + date;
    }
}
