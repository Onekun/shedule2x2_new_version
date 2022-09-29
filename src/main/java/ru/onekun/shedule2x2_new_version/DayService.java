package ru.onekun.shedule2x2_new_version;

import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class DayService {
    private final DayRepos dayRepos;

    public DayService(DayRepos dayRepos) {
        this.dayRepos = dayRepos;
    }

    public void setDays(Day firstWorkDay) {
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd LLLL yyyy E");
        LocalDate localDate=LocalDate.now();
        List<Day> days = new ArrayList<>();
        /**
         Заполнение календаря днями
         */
        for (int i = 0; i < 62; i++) {
            Day day=new Day(i,localDate.plusDays(i),dtf.format(localDate.plusDays(i)),false);
            days.add(day);
            dayRepos.save(days.get(i));
        }
        /**
         Поиск в листе с какого числа заполнять календарь
         */
        Day firstDay = new Day();
        for (int i = 0; i < days.size() - 1; i++) {
            if (firstWorkDay.getDayOfCalendar().equals(days.get(i).getDayOfCalendar())) {
                firstDay = days.get(i);
            }
        }
        /**
         Заполнение календаря рабочими днями
         */
        int count = 0;
        for (int i = firstDay.getId(); i < days.size() - firstDay.getId(); i++) {
            if (count == 0 || count == 1) {
                days.get(i).setWork(true);
                dayRepos.update(days.get(i));
            }
            count++;
            if (count == 4) count = 0;
        }
    }

    public List<Day> getWorkDays(){
        return dayRepos.getWorkDays();
    }
    public void updateWorkDay(Day day){
        dayRepos.update(day);
    }
}
