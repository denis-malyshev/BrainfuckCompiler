package com.teamdev.brainfuck;

public class JSCodeGenerationVisitor implements CommandVisitor {

    private String jsCode;
    private String upValue = "\nmemory[pointer]+=";
    private String downValue = "\nmemory[pointer]-=";
    private String moveForward = "\npointer+=";
    private String moveBackward = "\npointer-=";
    private String openLoop = "\nwhile(memory[pointer]!=0) {";
    private String endLoop = "\n}";
    private String endLine = ";";
    private String result = "\nresult+=String.fromCharCode(memory[pointer]);";

    public JSCodeGenerationVisitor() {
        this.jsCode = "var memory = Array.apply(null, new Array(30000)).map(function () {return 0;});\n" +
                "var pointer=0;\n" +
                "var result='';";
    }

    public String getJsCode() {
        return jsCode;
    }

    public void visit(MoveForwardCommand command) {
        jsCode += moveForward + command.getRepeatCounts() + endLine;
    }

    public void visit(MoveBackwardCommand command) {
        jsCode += moveBackward + command.getRepeatCounts() + endLine;
    }

    public void visit(IncrementCommand command) {
        jsCode += upValue + command.getRepeatCounts() + endLine;
    }

    public void visit(DecrementCommand command) {
        jsCode += downValue + command.getRepeatCounts() + endLine;
    }

    public void visit(PrintCommand command) {
        for (int i = 0; i < command.getRepeatCounts(); i++)
            jsCode += result;
    }

    public void visit(LoopCommand command) {
        jsCode += openLoop;
        for (Command innerCommand : command.getInnerCommands()) {
            innerCommand.accept(this);
        }
        jsCode += endLoop;
    }
}
