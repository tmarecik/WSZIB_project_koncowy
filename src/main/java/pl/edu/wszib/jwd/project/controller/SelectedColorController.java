package pl.edu.wszib.jwd.project.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.thymeleaf.util.StringUtils;
import pl.edu.wszib.jwd.project.dao.SelectedColorDao;
import pl.edu.wszib.jwd.project.model.SelectedColor;

import java.util.Date;

@Controller                    // to nie jest rest controler bo nie ma potrzeby wysyłania zapytn do innej aplikacji, wszystkie widoki ida na zdefiniowane view html'owe
public class SelectedColorController {

    @Autowired
    SelectedColorDao selectedColorDao;

    @Value("${app.title.select}")
    private String title;

    @GetMapping({"/select/{color}","/select"})    //mozliwe dwa wywolani
    public String selectColorPage(@PathVariable(required = false) String color, Model model){

        if(!StringUtils.isEmpty(color)){
            //zapis do bazy
            selectedColorDao.save( new SelectedColor(color, new Date()));   //to jest obsługa klikana po kolorach
        }

        String[][] colors = {
                {"red","blue","purple","teal"},
                {"black","orange", "yellow", "green"},
                {"gray","silver", "olive", "lime"},
                {"navy","lime", "aqua", "fuchsia"}
        };

        model.addAttribute("colors", colors);
        model.addAttribute("title", title);     //atrybut bedzie widoczny w naszym szablonie
        return "select";
    }



}
