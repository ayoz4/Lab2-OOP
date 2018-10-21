package sample;
import sample.*;

import java.time.LocalDate;

public class Test extends Challenge
{
    private int taskNumber;             //Кол-во заданий

    public Test(LocalDate date, String level, String name, int taskNumber)
    {
        super(date, level, name);
        this.taskNumber = taskNumber;
    }

    public int getTaskNumber()
    {
        return taskNumber;
    }
}
