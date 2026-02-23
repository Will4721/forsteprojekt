public class Arduino extends Electronics {
    private String kitLevel;
    public Arduino(String title, int date, String kitLevel) {
        super(title,date);
        this.kitLevel=kitLevel;
    }

    @Override
    public String toString() {
        return "Type: Video \nTitle: "+getTitle()+ "\nKit Level: " + kitLevel;
    }

}
