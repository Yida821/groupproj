package com.example.groupproject1.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "resource")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"create_time", "update_time"},
        allowGetters = true)
public class Resource {
	
    @Id
	@Column(name ="resource_code")
    private int resourceCode;


    @Column(nullable = false,name ="resource_name",unique = true)
    private String resourceName;
  
   /* @Column(nullable = false, updatable = false, name="create_time")
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createTime;

    @Column(nullable = false, name="update_time")
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updateTime;*/
    
    //@ManyToMany(cascade=CascadeType.ALL)
    //@JoinTable(name="project_resource", joinColumns=@JoinColumn(name="resource_code"), inverseJoinColumns=@JoinColumn(name="project_code"))
	//private List<Project> projects;
	@JsonBackReference
	@OneToMany(fetch=FetchType.LAZY,
			mappedBy="resource",
			cascade= {CascadeType.PERSIST, CascadeType.MERGE,
					CascadeType.DETACH, CascadeType.REFRESH})
	private List<ProjectResource> projectResource;

    public Resource(){}

	public Resource(int resource_code,String resource_name) {
		this.resourceCode = resource_code;
		this.resourceName = resource_name;
	}

	public int getResourceCode() {
		return resourceCode;
	}

	public void setResourceCode(int resource_code) {
		this.resourceCode = resource_code;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resource_name) {
		this.resourceName = resource_name;
	}

	/*public Date getCreateTime() {
		return createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}*/

	public List<ProjectResource> getProjectResource() {
		return projectResource;
	}

	public void setProjectResource(List<ProjectResource> projectResource) {
		this.projectResource = projectResource;
	}
}
