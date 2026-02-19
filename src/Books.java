public class Books extends Loan {
    public Books(String title, int date) {
        super(title,date);
    }
    //hi ajfgasfjafjaklsf
    @Override
    public String toString() {
        return "Type: Books \nTitle: "+getTitle();
    }

}
