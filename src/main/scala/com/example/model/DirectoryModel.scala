package com.example.model

object DirectoryModel {
  case class DirectoryName(value: String) extends Identifier[String]

  case class Directory(identifier: DirectoryName) extends Entity[DirectoryName]
}
