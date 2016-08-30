package ro.szzsa.livescore.api.device.model.game;

/**
 * Statuses of a game.
 */
public enum GameStatus {

    /**
     * Represents a not started game.
     */
    SCHEDULED,

    /**
     * Represents a live (started but not ended) game.
     */
    LIVE,

    /**
     * Represents a game that ended after regulation time.
     */
    ENDED_AFTER_REGULATION,

    /**
     * Represents a game that ended after overtime.
     */
    ENDED_AFTER_OVERTIME,

    /**
     * Represents a game that ended after shootout.
     */
    ENDED_AFTER_SHOOTOUT
}
