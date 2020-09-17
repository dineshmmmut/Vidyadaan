package com.example.sampleapp.Controller;

import com.example.sampleapp.Controller.response.ErrorClass;
import com.example.sampleapp.Service.BuyCorsesRepo;
import com.example.sampleapp.model.BuyCourses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class BuyCoursesController {

    @Autowired
    BuyCorsesRepo buyCorsesRepo;
    private List<BuyCourses> listBuyCourse;


    @PostMapping("/buyCourse")
    public Map<String, String> buyCourse(@RequestBody List<BuyCourses> buyCourses) {
        //check if user already exist
        //put in try catch block
        //create a custom exception/
        //change the return type
        Map<String, String> map = new HashMap<>();
        String message = "";
        if (buyCourses != null) {
            message = "Your record save successfully";
            map.put("message", message);
            buyCorsesRepo.saveAll(buyCourses);
        } else {
            map.put("errorMessage", message);

        }
        return map;
    }

//@GetMapping("/getBuyCourse")
//    public List<BuyCourses> getUser(){
//
//        return (List<BuyCourses>) buyCorsesRepo.findAll();
//    }

    @GetMapping("/getBuyCourse")
    public Object getUser() {

        ErrorClass errorClass = new ErrorClass();

        try {
            listBuyCourse = buyCorsesRepo.findAll();
            if (listBuyCourse != null) {

            }
        } catch (Exception e) {
            errorClass.setMessage("service error！：" + e.getMessage());
            errorClass.setErrorCode("affected：" + e.getCause());
            e.printStackTrace();
            return errorClass;

        }

        return listBuyCourse;
    }


    @PostMapping("/getBuyCourseId{ProId}")
    public Object getCourseCatId(@RequestParam String ProId) {


        ErrorClass errorClass = new ErrorClass();
        BuyCourses listBuyCourses;
        try {
            listBuyCourses = buyCorsesRepo.findBuyCoursesByProId(ProId);
            boolean mess = listBuyCourses.getDuration().length() >= 0;
        } catch (Exception e) {
            errorClass.setErrorCode("service error！：" + e.getMessage());
            errorClass.setMessage("Please insert required field");
            e.printStackTrace();
            return errorClass;

        }

        return listBuyCourses;
    }
//
//    @GetMapping("/userLogin/{email}")
//    public List<UserLogin> getUser(@PathVariable("email") String email,@PathVariable("email") String email){
//        return (List<UserLogin>) userRepo.findUserLoginByEmailAndPassword(email);
//    }


}