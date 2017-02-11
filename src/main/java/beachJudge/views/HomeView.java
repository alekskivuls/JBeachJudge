
package beachJudge.views;

import org.vaadin.spring.sidebar.annotation.FontAwesomeIcon;
import org.vaadin.spring.sidebar.annotation.SideBarItem;

import com.vaadin.annotations.Theme;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

import beachJudge.Sections;
import beachJudge.backend.Backend;

/**
 * When the user logs in and there is no view to navigate to, this view will be
 * shown.
 */
@Theme("HomeTheme")
@SpringView(name = "")
@SideBarItem(sectionId = Sections.VIEWS, caption = "Home", order = 0)
@FontAwesomeIcon(FontAwesome.HOME)
public class HomeView extends VerticalLayout implements View {
	final Backend mBackend;

	public HomeView(Backend backend) {
		this.mBackend = backend;
		setSizeFull();
		setMargin(true);

		Label header = new Label("Welcome to Beach Judge!");
		header.addStyleName(ValoTheme.LABEL_H1);
		addComponent(header);

		Panel panel = createPanel();
		addComponent(panel);
		this.setExpandRatio(panel, 1.0f);
	}

	Panel createPanel() {
		Panel panel = new Panel();
		CssLayout layout = new CssLayout();
		layout.setSizeFull();

		panel.setSizeFull();
		panel.setContent(layout);
		panel.getContent().setSizeUndefined();
		return panel;
	}

	@Override
	public void enter(ViewChangeEvent event) {
	}
}
