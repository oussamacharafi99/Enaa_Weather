import java.util.Date;

public class City {


    private Integer cityId;
    private String cityName;
    private Integer currentTemperature;
    private Integer currentHumidity;
    private Integer currentWindSpeed;
    private Date dateCity;




    public City() {
    }

    public City(Integer id, String name , Integer temperature , Integer humidity , Integer windSpeed){
        this.cityId = id;
        this.cityName = name;
        this.currentTemperature = temperature;
        this.currentHumidity = humidity;
        this.currentWindSpeed = windSpeed;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("╔═══════════════════ ════ ════ ═══════════════════════╗\n");
        sb.append("  ║                     City Weather                    ║\n");
        sb.append("  ╟───────────────────────────────────────────────────  ╢\n");
        sb.append(String.format("  ║ Id of City         : %-30s ║\n", cityId));
        sb.append(String.format("  ║ City Name          : %-30s ║\n", cityName));
        sb.append(String.format("  ║ Current Temperature: %-30s ║\n", currentTemperature));
        sb.append(String.format("  ║ Current Humidity   : %-30s ║\n", currentHumidity));
        sb.append(String.format("  ║ Current Wind Speed : %-30s ║\n", currentWindSpeed));
        sb.append("  ╚══════════════════ ═════════════ ════════════════════╝\n");
        return sb.toString();
    }



    public void setCurrentWindSpeed(Integer currentWindSpeed) {
        this.currentWindSpeed = currentWindSpeed;
    }




    public Date getDateCity() {
        return  dateCity;
    }

    public void setDateCity(Date dateCity) {
        this.dateCity = dateCity;
    }
}
