package tw.tempo.gwt.client;

import com.google.inject.Inject;
import com.gwtplatform.mvp.client.Bootstrapper;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import org.fusesource.restygwt.client.Defaults;
import org.fusesource.restygwt.client.ServiceRoots;

public class AppBootstrapper implements Bootstrapper {
    private final PlaceManager placeManager;

    @Inject
    public AppBootstrapper(PlaceManager placeManager) {
        this.placeManager = placeManager;
    }

    @Override
    public void onBootstrap() {
        ServiceRoots.add("openweathermap", "http://api.openweathermap.org/data/2.5/");
        Defaults.setAddXHttpMethodOverrideHeader(false);
        placeManager.revealCurrentPlace();
    }
}