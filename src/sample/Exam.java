package sample;
import sample.*;
import java.time.LocalDate;

public class Exam extends Challenge
{
    private String examiner;          //Кто принимает экзамен
    private int auditory;          //Номер аудитории
    private int examTicket;           //Кол-во экзаменационных билетов
    private String extraInfo1;

    public Exam(LocalDate date, String level, String name, String examiner, int auditory, int examTicket, String mod)
    {
        super(date, level, name);
        this.examiner = examiner;
        this.auditory = auditory;
        this.examTicket = examTicket;
        extraInfo1 = mod;
    }

    public String getExaminer()
    {
        return examiner;
    }

    public int getAuditory()
    {
        return auditory;
    }

    public int getExamTicket()
    {
        return examTicket;
    }

    @Override
    public String appear(LocalDate date, String level, String name, String type) {
        String data = "";
        data = data + "Имя теста: " + name + "\n";
        data = data + "Уровеь сложности теста: " + level + "\n";
        data = data + "Дата теста: " + date + "\n";
        //data = data + "Тип испытания: " + type + "\n";
        return data;
    }

    @Override
    public String appear(LocalDate date, String level, String name)
    {
        String info = "";
        info = info + "Название: " + name + "\n";
        info = info + "Уровень сложности: " + level + "\n";
        info = info + "Дата испытания: " + date + "\n";
        return info;
    }

    public String getExtraInfo1()
    {
        return extraInfo1;
    }
}
