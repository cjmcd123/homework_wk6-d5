public enum BedroomType{

    SINGLE("Single", 1),
    DOUBLE("Double", 2),
    LARGE("Lager", 4),
    SUITE("Suite", 6);

    private final String type;
    private final int capacity;

    BedroomType(String type, int capacity){
        this.type = type;
        this.capacity = capacity;
    }

    public String getType() {
        return type;
    }

    public int getCapacity() {
        return capacity;
    }
}
