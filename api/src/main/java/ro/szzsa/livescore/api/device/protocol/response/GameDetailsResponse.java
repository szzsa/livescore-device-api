package ro.szzsa.livescore.api.device.protocol.response;

import ro.szzsa.livescore.model.GameDetails;

public class GameDetailsResponse {

  private GameDetails gameDetails;

  public GameDetails getGameDetails() {
    return gameDetails;
  }

  public void setGameDetails(GameDetails gameDetails) {
    this.gameDetails = gameDetails;
  }
}
