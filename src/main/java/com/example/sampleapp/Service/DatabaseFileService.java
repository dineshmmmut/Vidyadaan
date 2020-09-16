package com.example.sampleapp.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.example.sampleapp.Controller.response.Response;
import com.example.sampleapp.exception.FileNotFoundException;
import com.example.sampleapp.exception.FileStorageException;
import com.example.sampleapp.model.DatabaseFile;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.print.DocFlavor;


@Service
public class DatabaseFileService {

    @Autowired
    private DatabaseFileRepository dbFileRepository;

    public DatabaseFile storeFile(MultipartFile file) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            DatabaseFile dbFile = new DatabaseFile(fileName, file.getContentType(), file.getBytes());

            return dbFileRepository.save(dbFile);
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    public DatabaseFile getFile(String fileId) {
        return dbFileRepository.findById(fileId)
                .orElseThrow(() -> new FileNotFoundException("File not found with id " + fileId));
    }


    public List<Response> getFiles(){
        List<Response> responseList= new ArrayList<>();

        List<DatabaseFile> list= dbFileRepository.findAll();


        try {
            for(int c=0;c<list.size();c++){
                String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                        .path("/downloadFile/")
                        .path(list.get(c).getFileName())
                        .toUriString();
                String name []= list.get(c).getFileName().split(".");
                Response response= new Response(list.get(c).getFileName(),fileDownloadUri,list.get(c).getFileType(),list.get(c).getFileType().length());
                responseList.add(response);

            }
        } catch (ArrayIndexOutOfBoundsException e) {
            Response response= new  Response("array index out of bound---"+e.getMessage(),"","",1);
           responseList.add(response);
            e.printStackTrace();
        }

        return responseList;
    }
}