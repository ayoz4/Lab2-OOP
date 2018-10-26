package sample;
import sample.*;

import java.time.LocalDate;

public class GradExam extends Challenge
{
    private int gradYear;           //Год выпуска
    private String info;            //Тип испытания

    public GradExam(LocalDate date, String level, String name, int gradYear, String info)
    {
        super(date, level, name);
        this.gradYear = gradYear;
        this.info = info;
    }

    public int getGradYear()
    {
        return gradYear;
    }

    @Override
    protected String appear(LocalDate date, String level, String name, String examiner, int auditory, int examTicket)
    {
        return null;
    }

    @Override
    protected String appear(LocalDate date, String level, String name, int gradYear)
    {
        String info = "";
        info = info + "=========================" + "\n";
        info = info + "Название: " + name + "\n";
        info = info + "Уровень сложности: " + level + "\n";
        info = info + "Дата испытания: " + date + "\n";
        info = info + "Год выпуска: " + gradYear + "\n";
        info = info + "=========================" + "\n";
        return info;
    }

    public String getInfo()
    {
        return info;
    }
}
