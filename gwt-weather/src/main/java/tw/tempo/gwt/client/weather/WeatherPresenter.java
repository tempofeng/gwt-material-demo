package tw.tempo.gwt.client.weather;

import com.google.gwt.user.client.Timer;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;
import gwt.material.design.client.ui.MaterialToast;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tw.tempo.gwt.client.ApplicationPresenter;
import tw.tempo.gwt.client.NameTokens;
import tw.tempo.gwt.client.openweathermap.OpenWeatherMapApiService;
import tw.tempo.gwt.client.restygwt.MaterialLoaderCallbackWrapper;

public class WeatherPresenter extends Presenter<WeatherPresenter.IView, WeatherPresenter.IProxy> {
    private static final Logger log = LoggerFactory.getLogger(WeatherPresenter.class);
    private final OpenWeatherMapApiService openWeatherMapApiService;
    private String[] cities;
    private int cityIndex;

    interface IView extends View {
        void onWeather(OpenWeatherMapApiService.City city);
    }

    @ProxyStandard
    @NameToken(NameTokens.WEATHER)
    interface IProxy extends ProxyPlace<WeatherPresenter> {
    }

    @Inject
    public WeatherPresenter(EventBus eventBus, IView view, IProxy proxy, OpenWeatherMapApiService openWeatherMapApiService) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_MAIN);
        this.openWeatherMapApiService = openWeatherMapApiService;
    }

    @Override
    public void prepareFromRequest(PlaceRequest request) {
        super.prepareFromRequest(request);

        cities = request.getParameter("cities", "London,Paris,Berlin,Madrid,Rome").split(",");

        fetchWeather();
        new Timer() {
            @Override
            public void run() {
                fetchWeather();
            }
        }.scheduleRepeating(5000);
    }

    private void fetchWeather() {
        String city = cities[cityIndex++];
        cityIndex = cityIndex >= cities.length ? 0 : cityIndex;

        openWeatherMapApiService.weather("OPEN_WEATHER_MAP_API_KEY",
                city,
                new MaterialLoaderCallbackWrapper<>(new MethodCallback<OpenWeatherMapApiService.City>() {
                    @Override
                    public void onFailure(Method method, Throwable exception) {
                        log.error(exception.getLocalizedMessage(), exception);
                        MaterialToast.fireToast("伺服器發生錯誤，無法連線 OpenWeatherMap");
                    }

                    @Override
                    public void onSuccess(Method method, OpenWeatherMapApiService.City city) {
                        getView().onWeather(city);
                    }
                }));
    }
}
