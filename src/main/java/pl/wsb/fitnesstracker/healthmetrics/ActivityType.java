package pl.wsb.fitnesstracker.healthmetrics;

import jakarta.persistence.*;

@Entity
@Table(name = "ACTIVITY_TYPE")
public class ActivityType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String activityType;

    public ActivityType() {
    }

    public ActivityType(Long id, String activityType) {
        this.id = id;
        this.activityType = activityType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }
}