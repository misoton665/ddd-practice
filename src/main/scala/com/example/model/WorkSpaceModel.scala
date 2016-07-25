package com.example.model

import com.example.model.ExerciseModel.ExerciseList

object WorkSpaceModel {
  case class WorkSpace(identifier: WorkSpaceName, exerciseList: ExerciseList) extends Entity[WorkSpaceName]

  case class WorkSpaceName(value: String) extends Identifier[String]
}
