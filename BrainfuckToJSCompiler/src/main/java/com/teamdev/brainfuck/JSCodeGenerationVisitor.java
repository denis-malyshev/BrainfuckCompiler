package com.teamdev.brainfuck;

public class JSCodeGenerationVisitor implements CommandVisitor {

    private String jsCode;

    public JSCodeGenerationVisitor() {
        this.jsCode = "var memory=new Array(30000);\nvar pointer=0;\n" +
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
}
