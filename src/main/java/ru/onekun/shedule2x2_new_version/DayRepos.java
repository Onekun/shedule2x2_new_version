package ru.onekun.shedule2x2_new_version;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DayRepos {
    @Select("SELECT * from shedule2x2.days WHERE is_work=true")
    List<Day> getWorkDays();
    @Insert("INSERT into shedule2x2.days(id, day_of_calendar, day_string, is_work) VALUES(#{day.id},#{day.dayOfCalendar},#{day.dayString},#{day.isWork})")
    long save(@Param("day") Day day);
    /**
    Изменение дня на рабочий
    */
    @Update("UPDATE shedule2x2.days SET is_work=#{day.isWork} WHERE id=#{day.id}")
    long update (@Param("day") Day day1);
}
