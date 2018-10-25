package sample;
import sample.*;

import java.time.LocalDate;

public class GradExam extends Challenge
{
    private int gradYear;           //Год выпуска
    private String info;

    public GradExam(LocalDate date, String level, String name, int gradYear, String tip)
    {
        super(date, level, name);
        this.gradYear = gradYear;
        info = tip;
    }

    public int getGradYear()
    {
        return gradYear;
    }

    /*@Override
    public String appear(LocalDate date, String level, String name)
    {
        String info = "";
        info = info + "Название: " + name + "\n";
        info = info + "Уровень сложности: " + level + "\n";
        info = info + "Дата испытания: " + date + "\n";
        return info;
    }

    @Override
    public String appear(LocalDate date, String level, String name, String type) {
        String info = "";
        info = info + "Название: " + name + "\n";
        info = info + "Уровень сложности: " + level + "\n";
        info = info + "Дата испытания: " + date + "\n";
        info = info + "Тип испытания: " + type + "\n";
        return info;
    }*/

    @Override
    protected String appear(LocalDate date, String level, String name, String examiner, int auditory, int examTicket)
    {
        return null;
    }

    @Override
    protected String appear(LocalDate date, String level, String name, int gradYear)
    {
        String info = "";
        info = info + "Название: " + name + "\n";
        info = info + "Уровень сложности: " + level + "\n";
        info = info + "Дата испытания: " + date + "\n";
        info = info + "Год выпуска: " + gradYear + "\n";
        return info;
    }

    public String getInfo()
    {
        return info;
    }
}
