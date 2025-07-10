public enum GamePointLitteral {
    LOVE("Love"),
    FIFTEEN("Fifteen"),
    THIRTY("Thirty"),
    FORTY("Forty");
    private final String value;

    GamePointLitteral(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}