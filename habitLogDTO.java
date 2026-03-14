package com.mind.trail.MindTrail;

import java.time.LocalDate;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class habitLogDTO {

    @Id
    private ObjectId id;
    private ObjectId userId;
    @NotBlank(message="Habit name cannot be blank")
    private String habitName;
    private LocalDate logDate;
    private Boolean active;
    private Boolean completed;
}
