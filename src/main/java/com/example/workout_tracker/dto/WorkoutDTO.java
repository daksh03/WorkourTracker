package com.example.workout_tracker.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WorkoutDTO {
	
	private String exercise;
	private String muscleGroup;
	private int sets;
	private int reps;
	private LocalDate date;

}
