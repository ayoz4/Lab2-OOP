package sample;
import sample.*;

import java.time.LocalDate;

public class Test extends Challenge
{
    private int taskNumber;             //Кол-во заданий
    private String extraInfo;

    public Test(LocalDate date, String level, String name, int taskNumber, String type)
    {
        super(date, level, name);
        this.taskNumber = taskNumber;
        extraInfo = type;
    }

    public int getTaskNumber()
    {
        return taskNumber;
    }

    @Override
    public String appear(LocalDate date, String level, String name, String type)
    {
        String data = "";
        data = data + "Имя теста: " + name + "\n";
        data = data + "Уровеь сложности теста: " + level + "\n";
        data = data + "Дата теста: " + date + "\n";
        data = data + "Тип испытания: " + type + "\n";
        return data;
    }

    @Override
    protected String appear(LocalDate date, String level, String name)
    {
        String data = "";
        data = data + "Имя теста: " + name + "\n";
        data = data + "Уровеь сложности теста: " + level + "\n";
        data = data + "Дата теста: " + date + "\n";
        return data;
    }

    public String getExtraInfo() {
        return extraInfo;
    }
}
