package com.example.application

import com.example.io.DirectoryGenerator
import com.example.model.ExerciseModel.{Exercise, ExerciseList}
import com.example.model.WorkSpaceCheckService._
import com.example.model.WorkSpaceModel.WorkSpace

object WorkSpaceContentGenerator {
  def generateExercise(exercise: Exercise): Unit = {
    val exerciseName = exercise.exerciseDirectoryName

    DirectoryGenerator.generateDirectory(exerciseName)
  }

  def generateUncreatedExercises(workSpace: WorkSpace, allExerciseList: ExerciseList): Unit = {
    val uncreatedExerciseList = findUncreatedExercises(workSpace, allExerciseList)

    for(exercise <- uncreatedExerciseList) {
      generateExercise(exercise)
    }
  }
}
