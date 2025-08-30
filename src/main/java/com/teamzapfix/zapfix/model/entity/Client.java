package com.teamzapfix.zapfix.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "client")
@NoArgsConstructor
@Getter
@Setter
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String phone;
    private String email;
    private Boolean isActive;

    public Client(String name, String phone, String email){
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.isActive = true;
    }

    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
    private List<Job> jobs = new ArrayList<>();
}