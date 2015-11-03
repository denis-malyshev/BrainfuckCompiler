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

    @Override
    public void visit(MoveForwardCommand command) {

    }

    @Override
    public void visit(MoveBackwardCommand command) {

    }

    @Override
    public void visit(IncrementCommand command) {

    }

    @Override
    public void visit(DecrementCommand command) {

    }

    @Override
    public void visit(PrintCommand command) {

    }

    @Override
    public void visit(LoopCommand command) {

    }
}
