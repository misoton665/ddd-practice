package com.example.model

object FileModel {
  case class FileName(value: String) extends Identifier[String]

  case class File(identifier: FileName) extends Entity[FileName]
}
