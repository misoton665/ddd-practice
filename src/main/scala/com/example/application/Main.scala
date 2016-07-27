package com.example.application

import com.example.application.Commands.{CommandName, UndefinedCommand}

object Main {
  def main(args: Array[String]): Unit = {
    if(args.length < 1) {
      UndefinedCommand.run()
      return
    }

    val commandName = CommandName(args(0))
    val commandArgs = CommandParser.parseCommandArgs(args.drop(2))
    val parsedResult = CommandParser.parseByCommandName(commandName, commandArgs)
    val command = parsedResult.parsedCommand

    if (!parsedResult.parseIsSuccess) {
      printErrorMessage()
      return
    }

    command.run()
  }

  def printErrorMessage(): Unit = {
    println("error!")
  }
}
