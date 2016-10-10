package ro.szzsa.livescore.api.device.client;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.zip.GZIPInputStream;

import android.util.Base64;
import ro.szzsa.livescore.model.Game;
import ro.szzsa.livescore.model.Goal;
import ro.szzsa.livescore.model.Penalty;
import ro.szzsa.utils.converter.Converters;

/**
 *
 */
public abstract class NotificationReceiver {

  protected static final String MESSAGE_KEY = "message";

  protected abstract Game getOldGame(long gameId);

  protected abstract void saveNewGame(Game game);

  protected abstract void handleError(Exception e);

  protected abstract void onNewGoal(Game game, Goal goal);

  protected abstract void onNewPenalty(Game game, Penalty penalty);

  protected abstract void onTimeChange(Game game);

  protected abstract void onStatusChange(Game game);

  public void processNotification(String message) {
    try {
      Game game = Converters.createJsonConverter().fromString(decompress(message), Game.class);
      Game oldGame = getOldGame(game.getId());
      if (areGoalsChanged(oldGame, game)) {
        onNewGoal(game, getLatestGoal(game));
      }
      if (arePenaltiesChanged(oldGame, game)) {
        onNewPenalty(game, getLatestPenalty(game));
      }
      if (isTimeChanged(oldGame, game)) {
        onTimeChange(game);
      }
      if (isStatusChanged(oldGame, game)) {
        onStatusChange(game);
      }
      saveNewGame(game);
    } catch (Exception e) {
      handleError(e);
    }
  }

  private String decompress(String message) throws IOException {
    if (message == null || message.length() == 0) {
      return message;
    }
    byte[] bytes = Base64.decode(message, Base64.DEFAULT);
    GZIPInputStream gis = new GZIPInputStream(new ByteArrayInputStream(bytes));
    BufferedReader bf = new BufferedReader(new InputStreamReader(gis, "UTF-8"));
    String outStr = "";
    String line;
    while ((line = bf.readLine()) != null) {
      outStr += line;
    }
    return outStr;
  }

  private boolean areGoalsChanged(Game oldGame, Game game) {
    if (oldGame == null) {
      return game.getGoals() != null && game.getGoals().size() > 0;
    }
    if (oldGame.getGoals() == null) {
      return game.getGoals() != null && game.getGoals().size() > 0;
    }
    return game.getGoals().size() != oldGame.getGoals().size();
  }

  private boolean arePenaltiesChanged(Game oldGame, Game game) {
    if (oldGame == null) {
      return game.getPenalties() != null && game.getPenalties().size() > 0;
    }
    if (oldGame.getPenalties() == null) {
      return game.getPenalties() != null && game.getPenalties().size() > 0;
    }
    return game.getPenalties().size() != oldGame.getPenalties().size();
  }

  private boolean isTimeChanged(Game oldGame, Game game) {
    if (oldGame == null) {
      return game.getTime() != null && game.getTime().length() > 0;
    }
    if (oldGame.getTime() == null) {
      return game.getTime() != null && game.getTime().length() > 0;
    }
    return !game.getTime().equals(oldGame.getTime());
  }

  private boolean isStatusChanged(Game oldGame, Game game) {
    return oldGame == null || oldGame.getStatus() == null || !oldGame.getStatus().equals(game.getStatus());
  }

  private Goal getLatestGoal(Game game) {
    Collections.sort(game.getGoals(), new Comparator<Goal>() {
      @Override
      public int compare(Goal goal1, Goal goal2) {
        return goal2.getOrder() - goal1.getOrder();
      }
    });
    return game.getGoals().get(0);
  }

  private Penalty getLatestPenalty(Game game) {
    Collections.sort(game.getPenalties(), new Comparator<Penalty>() {
      @Override
      public int compare(Penalty penalty1, Penalty penalty2) {
        return penalty2.getOrder() - penalty1.getOrder();
      }
    });
    return game.getPenalties().get(0);
  }
}
