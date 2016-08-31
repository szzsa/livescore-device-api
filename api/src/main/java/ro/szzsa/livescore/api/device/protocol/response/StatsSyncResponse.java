package ro.szzsa.livescore.api.device.protocol.response;

import java.util.List;

import ro.szzsa.livescore.model.Game;
import ro.szzsa.livescore.model.Standings;
import ro.szzsa.livescore.model.Team;

public class StatsSyncResponse {

  private List<Team> teams;

  private List<Game> games;

  private List<Standings> standings;

  public List<Team> getTeams() {
    return teams;
  }

  public void setTeams(List<Team> teams) {
    this.teams = teams;
  }

  public List<Game> getGames() {
    return games;
  }

  public void setGames(List<Game> games) {
    this.games = games;
  }

  public List<Standings> getStandings() {
    return standings;
  }

  public void setStandings(List<Standings> standings) {
    this.standings = standings;
  }
}
