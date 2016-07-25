package com.example.model

import com.example.model.ExerciseModel.ExerciseList

object WorkSpaceModel {
  case class WorkSpace(identifier: Identifier[String], exerciseList: ExerciseList) extends Entity[WorkSpaceId]

  case class WorkSpaceId(value: String) extends Identifier[String]
}
