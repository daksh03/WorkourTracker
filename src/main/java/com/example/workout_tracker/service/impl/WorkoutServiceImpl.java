package com.example.workout_tracker.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.workout_tracker.dto.WorkoutDTO;
import com.example.workout_tracker.entity.Workout;
import com.example.workout_tracker.repository.WorkoutRepository;
import com.example.workout_tracker.service.WorkoutService;

@Service
public class WorkoutServiceImpl implements WorkoutService {

	@Autowired
	private WorkoutRepository repo;

	@Override
	public String addWorkout(WorkoutDTO workoutDTO) {
		Workout entity = new Workout();
		entity.setDate(workoutDTO.getDate());
		entity.setExercise(workoutDTO.getExercise());
		entity.setMuscleGroup(workoutDTO.getMuscleGroup());
		entity.setReps(workoutDTO.getReps());
		entity.setSets(workoutDTO.getSets());
		repo.save(entity);
		return "Done";
	}

	@Override
	public List<WorkoutDTO> getAllWorkouts() {

		return repo.findAll().stream().map(workout -> {
			WorkoutDTO dto = new WorkoutDTO();
			dto.setExercise(workout.getExercise());
			dto.setMuscleGroup(workout.getMuscleGroup());
			dto.setDate(workout.getDate());
			dto.setReps(workout.getReps());
			dto.setSets(workout.getSets());
			return dto;
		}).collect(Collectors.toList());
	}

	@Override
	public List<WorkoutDTO> getByMuscleGroup(String muscleGroup) {
		List<Workout> workouts = repo.findByMuscleGroup(muscleGroup);

		return workouts.stream().map(w -> {
			WorkoutDTO dto = new WorkoutDTO();
			dto.setDate(w.getDate());
			dto.setExercise(w.getExercise());
			dto.setSets(w.getSets());
			dto.setReps(w.getReps());
			dto.setMuscleGroup(w.getMuscleGroup());
			return dto;
		}).toList();

	}

	@Override
	public List<WorkoutDTO> getByTodayDate() {
		List<Workout> workout = repo.findByDate(LocalDate.now());
		return workout.stream().map(w -> {
			WorkoutDTO dto = new WorkoutDTO();
			dto.setDate(w.getDate());
			dto.setExercise(w.getExercise());
			dto.setSets(w.getSets());
			dto.setReps(w.getReps());
			dto.setMuscleGroup(w.getMuscleGroup());
			return dto;
		}).toList();
	}

	@Override
	public String deleteWorkout(int id) {
		if (repo.findById(id) != null) {
			repo.deleteById(id);
			return "Delete Success";
		} else {
			return "No files found";

		}

	}

}
