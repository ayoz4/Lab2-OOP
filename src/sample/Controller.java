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
    private ComboBox testLevel, examLevel;

    @FXML
    private DatePicker testDate;

    @FXML
    private TextField testName;

    @FXML
    private TextArea textInfo;

    @FXML
    private Pane showUno;

    @FXML
    private TextField examTickets;

    @FXML
    private TextField examAuditory;

    @FXML
    private Pane examPane;

    @FXML
    private DatePicker examDate;

    @FXML
    private TextField examName;

    @FXML
    private TextField examTeacher;





                                                ////////////////////////////////
                                                ////////Создание теста//////////
                                                ////////////////////////////////

    private ArrayList<Test> tests = new ArrayList<>();

    @FXML
    void openTest(ActionEvent event)
    {
        hidePanes(false, true, true);
        infoWindow.setText("Создание теста");
        testLevel.getItems().clear();
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
            hidePanes(true, true, true);
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
    public void hidePanes(boolean testPane, boolean showUno, boolean examPane)
    {
        if (testPane)
            this.testPane.setVisible(false);
        else
            this.testPane.setVisible(true);
        if (showUno)
            this.showUno.setVisible(false);
        else
            this.showUno.setVisible(true);
        if (examPane)
            this.examPane.setVisible(false);
        else
            this.examPane.setVisible(true);
    }


    ///Показывает все тесты///
    @FXML
    void showTests(ActionEvent event)
    {
        hidePanes(true, false, true);
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



                                                ////////////////////////////////
                                                ////////Создание экзамена///////
                                                ////////////////////////////////

    ArrayList<Exam> exams = new ArrayList<>();

    @FXML
    void openExam(ActionEvent event)
    {
        hidePanes(true, true, false);
        infoWindow.setText("Создание экзамена");
        examLevel.getItems().clear();
        examLevel.getItems().addAll("Низкий", "Средний", "Высокий");
    }

    @FXML
    void createExam(ActionEvent event)
    {
        boolean error = true;
        int examTickets1 = 0;
        int examAuditory1 = 0;
        try
        {
            examTickets1 = Integer.parseInt(examTickets.getText());
            examAuditory1 = Integer.parseInt(examAuditory.getText());
        }
        catch (Exception e)
        {
            infoWindow.setText("Некорректные данные!");
            error = false;
        }
        if (error)
        {
            if (examTeacher.getText().equals(""))
            {
                infoWindow.setText("Укажите имя преподавателя, который принимает экзамен!");
                error = false;
            }

        }
        if (error)
        {
            if (examName.getText().equals(""))
            {
                infoWindow.setText("Укажите название экзамена!");
                error = false;
            }
        }
        if (error)
        {
            if (examDate.getValue() == null)
            {
                infoWindow.setText("Выберите дату проведения экзамена!");
                error = false;
            }
        }
        if (error)
        {
            if (examLevel.getValue() == null)
            {
                infoWindow.setText("Укажите уровень сложности теста!");
                error = false;
            }
        }
        else
        {
            for (int i = 0; i < exams.size(); i++)
            {
                if (exams.get(i).equals(examName.getText()))
                {
                    infoWindow.setText("Экзамен с таким названием уже существует!");
                    error = false;
                }
            }
        }
        if (error)
        {
            exams.add(new Exam(examDate.getValue(), examLevel.getValue().toString(), examName.getText(), examTeacher.getText(), examAuditory1, examTickets1));
            infoWindow.setText("Экзамен успешно добавлен!");
            hidePanes(true, true, true);
            examName.clear();
            examLevel.getItems().clear();
            examDate.setValue(null);
            examTeacher.clear();
            examAuditory.clear();
            examTickets.clear();
        }
    }

    @FXML
    void showExams(ActionEvent event)
    {
        hidePanes(true, false, true);
        textInfo.clear();
        for (int i = 0; i < exams.size(); i++)
        {
            textInfo.appendText("=========================================\n");
            textInfo.appendText("Название экзамена: " + exams.get(i).getName() + "\n");
            textInfo.appendText("Уровень сложности теста: " + exams.get(i).getLevel() + "\n");
            textInfo.appendText("Дата проведения теста: " + exams.get(i).getDate() + "\n");
            textInfo.appendText("Преподаватель, принимающий экзамен : " + exams.get(i).getExaminer() + "\n");
            textInfo.appendText("Аудитория: " + exams.get(i).getAuditory() + "\n");
            textInfo.appendText("Кол-во билетов: " + exams.get(i).getExamTicket() + "\n");
            textInfo.appendText("=========================================\n" );
        }
    }

}
