package com.harsh.entity;

/**
 * Created by Harsh on 6/29/2017.
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

/**
 * Created by Harsh on 6/27/2017.
 */
@Entity
public class Alert {

    @Id
    @Column(columnDefinition = "VARCHAR(36)")
    private String aid;

    private String type;
    private String message;
    private String priority;
    private String timestamp;

    public Alert(String timestamp) {
        this.aid = UUID.randomUUID().toString();
        this.timestamp = timestamp;
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}