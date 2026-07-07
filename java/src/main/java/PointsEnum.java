public enum PointsEnum {
    LOVE("Love"),
    FIFTEEN("Fifteen"),
    THIRTY("Thirty");
    private final String value;

    PointsEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}