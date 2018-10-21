package sample;
import sample.*;
import java.time.LocalDate;

public abstract class Challenge
{
    private LocalDate date;         //Дата испытания
    private String level;           //Сложность
    private String name;            //Название

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
}
