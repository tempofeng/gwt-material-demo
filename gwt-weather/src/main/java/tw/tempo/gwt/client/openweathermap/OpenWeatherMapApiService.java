package tw.tempo.gwt.client.openweathermap;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.Options;
import org.fusesource.restygwt.client.RestService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import java.util.List;

@Options(serviceRootKey = "openweathermap")
public interface OpenWeatherMapApiService extends RestService {
    @GET
    @Path("weather")
    void weather(@QueryParam("APPID") String apiKey,
                 @QueryParam("q") String cityName,
                 MethodCallback<City> callback);

    @JsonIgnoreProperties(ignoreUnknown = true)
    class City {
        public List<Weather> weather;
        public Main main;
        public Wind wind;
        public String name;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    class Weather {
        public int id;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    class Main {
        public double temp;
        public double humidity;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    class Wind {
        public double speed;
    }
}
