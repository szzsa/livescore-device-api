package ro.szzsa.livescore.api.device.model.event;

public enum PenaltyType {

    MINOR(2),

    BENCH_MINOR(2),

    DOUBLE_MINOR(4),

    MAJOR(5),

    MISCONDUCT(10),

    GAME_MISCONDUCT(20),

    MATCH(25);

    private final int minutes;

    PenaltyType(int minutes) {
        this.minutes = minutes;
    }

    public int getMinutes() {
        return minutes;
    }
}
