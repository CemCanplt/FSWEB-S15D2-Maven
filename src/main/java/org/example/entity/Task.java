package org.example.entity;

import java.util.Objects;

public class Task {
    // 1. Instance variable’lar
    private String project;
    private String description;
    private String assignee;
    private Priority priority;
    private Status status;

    // 2. Constructor: Tüm değişkenleri başlatır.
    public Task(String project, String description, String assignee, Priority priority, Status status) {
        this.project = project;
        this.description = description;
        this.assignee = assignee;
        this.priority = priority;
        this.status = status;
    }

    // 3. Getter metotları
    public String getProject() {
        return project;
    }

    public String getDescription() {
        return description;
    }

    public String getAssignee() {
        return assignee;
    }

    public Priority getPriority() {
        return priority;
    }

    public Status getStatus() {
        return status;
    }

    // 4. equals() metodunu override ediyoruz
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;                  // Aynı referans mı kontrolü
        if (o == null || getClass() != o.getClass()) return false; // Null veya farklı tipteyse false
        Task task = (Task) o;
        // Eşitlik, sadece project ve description’a göre kontrol ediliyor.
        return Objects.equals(project, task.project) &&
                Objects.equals(description, task.description);
    }

    // 5. hashCode() metodunu override ediyoruz
    @Override
    public int hashCode() {
        // project ve description üzerinden hash kodu oluşturuluyor.
        return Objects.hash(project, description);
    }

    @Override
    public String toString() {
        return "Task{" +
                "project='" + project + '\'' +
                ", description='" + description + '\'' +
                ", assignee='" + assignee + '\'' +
                ", priority=" + priority +
                ", status=" + status +
                '}';
    }
}
