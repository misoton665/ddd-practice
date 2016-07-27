package com.example.application

import com.example.model.{Entity, Identifier}

object Commands {
  case class CommandName(value: String) extends Identifier[String]
  case class CommandArgList(value: Map[String, String]) extends Identifier[Map[String, String]]

  val emptyArgList = CommandArgList(Map.empty)

  sealed trait Command extends Entity[CommandName]{
    val identifier: CommandName
    protected val commandArgList: CommandArgList
    def run(): Unit
  }

  case class InitCommand(commandArgList: CommandArgList = emptyArgList) extends Command {
    val identifier: CommandName = CommandName("init")

    def run(): Unit = {
      println("init")
    }
  }

  case class CreateCommand(commandArgList: CommandArgList = emptyArgList) extends Command {
    val identifier: CommandName = CommandName("create")

    def run(): Unit = {
      println("create")
    }
  }

  case class CheckCommand(commandArgList: CommandArgList = emptyArgList) extends Command {
    val identifier: CommandName = CommandName("check")

    def run(): Unit = {
      println("check")
    }
  }

  case object UndefinedCommand extends Command {
    val identifier: CommandName = CommandName("undefined")
    val commandArgList: CommandArgList = emptyArgList
    def run(): Unit = {
      println("That command is not found.")
    }
  }
}
