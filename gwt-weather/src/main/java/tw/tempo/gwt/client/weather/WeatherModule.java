package tw.tempo.gwt.client.weather;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class WeatherModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        bindPresenter(WeatherPresenter.class,
                WeatherPresenter.IView.class,
                WeatherView.class,
                WeatherPresenter.IProxy.class);
    }
}
