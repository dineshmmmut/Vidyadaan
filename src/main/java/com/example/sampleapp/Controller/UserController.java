package com.example.sampleapp.Controller;

import com.example.sampleapp.Service.UserRepo;
import com.example.sampleapp.model.User;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserRepo userRepo;

    @PostMapping("/saveUser")
    public String insertUser(@RequestBody User user){
        userRepo.save(user);
        return "Your record save successfully";
    }

   @PostMapping("/saveListUser")
    public String insertUser(@Valid @RequestBody List<User> user){
        //check if user already exist
       //put in try catch block
       //create a custom exception/
       //change the return type
        userRepo.saveAll(user);
        return "Record save successfully";
    }
    @RequestMapping(value="/upload", method=RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Object> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        File convertFile = new File("C:\\Users\\GTPL IT\\Downloads\\src\\main\\java\\com\\talk2amareswaran\\projects\\fileuploaddemo"+file.getOriginalFilename());
        convertFile.createNewFile();
        FileOutputStream fout = new FileOutputStream(convertFile);
        fout.write(file.getBytes());
        fout.close();
        return new ResponseEntity<>("File is uploaded successfully", HttpStatus.OK);
    }

     @GetMapping("/findListUser")
    public List<User> getUser(){
        return (List<User>) userRepo.findAll();
    }

    @GetMapping("/findByUserEmail/{email}")
    public List<User> getUser(@PathVariable("email") String email){
        return (List<User>) userRepo.findByEmail(email);
    }


}