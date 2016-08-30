package ro.szzsa.livescore.api.device.model.event;

import java.util.List;

import ro.szzsa.livescore.api.device.model.game.Game;
import ro.szzsa.livescore.api.device.model.team.Team;

public class Penalty {

    private List<PenaltyType> types;

    private Game game;

    private String player;

    private Team team;

    private String time;

    public List<PenaltyType> getTypes() {
        return types;
    }

    public void setTypes(List<PenaltyType> types) {
        this.types = types;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
