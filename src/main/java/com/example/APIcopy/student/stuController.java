package com.example.API.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(path = "api/v1/student")
public class stuController {
    private  stuService stuService;
@Autowired
    public stuController(com.example.API.student.stuService stuService) {
        this.stuService = stuService;
    }

    @GetMapping
    public List<student>getStudents(){
        return stuService.getStudents();
    }
   @PostMapping
    public void registerNewStudent(@RequestBody student student){
    stuService.addNewStudent(student);
    }
    @DeleteMapping(path="{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId){
    stuService.deleteStudent(studentId);
    }

    @PutMapping
    public void updateStudent(
            @PathVariable("studentId")Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email){
        stuService.updateStudent(studentId,name,email);

    }

}
