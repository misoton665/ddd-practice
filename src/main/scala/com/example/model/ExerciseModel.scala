package com.example.model

import com.example.model.AssignmentModel.AssignmentList
import com.example.model.DirectoryModel.Directory

object ExerciseModel {
  case class ExerciseDirectory(value: Directory) extends Identifier[Directory]

  case class Exercise(identifier: ExerciseDirectory, assignmentList: AssignmentList) extends Entity[ExerciseDirectory] {
    val exerciseDirectoryName = identifier.value.identifier
  }

  case class ExerciseList(exercises: List[Exercise])
}
