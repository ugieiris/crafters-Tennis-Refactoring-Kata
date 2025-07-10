public enum SCORE {
    LOVE("Love"), FIFTEEN("Fifteen"), THIRTY("Thirty"), FORTY("Forty");
    private final String value;

    SCORE(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}