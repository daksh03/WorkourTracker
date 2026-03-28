package com.example.workout_tracker.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WorkoutDTO {

	@NotBlank(message = "Exercise cant be blank")
	private String exercise;
	@NotBlank(message = "Muscle Group cant be blank")
	private String muscleGroup;
	@Min(value = 1)
	private int sets;
	@Min(value = 1)
	private int reps;
	@NotNull(message = "Date is required.")
	@PastOrPresent(message = "Date cannot be in the future.")
	private LocalDate date;

}
