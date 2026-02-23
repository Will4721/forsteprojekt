public class RaspberryPi extends Electronics {
    private String model;
    public RaspberryPi(String title, int date, String model) {
        super(title,date);
        this.model=model;
    }

    @Override
    public String toString() {
        return "Type: Video \nTitle: "+getTitle()+ "\nModel: " + model;
    }

}
