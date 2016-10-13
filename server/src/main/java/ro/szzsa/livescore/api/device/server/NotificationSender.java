package ro.szzsa.livescore.api.device.server;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.zip.GZIPOutputStream;

import ro.szzsa.livescore.api.device.protocol.notification.Data;
import ro.szzsa.livescore.api.device.protocol.notification.Notification;
import ro.szzsa.livescore.model.Game;
import ro.szzsa.utils.connector.HttpConnectorBuilder;
import ro.szzsa.utils.connector.Request;
import ro.szzsa.utils.converter.Converter;
import ro.szzsa.utils.converter.Converters;

/**
 *
 */
public class NotificationSender {

  private static final String FCM_SEND_URL = "https://fcm.googleapis.com/fcm/send";

  public void sendGameUpdate(String apiKey, Game game) throws NotificationException {
    try {
      Converter converter = Converters.createJsonConverter();
      Notification notification = new Notification();
      notification.setTo("/topics/" + Notification.STATS_TOPIC_NAME);
      notification.setData(new Data());
      notification.getData().setMessage(compress(converter.toString(game)));
      notification.setCollapse_key(String.valueOf(game.getId()));
      new HttpConnectorBuilder(apiKey).build().sendRequest(
        new Request(FCM_SEND_URL, converter.toString(notification)));
    } catch (Exception e) {
      throw new NotificationException(e);
    }
  }

  private String compress(String message) throws IOException {
    if (message == null || message.length() == 0) {
      return message;
    }
    ByteArrayOutputStream obj = new ByteArrayOutputStream();
    GZIPOutputStream gzip = new GZIPOutputStream(obj);
    gzip.write(message.getBytes("UTF-8"));
    gzip.close();
    return Base64.getEncoder().encodeToString(obj.toByteArray());
  }
}
