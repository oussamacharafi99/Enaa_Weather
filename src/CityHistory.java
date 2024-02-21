
import java.time.LocalDate;

    public class CityHistory {

    private Integer historicalDataId;
    private LocalDate Date;
    private Integer eventDate;
    private Integer temperature;

        public Integer getHistoricalDataId() {
            return historicalDataId;
        }

        public void setHistoricalDataId(Integer historicalDataId) {
            this.historicalDataId = historicalDataId;
        }

        public LocalDate getDate() {
            return Date;
        }

        public void setDate(LocalDate date) {
            Date = date;
        }

        public Integer getEventDate() {
            return eventDate;
        }

        public void setEventDate(Integer eventDate) {
            this.eventDate = eventDate;
        }

        public Integer getTemperature() {
            return temperature;
        }

        public void setTemperature(Integer temperature) {
            this.temperature = temperature;
        }
    }
