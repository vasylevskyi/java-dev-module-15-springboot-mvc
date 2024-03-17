package ua.goit.springbootmvc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import ua.goit.springbootmvc.service.NoteService;

@RequiredArgsConstructor
@Controller
public class NoteController {
    private final NoteService noteService;
/*    public ModelAndView postNote()*/

}
