package com.teamdev.brainfuck;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class JavaScriptCompiler {

    public static final String PROGRAM ="++++++++[>++++[>++>+++>+++>+<<<<-]" +
            ">+>+>->>+[<]<-]>>.>---.+++++++..+++.>>.<-.<.+++.------.--------" +
            ".>>+.>++.";

    public void compile(String brainfuckProgram, File outputJavaScriptFile) {

        final List<Command> commands = new Parser().parse(brainfuckProgram);

        final OptimizationVisitor optimizationVisitor = new OptimizationVisitor();

        for (Command command : commands) {
            command.accept(optimizationVisitor);
        }

        final List<Command> optimizedCommands =
                optimizationVisitor.getOptimizedCommands();

        final ExecutionVisitor executionVisitor = new ExecutionVisitor();
        for (Command command : optimizedCommands) {
            command.accept(executionVisitor);
        }

        final JSCodeGenerationVisitor jsCodeGenerationVisitor = new JSCodeGenerationVisitor();
        for (Command command : optimizedCommands) {
            command.accept(jsCodeGenerationVisitor);
        }

        final JSCode jsCode=new JSCode();
        jsCode.declareFunction("callMessage");
        jsCode.setBodyFunctions(jsCodeGenerationVisitor.getJsCode());
        jsCode.endFunction();

        try {
            FileWriter fileWriter = new FileWriter(outputJavaScriptFile);
            fileWriter.write(jsCode.getWorkArea().toString());
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
