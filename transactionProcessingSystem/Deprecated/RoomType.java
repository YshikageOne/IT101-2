package transactionProcessingSystem.Deprecated;

public class RoomType {
	private String name;
    private double pricePerNight;

    public RoomType(String name, double pricePerNight) {
        this.name = name;
        this.pricePerNight = pricePerNight;
    }

    public String getName() {
        return name;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

}
