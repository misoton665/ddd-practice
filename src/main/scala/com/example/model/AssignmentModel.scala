package com.example.model

import com.example.model.FileModel.File

object AssignmentModel {
  case class AssignmentName(value: File) extends Identifier[File]

  case class Assignment(identifier: AssignmentName) extends Entity[AssignmentName]

  case class AssignmentList(assignments: List[Assignment])
}
