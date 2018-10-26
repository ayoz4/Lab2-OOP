package sample;
import sample.*;
import java.time.LocalDate;

public class Exam extends Challenge
{
    private String examiner;          //Кто принимает экзамен
    private int auditory;          //Номер аудитории
    private int examTicket;           //Кол-во экзаменационных билетов
    private String extraInfo1;          //Тип испытания

    public Exam(LocalDate date, String level, String name, String examiner, int auditory, int examTicket, String extraInfo1)
    {
        super(date, level, name);
        this.examiner = examiner;
        this.auditory = auditory;
        this.examTicket = examTicket;
        this.extraInfo1 = extraInfo1;
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
    public String appear(LocalDate date, String level, String name, String examiner, int auditory, int examTicket) {
        String data = "";
        data = data + "=========================" + "\n";
        data = data + "Имя теста: " + name + "\n";
        data = data + "Уровеь сложности теста: " + level + "\n";
        data = data + "Дата теста: " + date + "\n";
        data = data + "Преподаватель: " + examiner + "\n";
        data = data + "Аудитория: " + auditory + "\n";
        data = data + "Кол-во билетов: " + examTicket + "\n";
        data = data + "=========================" + "\n";
        return data;
    }

    @Override
    protected String appear(LocalDate date, String level, String name, int gradYear)
    {
        return null;
    }

    public String getExtraInfo1()
    {
        return extraInfo1;
    }
}
