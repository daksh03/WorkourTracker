package com.example.workout_tracker.service;

import java.util.List;

import com.example.workout_tracker.dto.WorkoutDTO;

public interface WorkoutService {
	
	String addWorkout(WorkoutDTO workoutDTO);
	
	List<WorkoutDTO> getAllWorkouts();

	List<WorkoutDTO> getByMuscleGroup(String muscleGroup);

}
