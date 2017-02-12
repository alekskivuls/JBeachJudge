
package beachJudge.views;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;

import org.vaadin.spring.sidebar.annotation.FontAwesomeIcon;
import org.vaadin.spring.sidebar.annotation.SideBarItem;

import com.vaadin.event.MouseEvents.ClickEvent;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.FileDownloader;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Sizeable;
import com.vaadin.server.StreamResource;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.Link;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Upload;
import com.vaadin.ui.Upload.Receiver;
import com.vaadin.ui.VerticalLayout;

import beachJudge.Sections;
import beachJudge.backend.Backend;

/**
 * When the user logs in and there is no view to navigate to, this view will be
 * shown.
 */
@SpringView(name = "Problem")
@SideBarItem(sectionId = Sections.VIEWS, caption = "Problem")
@FontAwesomeIcon(FontAwesome.BEER)
public class ProblemView extends VerticalLayout implements View {
	final Backend mBackend;
	Table table;
	ArrayList<String> listOfProblems;
	public ProblemView(Backend backend) {
		this.mBackend = backend;
		setSizeFull();
		setMargin(true);


		Panel problemTitlePanel = createProblemTitlePanel();
		Panel submissionPanel = createSubmissionPanel();
		addComponent(problemTitlePanel);
		addComponent(submissionPanel);
		this.setExpandRatio(problemTitlePanel, 1.0f);
		this.setExpandRatio(submissionPanel, 1.0f);
	}

	Panel createProblemTitlePanel() {
		Panel panel = new Panel("Problems");
		listOfProblems = new ArrayList<String>();
		listOfProblems.add("Problem #1");
		listOfProblems.add("Problem #2");
		listOfProblems.add("Problem #3");
		
		table = new Table("List of Available Problems: ");
		table.addContainerProperty("Problem Title", String.class, null);
		table.addContainerProperty("View",Button.class, null);
		table.addContainerProperty("Download", Button.class, null);
		
	
		
		table.addItem(new Object[]{listOfProblems.get(0), this.createViewButton(), this.createDownloadButton()}, 2);
		table.addItem(new Object[]{listOfProblems.get(1), this.createViewButton(), this.createDownloadButton()}, 3);
		table.addItem(new Object[]{listOfProblems.get(2), this.createViewButton(), this.createDownloadButton()}, 4);

		panel.setSizeFull();
		panel.setContent(table);
		panel.getContent().setSizeUndefined();
		return panel;
	}
	
	
	
	Panel createSubmissionPanel() {
		HorizontalLayout horizontal = new HorizontalLayout();
	
		Panel panel = new Panel("Submissions");
		ComboBox submissionTitle = new ComboBox("Submissions");
		submissionTitle.addItems(listOfProblems.get(0), listOfProblems.get(1), listOfProblems.get(2));
		
		ComboBox language = new ComboBox("Language");
		language.addItems("Java", "C++", "Python");
		
		
		horizontal.addComponent(submissionTitle); 
		horizontal.addComponent(language);
		addComponent(horizontal);
		panel.setContent(horizontal);
		panel.getContent().setSizeUndefined();
		
		return panel;
	}
	
	public Button createViewButton() {
		Button button = new Button();
		button.setCaption("View PDF");
		button.setEnabled(true);
		button.setVisible(true);
		button.setIcon(FontAwesome.ARROW_RIGHT);
		
		button.addClickListener(new Button.ClickListener() {
		    public void buttonClick(ClickEvent event) {
		    	
		    }
			@Override
			public void buttonClick(com.vaadin.ui.Button.ClickEvent event) {
				// TODO Auto-generated method stub
				
				// change this to open pdf instead of google. lol
				getUI().getPage().open("http://www.google.com", "_blank");
			}

	
			


		});
		
	
		
		return button;
	}
	
	public Button createDownloadButton() {
		Button pdfDownload = new Button("Download PDF");
		pdfDownload.setIcon(FontAwesome.ARROW_DOWN);
//		StreamResource sr = getPDFStream();
//		FileDownloader fileDownloader = new FileDownloader(sr);
//		fileDownloader.extend(pdfDownload);


		
		
		return pdfDownload;
	}
	
	/*private StreamResource getPDFStream() {
        StreamResource.StreamSource source = new StreamResource.StreamSource() {

            public InputStream getStream() {
                ByteArrayOutputStream stream = getPFD();
                InputStream input = new ByteArrayInputStream(stream.toByteArray());
                  return input;

            }
        };
      StreamResource resource = new StreamResource ( source, getFileName());
        return resource;
}*/

	public String getFileName() {
		String fileName = null;
		
		// get the file name somehow lol
		
		return fileName;
	}
	
	
	@Override
	public void enter(ViewChangeEvent event) {
	}
}
