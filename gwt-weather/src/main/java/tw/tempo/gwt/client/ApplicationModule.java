package tw.tempo.gwt.client;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import tw.tempo.gwt.client.weather.WeatherModule;

public class ApplicationModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        install(new WeatherModule());
        bindPresenter(ApplicationPresenter.class,
                ApplicationPresenter.ApplicationView.class,
                ApplicationView.class,
                ApplicationPresenter.ApplicationProxy.class);
    }
}