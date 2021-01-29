package de.htwg.retroweb.entities;


import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Retros")
public class Retro extends AbstractEntity {
	
private static final long serialVersionUID = 1L;

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@Column(name = "name", nullable = false)
@Size(max = 255)
private String name;

@Column(name = "isactive", nullable = false)
private boolean active;

@Column(name = "scheduled", nullable = false)
private Date scheduled;

@ManyToOne(fetch = FetchType.LAZY, optional = false)
@JoinColumn(name = "project_id", nullable = false)
private Project project;

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public boolean isActive() {
	return active;
}

public void setActive(boolean active) {
	this.active = active;
}

public Date getScheduled() {
	return scheduled;
}

public void setScheduled(Date scheduled) {
	this.scheduled = scheduled;
}

public Project getProject() {
	return project;
}

public void setProject(Project project) {
	this.project = project;
}

}
