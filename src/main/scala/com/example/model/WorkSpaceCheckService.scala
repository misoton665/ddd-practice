package com.example.model

import com.example.model.AssignmentModel.AssignmentList
import com.example.model.ExerciseModel.{Exercise, ExerciseList}
import com.example.model.WorkSpaceModel.WorkSpace

object WorkSpaceCheckService {
  def findCreatedExercises(currentWordSpace: WorkSpace, allExerciseList: ExerciseList): ExerciseList = {
    ExerciseList(allExerciseList.exercises.intersect(currentWordSpace.exerciseList.exercises))
  }

  def findUncreatedExercises(currentWorkSpace: WorkSpace, allExerciseList: ExerciseList): ExerciseList = {
    ExerciseList(allExerciseList.exercises.diff(currentWorkSpace.exerciseList.exercises))
  }

  def findUncreatedAssignments(currentExercise: Exercise, allAssignmentList: AssignmentList): AssignmentList = {
    AssignmentList(allAssignmentList.assignments.diff(currentExercise.assignmentList.assignments))
  }
}
