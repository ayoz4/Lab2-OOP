package sample;
import sample.*;

import java.time.LocalDate;

public class GradExam extends Challenge
{
    private int gradYear;           //Год выпуска

    public GradExam(LocalDate date, String level, String name, int gradYear) {
        super(date, level, name);
        this.gradYear = gradYear;
    }
}
