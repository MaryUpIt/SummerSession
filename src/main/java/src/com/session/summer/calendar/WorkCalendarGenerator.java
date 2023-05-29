package src.com.session.summer.calendar;

import src.com.session.summer.view.Printer;
import src.com.session.summer.view.Reader;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Map;
import java.util.TreeMap;

public class WorkCalendarGenerator extends Calendar {

    public WorkCalendarGenerator(Reader reader, Printer printer) {
        super(reader, printer);
    }

    @Override

    public void execute() {
        LocalDate inputDate = getDate();
        Map<LocalDate, Boolean> schedule = generateSchedule(inputDate, 3, 1);
        schedule.forEach((date, isWorking) -> printer.printNewLine(date.format(formatter) + " is " + (isWorking ? "working day" : "weekend")));

    }

    private Map<LocalDate, Boolean> generateSchedule(LocalDate date, int workingDays, int weekend) {
        Map<LocalDate, Boolean> schedule = new TreeMap<>();
        LocalDate currentDate = firstDay(date);
        int tmpWorking = workingDays;

        while (currentDate.getMonth() == date.getMonth()) {
            boolean isWorkingDay = true;
            if (tmpWorking == 0) {
                isWorkingDay = false;
                int tmpWeekend = weekend;
                while (tmpWeekend > 0) {
                    schedule.put(currentDate, isWorkingDay);
                    currentDate = currentDate.plusDays(1);
                    tmpWeekend--;
                }
                tmpWorking = workingDays;
            } else {
                if (isSunday(currentDate) && isWorkingDay) {
                    isWorkingDay = false;
                    tmpWorking++;
                }

                schedule.put(currentDate, isWorkingDay);
                currentDate = currentDate.plusDays(1);
                tmpWorking--;
            }


        }
        return schedule;
    }

    private LocalDate firstDay(LocalDate date) {
        return date.withDayOfMonth(1);
    }

    private boolean isSunday(LocalDate date) {
        return date.getDayOfWeek() == DayOfWeek.SUNDAY;
    }
}
