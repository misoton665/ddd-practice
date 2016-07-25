package com.example.io


import java.io.File
import java.nio.file.{Files, Paths}

import com.example.model.DirectoryModel.DirectoryName

object DirectoryGenerator {
  val currentDirectoryName = DirectoryName(new File(".").getAbsoluteFile.getParent)

  def generateDirectory(directoryName: DirectoryName, baseDirectory: DirectoryName = currentDirectoryName): Unit = {
    val fullDirectoryName = currentDirectoryName.value + "/" + directoryName.value
    val directoryPath = Paths.get(fullDirectoryName)

    Files.createDirectory(directoryPath, null)
  }
}
