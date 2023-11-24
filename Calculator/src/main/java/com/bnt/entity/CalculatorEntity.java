package com.bnt.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "calculator")
@Getter
@Setter
public class CalculatorEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column( name = "request")
    private String request;

    @Column( name = "response")
    private String response;

    @CreationTimestamp
    @Column( name = "createdOn")
    private LocalDateTime createdOn;
}
