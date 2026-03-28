package com.example.workout_tracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.workout_tracker.dto.WorkoutDTO;
import com.example.workout_tracker.service.WorkoutService;

import jakarta.validation.Valid;

@RestController
public class WorkoutController {
	
	@Autowired
	private WorkoutService workoutService;
	
	@GetMapping("/getAll")
	public List<WorkoutDTO> getAllWorkOuts() {
		
		return workoutService.getAllWorkouts();
	}
	
	@PostMapping("/post")
	public String postWorkout(@RequestBody @Valid WorkoutDTO workoutdto) {

		if(null!=workoutdto) {
			workoutService.addWorkout(workoutdto);
			return "Successful";
		}
		return "Detail's cant be empty";
	}
	
	@GetMapping("/workouts/muscle/{muscleGroup}")
	public List<WorkoutDTO> getWorkoutByMuscle(@PathVariable String muscleGroup) {
		return workoutService.getByMuscleGroup(muscleGroup);
	}
	
	@GetMapping("/workouts/today")
	public List<WorkoutDTO> getTodayWorkout() {
		return workoutService.getByTodayDate();
	}
	
	@DeleteMapping("/workouts/{id}")
	public String deleteWorkout(@PathVariable int id) {
		workoutService.deleteWorkout(id);
		return "Delete SuccessFul";
	}
	

}
