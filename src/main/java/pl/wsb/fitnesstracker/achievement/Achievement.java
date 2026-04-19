package pl.wsb.fitnesstracker.achievement;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import pl.wsb.fitnesstracker.user.api.User;

import java.time.LocalDateTime;

@Entity
@Table(name = "achievement")
public class Achievement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private LocalDateTime earnedAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Achievement() {
    }

    public Achievement(String name, LocalDateTime earnedAt, User user) {
        this.name = name;
        this.earnedAt = earnedAt;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getEarnedAt() {
        return earnedAt;
    }

    public User getUser() {
        return user;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEarnedAt(LocalDateTime earnedAt) {
        this.earnedAt = earnedAt;
    }

    public void setUser(User user) {
        this.user = user;
    }
}