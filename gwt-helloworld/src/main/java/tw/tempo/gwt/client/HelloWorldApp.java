package tw.tempo.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;

public class HelloWorldApp implements EntryPoint {
    public void onModuleLoad() {
        RootPanel.get().add(new Label("Hello World!"));
    }
}
