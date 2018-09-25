package eci.cosw.data.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Todo {

    @Id
    private String description;

    private String priority;

    private String dueDate;


    private String responsible;

    private String status;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getResponsible() {
        return responsible;
    }

    public void setResponsible(String responsible) {
        this.responsible = responsible;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public Todo() {
    }

    public Todo(String description, String priority, String dueDate, String responsible,String status) {
        this.description =description;
        this.priority=priority;
        this.dueDate=dueDate;
        this.responsible =responsible;
        this.status=status;
    }

    @Override
    public String toString() {
        return String.format(
                "Todo[description='%s',priority='%s',dueDate='%s',responsible='%s' ,status='%s']",
                description,priority, dueDate,responsible,status);
    }


}