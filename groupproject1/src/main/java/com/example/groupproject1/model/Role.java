package com.example.groupproject1.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

///以后能用上，现在role在user里，用不上
@Entity
@Table(name = "Roles")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @ManyToMany(mappedBy = "roles")
    private List <User> users;

}