package sample;
import sample.*;

import java.time.LocalDate;

public class Test extends Challenge
{
    private int taskNumber;             //Кол-во заданий
    private String extraInfo;           //Тип испытания

    public Test(LocalDate date, String level, String name, int taskNumber, String extraInfo)
    {
        super(date, level, name);
        this.taskNumber = taskNumber;
        this.extraInfo = extraInfo;
    }

    public int getTaskNumber()
    {
        return taskNumber;
    }

    @Override
    public String appear(LocalDate date, String level, String name, int taskNumber)
    {
        String data = "";
        data = data + "=========================" + "\n";
        data = data + "Имя теста: " + name + "\n";
        data = data + "Уровеь сложности теста: " + level + "\n";
        data = data + "Дата теста: " + date + "\n";
        data = data + "Кол-во заданий: " + taskNumber + "\n";
        data = data + "=========================" + "\n";
        return data;
    }

    @Override
    protected String appear(LocalDate date, String level, String name, String examiner, int auditory, int examTicket)
    {
        return null;
    }

    public String getExtraInfo()
    {
        return extraInfo;
    }
}
