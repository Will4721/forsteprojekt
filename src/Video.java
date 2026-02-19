public class Video extends Loan {
    public Video(String title, int date) {
        super(title,date);
    }
//hi asjkdkadsj
    @Override
    public String toString() {
        return "Video: "+getTitle();
    }

}
