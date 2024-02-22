
import java.util.Date;

public class CityHistory {
    City city1 = new City();
    private Integer historicalDataId;
    private Integer cityId;
    private Date Date;
    private Integer temperature;
    public CityHistory(){
    }








        public Integer getHistoricalDataId() {
            return historicalDataId;
        }

        public void setHistoricalDataId(Integer historicalDataId) {
            this.historicalDataId = historicalDataId;
        }

        public java.sql.Date getDate() {
            return (java.sql.Date) Date;
        }

        public void setDate(Date date) {
            Date = date;
        }

        public Integer getTemperature() {
            return temperature;
        }

        public void setTemperature(Integer temperature) {
            this.temperature = temperature;
        }

        public Integer getCityId() {
            return cityId;
        }

        public void setCityId(Integer cityId) {
            this.cityId = cityId;
        }
    }
