public enum GamePoints {
    LOVE("Love"),
    FIFTEEN("Fifteen"),
    THIRTY("Thirty");
    private final String value;

    GamePoints(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}