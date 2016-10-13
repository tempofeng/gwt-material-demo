package tw.tempo.gwt.client.weather;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.client.ui.MaterialCard;
import gwt.material.design.client.ui.MaterialLabel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tw.tempo.gwt.client.openweathermap.OpenWeatherMapApiService;

public class WeatherView extends ViewImpl implements WeatherPresenter.IView {
    public interface Binder extends UiBinder<Widget, WeatherView> {
    }

    @UiField
    MaterialCard card;
    @UiField
    MaterialLabel city, weatherIcon, temp, humidity, wind;
    private String lastWeatherIconStyleName, lastCardStyleName;

    @Inject
    WeatherView(WeatherView.Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    public void onWeather(OpenWeatherMapApiService.City city) {
        if(lastWeatherIconStyleName != null) {
            weatherIcon.removeStyleName(lastWeatherIconStyleName);
        }
        lastWeatherIconStyleName = "wi-owm-" + city.weather.get(0).id;
        weatherIcon.addStyleName(lastWeatherIconStyleName);

        this.city.setText(city.name.toUpperCase());
        long temperature = Math.round(city.main.temp - 273.15);
        temp.setText(Long.toString(temperature));
        humidity.setText(Long.toString(Math.round(city.main.humidity)));
        wind.setText(Long.toString(Math.round(city.wind.speed)));

        if(lastCardStyleName != null) {
            card.removeStyleName(lastCardStyleName);
        }

        if (temperature >= 30) {
            lastCardStyleName = Color.VERY_WARM.style;
            card.addStyleName(lastCardStyleName);
        } else if (temperature > 20 && temperature < 30) {
            lastCardStyleName = Color.WARM.style;
            card.addStyleName(lastCardStyleName);
        } else if (temperature > 10 && temperature < 20) {
            lastCardStyleName = Color.NORMAL.style;
            card.addStyleName(lastCardStyleName);
        } else if (temperature > 0 && temperature < 10) {
            lastCardStyleName = Color.COLD.style;
            card.addStyleName(lastCardStyleName);
        } else if (temperature <= 0) {
            lastCardStyleName = Color.VERY_COLD.style;
            card.addStyleName(lastCardStyleName);
        }
    }

    private enum Color {
        VERY_WARM("orange darken-1"),
        WARM("amber lighten-1"),
        NORMAL("light-green"),
        COLD("light-blue darken-3"),
        VERY_COLD("indigo darken-3");

        public final String style;

        Color(String style) {
            this.style = style;
        }
    }
}
