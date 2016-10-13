package tw.tempo.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import org.fusesource.restygwt.client.Defaults;
import org.fusesource.restygwt.client.ServiceRoots;

public class RestyApp implements EntryPoint {
    @Override
    public void onModuleLoad() {
        ServiceRoots.add("github", "https://api.github.com/");
        Defaults.setAddXHttpMethodOverrideHeader(false);

        RootPanel.get().add(new GithubWidget());
    }
}
