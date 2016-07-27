package com.example.application

import com.example.application.Commands._

object CommandParser {

  trait CommandParseResult {
    val parseIsSuccess: Boolean
    val parsedCommand: Command
  }

  case class CommandParseSuccess(parsedCommand: Command) extends CommandParseResult {
    require(parsedCommand != UndefinedCommand)

    val parseIsSuccess: Boolean = true
  }

  case object CommandParseFailure extends CommandParseResult {
    val parsedCommand: Command = UndefinedCommand
    val parseIsSuccess: Boolean = false
  }

  def parseCommandArgs(origin: Array[String]): CommandArgList = {
    def parseHead(args: Array[String]): ((String, String), Array[String]) = {
      if (args.length < 2) {
        return (("", ""), args)
      }

      val key = args(0)
      val value = args(1)

      ((key, value), args.drop(2))
    }

    def parse(args: Array[String], commandArgList: CommandArgList): CommandArgList = {
      parseHead(args) match {
        case (("", ""), a) => commandArgList
        case ((k ,  v), a) => parse(a, CommandArgList(commandArgList.value.updated(k, v)))
      }
    }

    parse(origin, Commands.emptyArgList)
  }

  def parseByCommandName(commandName: CommandName, commandArgList: CommandArgList): CommandParseResult = {
    commandName match {
      case CommandName("init") => CommandParseSuccess(InitCommand())
      case CommandName("create") => CommandParseSuccess(CreateCommand(commandArgList))
      case CommandName("check") => CommandParseSuccess(CheckCommand(commandArgList))
      case _ => CommandParseFailure
    }
  }
}
