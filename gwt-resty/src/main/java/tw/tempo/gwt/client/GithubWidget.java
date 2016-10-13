package tw.tempo.gwt.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.client.ui.*;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GithubWidget extends Composite {
    interface Binder extends UiBinder<Widget, GithubWidget> {
    }

    private static final Binder uiBinder = GWT.create(Binder.class);
    private static final Logger log = LoggerFactory.getLogger(GithubWidget.class);

    @UiField
    MaterialTextBox username;
    @UiField
    MaterialButton submit;
    @UiField
    MaterialCard profile;
    @UiField
    MaterialImage avatar;
    @UiField
    MaterialLabel name, location;
    @UiField
    MaterialLink blog, email;

    public GithubWidget() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    private static final GithubApiService githubApiService = GWT.create(GithubApiService.class);

    @UiHandler("submit")
    public void onSubmit(ClickEvent e) {
        githubApiService.user(username.getValue(),
                new MethodCallback<GithubApiService.User>() {
                    @Override
                    public void onFailure(Method method, Throwable exception) {
                        log.error(exception.getLocalizedMessage(), exception);
                        MaterialToast.fireToast("伺服器發生錯誤，無法連線 Github");
                    }

                    @Override
                    public void onSuccess(Method method, GithubApiService.User user) {
                        avatar.setUrl(user.avatarUrl);
                        name.setText(user.name);
                        location.setText(user.location);
                        blog.setHref("http://" + user.blog);
                        blog.setText(user.blog);
                        email.setHref("mailto:" + user.email);
                        email.setText(user.email);
                        profile.setVisible(true);
                    }
                });
    }
}
