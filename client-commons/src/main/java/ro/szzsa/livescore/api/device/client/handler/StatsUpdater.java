package ro.szzsa.livescore.api.device.client.handler;

import java.util.List;

import ro.szzsa.livescore.model.Game;
import ro.szzsa.livescore.model.LeaguePhase;
import ro.szzsa.livescore.model.Team;

/**
 * Handles the up to date game details just received from the server.
 */
public interface StatsUpdater {

  void updateTeams(List<Team> teams);

  void updateGames(List<Game> games);

  void updateLeaguePhases(List<LeaguePhase> standingsList);
}
