package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class StudentController implements Initializable {
	@FXML
    private BorderPane bp;

    @FXML
    private Pane leftSideMenu;

    @FXML
    private Pane studentsMenuItem;

    @FXML
    private Pane menuItemIconStudents;

    @FXML
    private Label lblStudents;

    @FXML
    private Pane transactionsMenuItem;

    @FXML
    private Label lblTransactions;

    @FXML
    private Pane menuItemIconTransactions;

    @FXML
    private Pane donatorsMenuItem;

    @FXML
    private Label lblDonators;

    @FXML
    private Pane menuItemIconDonators;

    @FXML
    private Pane reportsMenuItem;

    @FXML
    private Label lblReports;

    @FXML
    private Pane menuItemIconReports;

    @FXML
    private Pane adminsMenuItem;

    @FXML
    private Label lblAdmins;

    @FXML
    private Pane menuItemIconAdmins;

    @FXML
    private AnchorPane ap;

    @FXML
    private BorderPane bpInside;
    
    @FXML
    private Pane btnCloseWindow;

    @FXML
    private Pane btnMinimizeWindow;

	private List<Pane> menuItems;
	private List<Label> menuLabels;
	private List<Pane> menuIcons;
	
	/* Close and Minimize Buttons */
    @FXML
    void processCloseWindow(MouseEvent event) {
    	Stage stage = (Stage) btnCloseWindow.getScene().getWindow();
        stage.close();
    }
    
    @FXML
    void processMinimizeWindow(MouseEvent event) {
    	Stage stage = (Stage) btnMinimizeWindow.getScene().getWindow(); 
    	stage.setIconified(true);
    }

    /* Left Side Bar Menu Buttons */
	@FXML
	void processStudentsMenuItem(MouseEvent event) {
		 bp.setCenter(ap);
		changeMenuItemsApperance(studentsMenuItem, lblStudents, menuItemIconStudents);
	}

	@FXML
	void processTransactionsMenuItem(MouseEvent event) {
		loadPage("Transactions", transactionsMenuItem, lblTransactions, menuItemIconTransactions);
	}

	@FXML
	void processDonatorsMenuItem(MouseEvent event) {
		loadPage("Donators", donatorsMenuItem, lblDonators, menuItemIconDonators);
	}

	@FXML
	void processReportsMenuItem(MouseEvent event) {
		loadPage("Reports", reportsMenuItem, lblReports, menuItemIconReports);
	}

	@FXML
	void processAdminsMenuItem(MouseEvent event) {
		loadPage("Admins", adminsMenuItem, lblAdmins, menuItemIconAdmins);
	}

	/* Dynamically load page based on left menu item on click */
	private void loadPage(String page, Pane menuItem, Label menuLabel, Pane menuIcon) {
		Parent root = null;

		try {
			root = FXMLLoader.load(getClass().getResource("/resources/pages/" + page + ".fxml"));
		} catch (IOException e) {
			Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, e);
		}

		changeMenuItemsApperance(menuItem, menuLabel, menuIcon);
		bp.setCenter(root);
	}

	/* Tweak left menu buttons active style */
	private void changeMenuItemsApperance(Pane menuItem, Label menuLabel, Pane menuIcon) {
		
		menuItems.forEach(item -> {
			if (item == menuItem) {
				item.setStyle("-fx-background-color: #fff");
			} else {
				item.setStyle("-fx-background-color: #1A97EB");
			}
		});
		
		menuLabels.forEach(item -> {
			if (item == menuLabel) {
				item.setStyle("-fx-text-fill: #1A97EB");
			}
			else {
				item.setStyle("-fx-text-fill: #fff");
			}
		});
		
		menuIcons.forEach(item -> {
			if (item == menuIcon) {
				item.setStyle("-fx-background-color: #1A97EB");
			}
			else {
				item.setStyle("-fx-background-color: #fff");
			}
		});
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	    List<Pane> sideMenuItems = Arrays.asList(studentsMenuItem, transactionsMenuItem, donatorsMenuItem, reportsMenuItem, adminsMenuItem);
	    menuItems = sideMenuItems;
	    
	    List<Label> sideMenuLabels = Arrays.asList(lblStudents, lblTransactions, lblDonators, lblReports, lblAdmins);
	    menuLabels = sideMenuLabels;
	    
	    List<Pane> sideMenuIcons = Arrays.asList(menuItemIconStudents, menuItemIconTransactions, menuItemIconDonators, menuItemIconReports, menuItemIconAdmins);
	    menuIcons = sideMenuIcons;
	    
	    /* Student Tab is firstly loaded */
	    changeMenuItemsApperance(studentsMenuItem, lblStudents, menuItemIconStudents);
	}

}
