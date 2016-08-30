package ro.szzsa.livescore.api.device.protocol.notification;

import java.util.List;

import ro.szzsa.livescore.api.device.model.game.Game;

import static ro.szzsa.livescore.api.device.protocol.notification.NotificationType.GAME_UPDATE_NOTIFICATION;

public class GameUpdateNotification extends Notification {

    private List<Game> games;

    public GameUpdateNotification() {
        super(GAME_UPDATE_NOTIFICATION);
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }
}
