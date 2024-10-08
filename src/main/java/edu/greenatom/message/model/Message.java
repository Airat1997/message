package edu.greenatom.message.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.util.Date;
import java.util.UUID;

@Entity
public class Message {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "UUID")
    private UUID id;
    @Column(name = "content", columnDefinition = "TEXT")
    private String fileContent;
    @Column(name = "creation_date")
    private Date creationDate;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
