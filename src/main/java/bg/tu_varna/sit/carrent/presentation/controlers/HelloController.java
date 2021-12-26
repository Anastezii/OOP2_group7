package bg.tu_varna.sit.carrent.presentation.controlers;


import bg.tu_varna.sit.carrent.business.services.OperatorService;
import bg.tu_varna.sit.carrent.presentation.models.HelloModel;
import bg.tu_varna.sit.carrent.presentation.models.OperatorListViewModel;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class HelloController implements EventHandler<MouseEvent> {


    private final OperatorService service1 = OperatorService.getInstance();

    @FXML
    private Label welcomeText;


    @FXML
    private Button OperatorButton;

    @FXML
    private Button AdminButton;

    @FXML
    private Button ClientButton;


    @FXML
    private ListView<OperatorListViewModel>  listView1;

    private final HelloModel model;


    public HelloController() {

        this.model = new HelloModel();
    }


    @FXML
    public void initialize(){

        OperatorButton.setOnMouseClicked(this::handle);
        AdminButton.setOnMouseClicked(this::handle);
        ClientButton.setOnMouseClicked(this::handle);

    }
  //  @FXML private Text actiontarget;


    @Override
    public void handle(MouseEvent mouseEvent) {

        //actiontarget.setText("Sign in button pressed");

        ObservableList<OperatorListViewModel> operatorListViewModels = service1.getAllTask();
        listView1.setItems(operatorListViewModels);

    }
}