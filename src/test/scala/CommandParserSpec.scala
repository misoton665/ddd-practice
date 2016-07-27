import com.example.application.{CommandParser, Commands}
import com.example.application.Commands.{CommandName, InitCommand}
import org.scalatest._

class CommandParserSpec extends FlatSpec with Matchers{
  "Command line args \"-key value\"" should "be parse to key => value" in {
    val args = Array("-key", "value")
    val commandArgsList = CommandParser.parseCommandArgs(args)

    commandArgsList.value("-key") should be("value")
  }

  "Command line args \"-key1 value1 -key2 value2\"" should "be parse to -key1 => value1 and -key2 => value2" in {
    val args = Array("-key1", "value1", "-key2", "value2")
    val commandArgsList = CommandParser.parseCommandArgs(args)

    commandArgsList.value("-key1") should be("value1")
    commandArgsList.value("-key2") should be("value2")
  }

  "Command name init" should "be parse to InitCommand" in {
    val initName = CommandName("init")
    val command = CommandParser.parseByCommandName(initName, Commands.emptyArgList)
    command should be(CommandParser.CommandParseSuccess(InitCommand()))
  }
}
