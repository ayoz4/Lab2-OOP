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
    private TextField taskNumber, gradYear, gradName;

    @FXML
    private Pane testPane;

    @FXML
    private ComboBox testLevel, examLevel, gradLevel;

    @FXML
    private DatePicker testDate;

    @FXML
    private TextField testName;

    @FXML
    private TextArea textInfo;

    @FXML
    private Pane showUno, gradPane;

    @FXML
    private TextField examTickets;

    @FXML
    private TextField examAuditory;

    @FXML
    private Pane examPane;

    @FXML
    private DatePicker examDate, gradDate;

    @FXML
    private TextField examName;

    @FXML
    private TextField examTeacher;

    //Функция открытия слоев
    public void hidePanes(boolean testPane, boolean showUno, boolean examPane, boolean gradPane)
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
        if (gradPane)
            this.gradPane.setVisible(false);
        else
            this.gradPane.setVisible(true);
    }



                                                ////////////////////////////////
                                                ////////Создание теста//////////
                                                ////////////////////////////////

    private ArrayList<Test> tests = new ArrayList<>();

    @FXML
    void openTest(ActionEvent event)
    {
        hidePanes(false, true, true, true);
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
                error = false;
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
            ///Запихиваем в коллекцию, которая лежит в базовом абстрактном классе
            Test test = new Test(testDate.getValue(), testLevel.getValue().toString(), testName.getText(), taskNumberInt, "Тест");
            Challenge.challenges.add(test);
            infoWindow.setText("Тест успешно добавлен!");
            hidePanes(true, true, true, true);
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

    ///Показывает все тесты///
    @FXML
    void showTests(ActionEvent event)
    {
        hidePanes(true, false, true, true);
        textInfo.clear();
        String challengeType = "";
        for (int i = 0; i < Challenge.challenges.size(); i++)
        {
            Challenge challenge = Challenge.challenges.get(i);
            if (challenge.getClass().toString().equals("class sample.Test"))
            {
                challengeType = ((Test)challenge).getExtraInfo();
                textInfo.appendText(((Test) challenge).appear(challenge.getDate(), challenge.getLevel(), challenge.getName(), ((Test) challenge).getTaskNumber()));
            }
        }
    }



                                                ////////////////////////////////
                                                ////////Создание экзамена///////
                                                ////////////////////////////////

    ArrayList<Exam> exams = new ArrayList<>();

    @FXML
    void openExam(ActionEvent event)
    {
        hidePanes(true, true, false, true);
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
            //Запихиваем объект в коллекцию класса Challenge
            Exam exam = new Exam(examDate.getValue(), examLevel.getValue().toString(), examName.getText(), examTeacher.getText(), examAuditory1, examTickets1, "Эказмен");
            Challenge.challenges.add(exam);
            infoWindow.setText("Экзамен успешно добавлен!");
            hidePanes(true, true, true, true);
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
        hidePanes(true, false, true, true);
        textInfo.clear();
        String challengeType = "";
        for (int i = 0; i < Challenge.challenges.size(); i++)
        {
            Challenge challenge = Challenge.challenges.get(i);
            if (challenge.getClass().toString().equals("class sample.Exam"))
            {
                challengeType = ((Exam)challenge).getExtraInfo1();
                textInfo.appendText(challenge.appear(challenge.getDate(), challenge.getLevel(), challenge.getName(), ((Exam) challenge).getExaminer(), ((Exam) challenge).getAuditory(), ((Exam) challenge).getExamTicket()));
            }
        }
    }


                                                ////////////////////////////////
                                                //////Создание в. экзамена//////
                                                ////////////////////////////////

    private ArrayList<GradExam> gradExams = new ArrayList<>();

    @FXML
    void openGrad(ActionEvent event)
    {
        hidePanes(true, true, true, false);
        infoWindow.setText("Создание выпсукного экзамена");
        gradLevel.getItems().clear();
        gradLevel.getItems().addAll("Низкий", "Средний", "Высокий");
    }

    @FXML
    void createGrad(ActionEvent event)
    {
        boolean error = true;
        int gradYear1 = 0;
        try
        {
            gradYear1 = Integer.parseInt(gradYear.getText());
        }
        catch (Exception e)
        {
            infoWindow.setText("Некорректные данные!");
            error = false;
        }
        if (error)
        {
            if (gradYear1 > 2030 || gradYear1 < 2000)
            {
                infoWindow.setText("Слишком большой или слишком маленький год!");
                error = false;
            }
        }
        if (error)
        {
            if (gradName.getText().equals(""))
            {
                infoWindow.setText("Укажите название в. экзамена!");
                error = false;
            }
        }
        if (error)
        {
            if (gradDate.getValue() == null)
            {
                infoWindow.setText("Выберите дату проведения в. экзамена!");
                error = false;
            }
        }
        if (error)
        {
            if (gradLevel.getValue() == null)
            {
                infoWindow.setText("Укажите уровень сложности в. экзамена!");
                error = false;
            }
        }
        else
        {
            for (int i = 0; i < gradExams.size(); i++)
            {
                if (gradExams.get(i).equals(gradName.getText()))
                {
                    infoWindow.setText("Экзамен с таким названием уже существует!");
                    error = false;
                }
            }
        }
        if (error)
        {
            //Запихиваем объект в коллекцию класса Challenge
            GradExam gradExam = new GradExam(gradDate.getValue(), gradLevel.getValue().toString(), gradName.getText(), gradYear1, "Выпускной экзамен");
            Challenge.challenges.add(gradExam);
            infoWindow.setText("Экзамен успешно добавлен!");
            hidePanes(true, true, true, true);
            gradName.clear();
            gradLevel.getItems().clear();
            gradDate.setValue(null);
            gradYear.clear();
        }
    }

    @FXML
    void showGradExams(ActionEvent event)
    {
        hidePanes(true, false, true, true);
        textInfo.clear();
        String challengeType = "";
        for (int i = 0; i < Challenge.challenges.size(); i++)
        {
            Challenge challenge = Challenge.challenges.get(i);
            if (challenge.getClass().toString().equals("class sample.GradExam"))
            {
                challengeType = ((GradExam)challenge).getInfo();
                textInfo.appendText(challenge.appear(challenge.getDate(), challenge.getLevel(), challenge.getName(), ((GradExam) challenge).getGradYear()));
            }
        }
    }




                                                        /////////////////////////////////
                                                        /////Показать всю информацию/////
                                                        /////////////////////////////////




    @FXML
    void showAllChallenges(ActionEvent event)
    {
        hidePanes(true, false, true, true);
        textInfo.clear();
        for (int i = 0; i < Challenge.challenges.size(); i++)
        {
            String challengeType = "";
            Challenge challenge = Challenge.challenges.get(i);
            if (challenge.getClass().toString().equals("class sample.Test"))
            {
                challengeType = ((Test)challenge).getExtraInfo();
                textInfo.appendText(challenge.appearAll(challengeType, i));
            }
            if (challenge.getClass().toString().equals("class sample.Exam"))
            {
                challengeType = ((Exam)challenge).getExtraInfo1();
                textInfo.appendText(challenge.appearAll(challengeType, i));
            }
            if (challenge.getClass().toString().equals("class sample.GradExam"))
            {
                challengeType = ((GradExam) challenge).getInfo();
                textInfo.appendText(challenge.appearAll(challengeType, i));
            }
        }
    }
}
