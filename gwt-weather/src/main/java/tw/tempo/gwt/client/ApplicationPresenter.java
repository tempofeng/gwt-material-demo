package tw.tempo.gwt.client;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.presenter.slots.NestedSlot;
import com.gwtplatform.mvp.client.proxy.Proxy;

public class ApplicationPresenter extends Presenter<ApplicationPresenter.ApplicationView, ApplicationPresenter.ApplicationProxy> {
    interface ApplicationView extends View {
    }

    @ProxyStandard
    interface ApplicationProxy extends Proxy<ApplicationPresenter> {
    }

    public static final NestedSlot SLOT_MAIN = new NestedSlot();

    @Inject
    ApplicationPresenter(EventBus eventBus,
                         ApplicationView view,
                         ApplicationProxy proxy) {
        super(eventBus, view, proxy, RevealType.Root);
    }
}
