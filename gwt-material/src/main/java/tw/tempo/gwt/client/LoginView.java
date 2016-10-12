package tw.tempo.gwt.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialTextBox;

public class LoginView extends Composite {
    interface Binder extends UiBinder<Widget, LoginView> {
    }
    private static final Binder uiBinder = GWT.create(Binder.class);

    @UiField
    MaterialButton login;
    @UiField
    MaterialTextBox email, orderNo;

    public LoginView() {
        initWidget(uiBinder.createAndBindUi(this));
    }
}
