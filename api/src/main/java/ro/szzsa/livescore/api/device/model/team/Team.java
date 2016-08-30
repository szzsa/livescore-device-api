package ro.szzsa.livescore.api.device.model.team;

public class Team {

    private String code;

    private String name;

    private String city;

    private String country;

    private String timeZone;

    private IceRink iceRink;

    private String homeColor;

    private String awayColor;

    private int yearFounded;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public IceRink getIceRink() {
        return iceRink;
    }

    public void setIceRink(IceRink iceRink) {
        this.iceRink = iceRink;
    }

    public String getHomeColor() {
        return homeColor;
    }

    public void setHomeColor(String homeColor) {
        this.homeColor = homeColor;
    }

    public String getAwayColor() {
        return awayColor;
    }

    public void setAwayColor(String awayColor) {
        this.awayColor = awayColor;
    }

    public int getYearFounded() {
        return yearFounded;
    }

    public void setYearFounded(int yearFounded) {
        this.yearFounded = yearFounded;
    }
}
