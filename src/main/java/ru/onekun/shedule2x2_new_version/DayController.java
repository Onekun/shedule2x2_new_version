package ru.onekun.shedule2x2_new_version;



import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class DayController {
    private final DayService dayService;

    public DayController(DayService dayService) {
        this.dayService = dayService;
    }

    @RequestMapping(method = RequestMethod.GET, value="/workdays")
    public List<Day> getWorkDays(){
        return dayService.getWorkDays();
    }
    @RequestMapping(method=RequestMethod.POST, value="/workdays")
    @ResponseBody
    public String setDays(@RequestBody Day day){
        dayService.setDays(day);
        return "Set days normal";
    }
    @ResponseBody
    @RequestMapping(method=RequestMethod.PATCH, value="/workdays")
    public void updateDay(@RequestBody Day day){
        dayService.updateWorkDay(day);
    }
}
