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
    private int sub1_mse;
    private int sub1_ese;
    private int sub2_mse;
    private int sub2_ese;
    private int sub3_mse;
    private int sub3_ese;
    private int sub4_mse;
    private int sub4_ese;
}