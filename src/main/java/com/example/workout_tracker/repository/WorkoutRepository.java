package com.example.workout_tracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.workout_tracker.entity.Workout;

@Repository
public interface WorkoutRepository extends JpaRepository<Workout, Integer> {

	List<Workout> findByMuscleGroup(String muscleGroup);

}
