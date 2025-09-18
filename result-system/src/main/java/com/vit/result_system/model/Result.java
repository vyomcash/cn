package com.vit.result_system.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data // Lombok annotation for getters, setters, etc.
@Entity
@Table(name = "results")
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // Make sure these variable names match your frontend expectations
    // e.g., regNo, studentName
    private String regNo;
    private String studentName;
    private int sub1Mse;
    private int sub1Ese;
    private int sub2Mse;
    private int sub2Ese;
    private int sub3Mse;
    private int sub3Ese;
    private int sub4Mse;
    private int sub4Ese;
}