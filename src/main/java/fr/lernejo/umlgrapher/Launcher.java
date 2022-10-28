package fr.lernejo.umlgrapher;

import picocli.CommandLine;
import picocli.CommandLine.Option;


public class Launcher implements Runnable{

    @Option(names = {"-c", "--classes"}, description = "Fill in the classes from which to base the analysis")
    private final Class<?>[] classes = null;
    @Option(names = {"-g", "--graph-type"}, description = "Select the type of graph you want to output")
    private final GraphType grType= GraphType.Mermaid;

    @Override
    public void run() {

        UmlGraph graph = new UmlGraph(classes);
        String st = graph.as(grType);
        System.out.println(st);
    }
    // this example implements Callable, so parsing, error handling and handling user
    // requests for usage help or version help can be done with one line of code.
    public static void main(String... args) {
        int exitCode = new CommandLine(new Launcher()).execute(args);
        System.exit(exitCode);
    }
}
