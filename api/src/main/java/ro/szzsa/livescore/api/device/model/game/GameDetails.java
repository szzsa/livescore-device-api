package ro.szzsa.livescore.api.device.model.game;

import java.util.List;

import ro.szzsa.livescore.api.device.model.event.Goal;
import ro.szzsa.livescore.api.device.model.event.Penalty;

public class GameDetails {

    private Game game;

    private List<Goal> goals;

    private List<Penalty> penalties;

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public List<Goal> getGoals() {
        return goals;
    }

    public void setGoals(List<Goal> goals) {
        this.goals = goals;
    }

    public List<Penalty> getPenalties() {
        return penalties;
    }

    public void setPenalties(List<Penalty> penalties) {
        this.penalties = penalties;
    }
}
