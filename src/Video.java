public class Video extends Loan {
    private int duration;
    public Video(String title, int date, int duration) {
        super(title,date);
        this.duration=duration;
    }
//hi asjkdkadsj
    @Override
    public String toString() {
        return "Type: Video \nTitle: "+getTitle()+ "\nDuration: " + duration;
    }
}
