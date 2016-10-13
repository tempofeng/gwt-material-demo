package tw.tempo.gwt.client;

import com.google.gwt.user.client.ui.SimplePanel;
import com.gwtplatform.mvp.client.ViewImpl;

public class ApplicationView extends ViewImpl implements ApplicationPresenter.ApplicationView {
    private final SimplePanel main = new SimplePanel();

    ApplicationView() {
        initWidget(main);
        bindSlot(ApplicationPresenter.SLOT_MAIN, main);
    }
}