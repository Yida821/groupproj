package com.example.groupproject1.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "user")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"create_time", "update_time"},
        allowGetters = true)
public class UserDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;


    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column
    private String email;

    @Column
    private String phone;

    @Column
    private String question;

    @Column
    private String answer;

    @Column
    private String role;

   @OneToMany(fetch=FetchType.LAZY,
            mappedBy="user",
            cascade= {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    private List<Project> projects;

   /* @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date create_time;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date update_time;*/

    public UserDetail(){}

    public UserDetail(String username, String password, String email, String phone, String question, String answer, String role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.question = question;
        this.answer = answer;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

   public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

   /* public Date getCreate_time() {
        return create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }*/

    @Override
    public String toString() {
        return super.toString();
    }
}
