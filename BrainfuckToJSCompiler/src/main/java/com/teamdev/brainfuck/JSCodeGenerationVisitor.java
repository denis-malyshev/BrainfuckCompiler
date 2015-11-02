package com.teamdev.brainfuck;

public class JSCodeGenerationVisitor implements CommandVisitor {

    private String jsCode;

    public JSCodeGenerationVisitor() {
        this.jsCode = "var memory=new Array(30000);\nvar pointer=0;\nvar message='';\n" +
                "for (var i=0;i<memory.length;i++) {\n\tmemory[i]=0;\n}";
    }

    public String getJsCode() {
        return jsCode;
    }

    public void visit(MoveForwardCommand command) {

    }

    public void visit(MoveBackwardCommand command) {

    }

    public void visit(IncrementCommand command) {

    }

    public void visit(DecrementCommand command) {

    }

    public void visit(PrintCommand command) {

    }

    public void visit(LoopCommand command) {

    }

    public void visit(OptimizedCommand command) {
        if (command.getOptimizedCommand().getClass() == IncrementCommand.class) {
            jsCode += "\nmemory[pointer]+=" + command.getCounts() + ";";
            return;
        }
        if (command.getOptimizedCommand().getClass() == DecrementCommand.class) {
            jsCode += "\nmemory[pointer]-=" + command.getCounts() + ";";
            return;
        }
        if (command.getOptimizedCommand().getClass() == MoveForwardCommand.class) {
            jsCode += "\npointer+=" + command.getCounts() + ";";
            return;
        }
        if (command.getOptimizedCommand().getClass() == MoveBackwardCommand.class) {
            jsCode += "\npointer-=" + command.getCounts() + ";";
            return;
        }
        if (command.getOptimizedCommand().getClass() == PrintCommand.class) {
            for (int i = 0; i < command.getCounts(); i++) {
                jsCode += "\nmessage+=String.fromCharCode(memory[pointer]);\nalert(message);";
            }
            return;
        }
        if (command.getOptimizedCommand().getClass() == LoopCommand.class) {
            jsCode += "\nwhile(memory[pointer]!=0) {";
            return;
        }
    }
}
