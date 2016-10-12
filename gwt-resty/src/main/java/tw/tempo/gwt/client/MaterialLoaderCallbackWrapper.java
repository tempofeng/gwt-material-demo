package tw.tempo.gwt.client;

import gwt.material.design.client.ui.MaterialLoader;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

public class MaterialLoaderCallbackWrapper<T> implements MethodCallback<T> {
    private final MethodCallback<T> callback;

    public MaterialLoaderCallbackWrapper(MethodCallback<T> callback) {
        this.callback = callback;
        MaterialLoader.showLoading(true);
    }

    @Override
    public void onFailure(Method method, Throwable exception) {
        MaterialLoader.showLoading(false);
        callback.onFailure(method, exception);
    }

    @Override
    public void onSuccess(Method method, T response) {
        callback.onSuccess(method, response);
        MaterialLoader.showLoading(false);
    }
}
