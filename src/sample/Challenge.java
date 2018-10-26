package sample;
import sample.*;
import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Challenge
{
    private LocalDate date;         //Дата испытания
    private String level;           //Сложность
    private String name;            //Название
    protected static ArrayList<Challenge> challenges = new ArrayList<>();   //Массив для хранения всех объектов

    public Challenge(LocalDate date, String level, String name)
    {
        this.date = date;
        this.level = level;
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public String getLevel()
    {
        return level;
    }

    public LocalDate getDate()
    {
        return date;
    }

    abstract protected String appear(LocalDate date, String level, String name, String examiner, int auditory, int examTicket);  ///Для генерации информации об экзамене

    abstract protected String appear(LocalDate date, String level, String name, int taskNumber);    //Для генерации информации о тесте или в. экзамене

    public static String appearAll(String type, int i)    //Для выводв всех объектов
    {
        String info = "";
            info = info + "=========================" + "\n";
            info = info + "Название: " + challenges.get(i).name + "\n";
            info = info + "Уровень сложности: " + challenges.get(i).level + "\n";
            info = info + "Дата испытания: " + challenges.get(i).date + "\n";
            info = info + "Тип испытания: " + type + "\n";
            info = info + "=========================" + "\n";
        return info;
    }
}
