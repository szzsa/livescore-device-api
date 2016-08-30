package ro.szzsa.livescore.api.device.client.handler;

import java.util.List;

import ro.szzsa.livescore.api.device.model.team.Team;

/**
 * Handles the up to date teams just received from the server.
 */
public interface TeamsUpdateHandler {

    void handleTeamsUpdate(List<Team> teams);
}
