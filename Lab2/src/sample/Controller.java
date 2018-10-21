package sample;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.scene.control.TextArea;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

public class Controller implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) { }

    @FXML
    private Label infoWindow;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField taskNumber;

    @FXML
    private Pane testPane;

    @FXML
    private ComboBox testLevel;

    @FXML
    private DatePicker testDate;

    @FXML
    private TextField testName;

    @FXML
    private TextArea textInfo;

    @FXML
    private Pane showTestPane;

    private ArrayList<Test> tests = new ArrayList<>();

    @FXML
    void openTest(ActionEvent event)
    {
        hidePanes(false, true);
        infoWindow.setText("Создание теста");
        testLevel.getItems().addAll("Низкий", "Средний", "Высокий");
    }

    @FXML
    void createTest(ActionEvent event)
    {
        boolean error = true;
        int taskNumberInt = 0;
        try
        {
            taskNumberInt = Integer.parseInt(taskNumber.getText());

        }
        catch (Exception e)
        {
            infoWindow.setText("Некорректные кол-во заданий!");
            error = false;
        }
        if (error)
        {
            if (testName.getText().equals(""))
            {
                infoWindow.setText("Некорректное имя теста!");
                error = false;
            }
        }
        if (error)
        {
            if (testDate.getValue() == null)
            {
                infoWindow.setText("Укажите дату теста!");
                error = false;
            }
        }
        if (error)
        {
            if (testLevel.getValue() == null)
            {
                infoWindow.setText("Укажите уровень сложности теста!");
            }
        }
        else
        {
            for (int i = 0; i < tests.size(); i++)
            {
                if (tests.get(i).getName().equals(testName.getText()))
                {
                    infoWindow.setText("Тест с таким именем уже существует!");
                    error = false;
                    break;
                }
            }
        }
        if (error)
        {
            tests.add(new Test(testDate.getValue(), testLevel.getValue().toString(), testName.getText(), taskNumberInt));
            infoWindow.setText("Тест успешно добавлен!");
            hidePanes(true, true);
            testName.clear();
            taskNumber.clear();
            testLevel.getItems().clear();
            testDate.setValue(null);
        }
    }

    @FXML
    void initialize()
    {
        assert testLevel != null : "fx:id=\"testLevel\" was not injected: check your FXML file 'sample.fxml'.";
        assert testDate != null : "fx:id=\"testDate\" was not injected: check your FXML file 'sample.fxml'.";
        assert testName != null : "fx:id=\"testName\" was not injected: check your FXML file 'sample.fxml'.";

    }

    //Функция открытия слоев
    public void hidePanes(boolean testPane, boolean showTestPane)
    {
        if (testPane)
            this.testPane.setVisible(false);
        else
            this.testPane.setVisible(true);
        if (showTestPane)
            this.showTestPane.setVisible(false);
        else
            this.showTestPane.setVisible(true);
    }

    @FXML
    void showTests(ActionEvent event)
    {
        hidePanes(true, false);
        textInfo.clear();
        for (int i = 0; i < tests.size(); i++)
        {
            textInfo.appendText("=========================================\n");
            textInfo.appendText("Название теста: " + tests.get(i).getName() + "\n");
            textInfo.appendText("Уровень сложности теста: " + tests.get(i).getLevel() + "\n");
            textInfo.appendText("Дата проведения теста: " + tests.get(i).getDate() + "\n");
            textInfo.appendText("Кол-во заданий в тесте: " + tests.get(i).getTaskNumber() + "\n");
            textInfo.appendText("=========================================\n" );
        }
    }


}
