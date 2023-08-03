import org.apache.commons.cli.*;

import java.io.PrintWriter;

public class CliMain {

  public static final Option ADD_NUMBERS = new Option("a",
    "add",
    false,
    "adds two numbers together");

  public static final Option SUBTRACT_NUMBERS = new Option("s",
    "subtract",
    false,
    "subtracts two numbers");

  public static final Option MULTIPLY_NUMBERS = new Option("m",
    "multiply",
    false,
    "multiply two numbers");

  public static final Option DIVIDE_NUMBERS = new Option("d",
    "divide",
    false,
    "divide two numbers");

  public static void main(String[] args)  {

    String[] numPositions = {"a", "b"};

    int[] numbers = {5, 7};


    CommandLineParser cliParser = new DefaultParser();

    Options optionsList = new Options();
    optionsList.addOption(ADD_NUMBERS);
    optionsList.addOption(SUBTRACT_NUMBERS);
    optionsList.addOption(MULTIPLY_NUMBERS);
    optionsList.addOption(DIVIDE_NUMBERS);

    int a = 0;
    int b = 0;
    try {
      CommandLine command = cliParser.parse(optionsList, args);
      a = Integer.parseInt(cliParser.get)

      if (command.hasOption(ADD_NUMBERS.getLongOpt())) {
        System.out.println(a + " + " + b + " = " + (a + b));
      }
      else if (command.hasOption(SUBTRACT_NUMBERS.getLongOpt())) {
        System.out.println(a + " - " + b + " = " + (a + b));
      }
      else if (command.hasOption(MULTIPLY_NUMBERS.getLongOpt())) {
        System.out.println(a + " * " + b + " = " + (a + b));
      }
      else if (command.hasOption(DIVIDE_NUMBERS.getLongOpt())) {
        System.out.println(a + " / " + b + " = " + (a + b));
      }
      else {
        printHelp(optionsList);
      }

    } catch (ParseException e) {
      e.printStackTrace();
    }

  }
  private static void printHelp(Options options) {

    HelpFormatter helpFormatter = new HelpFormatter();
    PrintWriter printWriter = new PrintWriter(System.out);

    printWriter.println("MathApp");
    printWriter.println();

    helpFormatter.printUsage(printWriter, 100, "java -jar MathApp.jar [options] number1 number2");
    helpFormatter.printOptions(printWriter, 100, options, 2, 5);

    printWriter.close();
  }
}
