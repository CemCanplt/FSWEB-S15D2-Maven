package org.example.entity;

import java.util.HashSet;
import java.util.Set;

public class TaskData {

    private Set<Task> annsTasks;
    private Set<Task> bobsTasks;
    private Set<Task> carolsTasks;
    private Set<Task> unassignedTasks;

    public TaskData(Set<Task> annsTasks, Set<Task> bobsTasks, Set<Task> carolsTasks, Set<Task> unassignedTasks) {
        this.annsTasks = annsTasks;
        this.bobsTasks = bobsTasks;
        this.carolsTasks = carolsTasks;
        this.unassignedTasks = unassignedTasks;
    }

    public Set<Task> getTask(String person) {
        switch (person.toLowerCase()) {
            case "ann":
                return new HashSet<>(annsTasks);
            case "bob":
                return new HashSet<>(bobsTasks);
            case "carol":
                return new HashSet<>(carolsTasks);
            case "all":
                Set<Task> allTasks = new HashSet<>();
                allTasks.addAll(annsTasks);
                allTasks.addAll(bobsTasks);
                allTasks.addAll(carolsTasks);
                return allTasks;
            default:
                return new HashSet<>();
        }
    }

    // 4. getUnion() metodu: Verilen set'lerin birleşimini döner.
    public Set<Task> getUnion(Set<Task>... sets) {
        Set<Task> result = new HashSet<>();
        // Her bir set'in elemanlarını result set'ine ekle.
        for (Set<Task> set : sets) {
            result.addAll(set);
        }
        return result;
    }

    // 5. getIntersect() metodu: İki set arasındaki kesişimi bulur.
    public Set<Task> getIntersect(Set<Task> set1, Set<Task> set2) {
        Set<Task> result = new HashSet<>(set1);
        // result set'inde sadece set2'de olanları tut.
        result.retainAll(set2);
        return result;
    }

    // 6. getDifference() metodu: İlk set'ten ikinci set'in elemanlarını çıkarır.
    public Set<Task> getDifference(Set<Task> set1, Set<Task> set2) {
        Set<Task> result = new HashSet<>(set1);
        // set2'de olan elemanları result'tan çıkar.
        result.removeAll(set2);
        return result;
    }

    // Ekstra metot: Birden fazla çalışana atanmış task'ları bulma
    // (Yani aynı task birden fazla set'te varsa.)
    public Set<Task> getTasksAssignedToMultiple() {
        Set<Task> allTasks = getUnion(annsTasks, bobsTasks, carolsTasks, unassignedTasks);
        Set<Task> multipleAssigned = new HashSet<>();
        // Eğer bir task, birden fazla set'te varsa onu ekle.
        for (Task task : allTasks) {
            int count = 0;
            if (annsTasks.contains(task)) count++;
            if (bobsTasks.contains(task)) count++;
            if (carolsTasks.contains(task)) count++;
            if (count > 1) {
                multipleAssigned.add(task);
            }
        }
        return multipleAssigned;
    }

    
}














































