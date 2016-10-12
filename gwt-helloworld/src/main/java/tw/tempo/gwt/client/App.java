package tw.tempo.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App implements EntryPoint {
    private static final Logger log = LoggerFactory.getLogger(App.class);

    public void onModuleLoad() {
        log.info("onModuleLoad()");
        RootPanel.get().add(new Label("Hello World!"));
    }
}
