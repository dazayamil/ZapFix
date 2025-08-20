package com.teamzapfix.zapfix.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "client")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String phone;
    private String email;

    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
    private List<Job> jobs = new ArrayList<>();
}
