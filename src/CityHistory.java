
import java.util.Date;

public class CityHistory {
    City city1 = new City();
    private Integer historicalDataId;
    private Integer cityId;
    private Date date;
    private Integer temperature;
    public CityHistory(Integer id, Date date, Integer temperature){
        this.cityId = id;
        this.date = date;
        this.temperature = temperature;
    }
    public CityHistory(){
    }



    @Override
    public String toString() {
        String Date = null;
        return "CityHistory{" +
                "city1=" + city1 +
                ", historicalDataId=" + historicalDataId +
                ", cityId=" + cityId +
                ", Date=" + Date +
                ", temperature=" + temperature +
                '}';
    }






        public Integer getHistoricalDataId() {
            return historicalDataId;
        }

        public void setHistoricalDataId(Integer historicalDataId) {
            this.historicalDataId = historicalDataId;
        }

        public java.sql.Date getDate() {
            Object Date = null;
            return (java.sql.Date) Date;
        }

        public void setDate(Date date) {
            Date Date = date;
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
