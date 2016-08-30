package ro.szzsa.livescore.api.device.model.event;

import java.util.List;

import ro.szzsa.livescore.api.device.model.game.Game;

public class Goal {

    private Game game;

    private String team;

    private String author;

    private List<String> assists;

    private String time;

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<String> getAssists() {
        return assists;
    }

    public void setAssists(List<String> assists) {
        this.assists = assists;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
