package beachJudge.views;

import org.springframework.security.access.annotation.Secured;
import org.vaadin.spring.sidebar.annotation.FontAwesomeIcon;
import org.vaadin.spring.sidebar.annotation.SideBarItem;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.SelectionMode;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

import beachJudge.Sections;
import beachJudge.backend.Backend;

@Secured("ROLE_ADMIN")
@SpringView(name = "user-management")
@SideBarItem(sectionId = Sections.VIEWS, caption = "User Management View", order = 0)
@FontAwesomeIcon(FontAwesome.USERS)
public class UserManagementView extends VerticalLayout implements View{

	final Backend mBackend;
	Grid userGrid;
	
	public UserManagementView(Backend backend){
		this.mBackend = backend;
		setSizeFull();
		setMargin(true);

		Label header = new Label("User Management");
		addComponent(header);
		
		userGrid = new Grid();
		userGrid.setCaption("User Information");
		userGrid.setSizeFull();
		userGrid.setEditorEnabled(true);
		userGrid.setSelectionMode(SelectionMode.NONE);
		
		userGrid.addColumn("Index", Integer.class);
		userGrid.addColumn("name", String.class);
		userGrid.addColumn("userID", String.class);
		
		/** Sample Data **/
		for(int i = 0; i < 10; i++){
			String[] name = {"firstName","lastName"};
			userGrid.addRow( i+1 ,name[0] + ' ' + name[1], "userID");
		}

		
		addComponent(userGrid);
		

//		Panel panel = createPanel();
//		addComponent(panel);
//		this.setExpandRatio(panel, 1.0f);
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
		// TODO Auto-generated method stub
		
	}

}
