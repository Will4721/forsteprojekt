public class Video extends Loan {
    private String duration;
    public Video(String title, int date, String duration) {
        super(title,date);
        this.duration=duration;
    }
//hi asjkdkadsj
    @Override
    public String toString() {
        return "Type: Video \nTitle: "+getTitle()+ "\nDuration: " + duration;
    }
}
