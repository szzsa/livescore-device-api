package ro.szzsa.livescore.api.device.protocol.response;

import ro.szzsa.livescore.model.Game;

public class GameDetailsResponse {

  private Game game;

  public Game getGame() {
    return game;
  }

  public void setGame(Game game) {
    this.game = game;
  }
}
