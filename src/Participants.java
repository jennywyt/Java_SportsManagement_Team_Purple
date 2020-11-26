public enum Participants {
    oneOn1("1v1", 2),
    twoOn2("2v2", 4),
    threeOn3("3v3", 6),
    fourOn4("4v4", 8),
    fiveOn5("5v5", 10),
    ;

    private String asString;
    private int maxParticipants;

    Participants(String asString, int maxParticipants) {
        this.asString = asString;
        this.maxParticipants = maxParticipants;
    }

    public int getMaxParticipants() {
        return maxParticipants;
    }

    @Override
    public String toString() {
        return asString;
    }
}
