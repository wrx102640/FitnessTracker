package pl.wsb.fitnesstracker.measurementnote;

import jakarta.persistence.*;
import pl.wsb.fitnesstracker.healthmetrics.HealthMetrics;

@Entity
@Table(name = "MEASUREMENT_NOTE")
public class MeasurementNote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "health_metrics_id", nullable = false)
    private HealthMetrics healthMetrics;

    @Column(nullable = false)
    private String note;

    public MeasurementNote() {
    }

    public MeasurementNote(Long id, HealthMetrics healthMetrics, String note) {
        this.id = id;
        this.healthMetrics = healthMetrics;
        this.note = note;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public HealthMetrics getHealthMetrics() {
        return healthMetrics;
    }

    public void setHealthMetrics(HealthMetrics healthMetrics) {
        this.healthMetrics = healthMetrics;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
