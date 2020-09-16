package com.example.sampleapp.Service;

import com.example.sampleapp.model.DatabaseFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DatabaseFileRepository extends JpaRepository<DatabaseFile, String> {

}