package tw.tempo.gwt.client;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.gwtplatform.mvp.client.gin.DefaultModule;
import com.gwtplatform.mvp.shared.proxy.RouteTokenFormatter;

public class ClientModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        String nameToken = NameTokens.WEATHER;

        install(new DefaultModule.Builder()
                .tokenFormatter(RouteTokenFormatter.class)
                .defaultPlace(nameToken)
                .errorPlace(nameToken)
                .unauthorizedPlace(nameToken)
                .build());

        install(new ApplicationModule());
    }
}
