public class VREquipment extends Electronics {
    private String model;
    public VREquipment(String title, int date, String model) {
        super(title,date);
        this.model=model;
    }

    @Override
    public String toString() {
        return "Type: Video \nTitle: "+getTitle()+ "\nKit Level: " + model;
    }

}
