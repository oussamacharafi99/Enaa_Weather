
import java.util.Date;

public class CityHistory {
    private Integer historicalDataId;
    private Integer cityId;
    private Date date;
    private Integer temperature;
    private String cityName;
    public CityHistory(Integer id , Integer idc,Integer temperature , Date date,  String cityName){
        this.historicalDataId = id;
        this.cityId = idc;
        this.date = date;
        this.temperature = temperature;
        this.cityName = cityName;
    }
    public CityHistory(){
    }

    public CityHistory(Integer cityId, Integer currentTemperature, String cityName) {
        this.cityId = cityId;
        this.temperature = currentTemperature;
        this.cityName = cityName;
    }


    public Integer getHistoricalDataId() {
            return historicalDataId;
        }

        public Integer getTemperature() {
            return temperature;
        }

        public Integer getCityId() {
            return cityId;
        }


    public Date getDate() {
        return date;
    }

    public String getCityName() {
        return cityName;
    }

    }