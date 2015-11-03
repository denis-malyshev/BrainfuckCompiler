package com.teamdev.brainfuck;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class JavaScriptCompiler {

    public static final String PROGRAM = "++++++++[>++++[>++>+++>+++>+<<<<-]" +
            ">+>+>->>+[<]<-]>>.>---.+++++++..+++.>>.<-.<.+++.------.--------" +
            ".>>+.>++.";

    public void compile(String brainfuckProgram, File outputJavaScriptFile) {

        final List<Command> commands = new Parser().parse(brainfuckProgram);

        final OptimizationVisitor optimizationVisitor = new OptimizationVisitor();

        for (Command command : commands) {
            command.accept(optimizationVisitor);
        }

        final List<OptimizedCommand> optimizedCommands =
                optimizationVisitor.getOptimizedCommands();

        // Just for fun!
        final ExecutionVisitor executionVisitor = new ExecutionVisitor();
        for (OptimizedCommand command : optimizedCommands) {
            for (int i = 0; i < command.getCounts(); i++)
                command.getOptimizedCommand().accept(executionVisitor);
        }

        // todo: generate JavaScript code (implement JavaScript code generation visitor)
        final JSCodeGenerationVisitor jsCodeGenerationVisitor = new JSCodeGenerationVisitor();
        for (OptimizedCommand command : optimizedCommands) {
            command.getOptimizedCommand().accept(jsCodeGenerationVisitor);
        }
        try {
            FileWriter fileWriter = new FileWriter(outputJavaScriptFile);
            fileWriter.write(jsCodeGenerationVisitor.getJsCode());
            fileWriter.close();
            fileWriter = new FileWriter("run.html");
            fileWriter.write("<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <title></title>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "<script src=\"brainfuck.js\">\n" +
                    "</script>\n" +
                    "</body>\n" +
                    "</html>");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        final JavaScriptCompiler compiler = new JavaScriptCompiler();
        compiler.compile(PROGRAM, new File("./brainfuck.js"));
    }

}
