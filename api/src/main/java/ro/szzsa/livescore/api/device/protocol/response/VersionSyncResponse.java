package ro.szzsa.livescore.api.device.protocol.response;

public class VersionSyncResponse {

  private boolean updateApp;

  public boolean isUpdateApp() {
    return updateApp;
  }

  public void setUpdateApp(boolean updateApp) {
    this.updateApp = updateApp;
  }
}
