package tw.tempo.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;

public class HelloWorldApp implements EntryPoint {
    public void onModuleLoad() {
        VerticalPanel panel = new VerticalPanel();
        panel.add(new Label("一鄉二里共三夫子不識四書五經六藝竟敢教七八九子十分大膽"));

        TextBox textBox = new TextBox();
        textBox.setText("十室九貧湊得八兩七錢六分五毫四厘尚且三心二意一等下流");
        panel.add(textBox);

        Button button = new Button();
        button.setText("我對！");
        button.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                Window.alert("對得好！");
            }
        });
        panel.add(button);

        RootPanel.get().add(panel);
    }
}
