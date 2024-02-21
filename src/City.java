import java.util.Date;

public class City {


    private Integer cityId;
    private String cityName;
    private Integer currentTemperature;
    private Integer currentHumidity;
    private Integer currentWindSpeed;
    private Date dateCity;

    public City(Integer id , String name , Integer temperature , Integer humidity , Integer windSpeed, Date dateCity){

        this.cityId = id;
        this.cityName = name;
        this.currentTemperature = temperature;
        this.currentHumidity = humidity;
        this.currentWindSpeed = windSpeed;
        this.dateCity = dateCity;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Integer getCurrentTemperature() {
        return currentTemperature;
    }

    public void setCurrentTemperature(Integer currentTemperature) {
        this.currentTemperature = currentTemperature;
    }

    public Integer getCurrentHumidity() {
        return currentHumidity;
    }

    public void setCurrentHumidity(Integer currentHumidity) {
        this.currentHumidity = currentHumidity;
    }

    public Integer getCurrentWindSpeed() {
        return currentWindSpeed;
    }

    public void setCurrentWindSpeed(Integer currentWindSpeed) {
        this.currentWindSpeed = currentWindSpeed;
    }


    public String toString() {
        return "City{" +
                "id=" + cityId +
                ", name='" + cityName + '\'' +
                ", temperature='" + currentTemperature + '\'' +
                ", humidity='" + currentHumidity + '\'' +
                '}';
    }

    public java.sql.Date getDateCity() {
        return (java.sql.Date) dateCity;
    }

    public void setDateCity(Date dateCity) {
        this.dateCity = dateCity;
    }
}
