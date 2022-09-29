package ru.onekun.shedule2x2_new_version;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Day {
    private int id;
    private LocalDate dayOfCalendar;
    private String dayString;
    private boolean isWork;
}
