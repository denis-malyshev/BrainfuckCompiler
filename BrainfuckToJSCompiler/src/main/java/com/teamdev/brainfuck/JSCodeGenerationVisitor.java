package com.teamdev.brainfuck;

public class JSCodeGenerationVisitor implements CommandVisitor {

    private String jsCode;
    private String upValue = "memory[pointer]+=";
    private String downValue = "memory[pointer]-=";
    private String moveForward = "pointer+=";
    private String moveBackward = "pointer-=";
    private String openLoop = "while(memory[pointer]!=0) {\n";
    private String endLoop = "}\n";
    private String endLine = ";\n";
    private String result = "result+=String.fromCharCode(memory[pointer]);\n";
    private int tabsCount = 1;

    public JSCodeGenerationVisitor() {
        this.jsCode = "var memory = Array.apply(null, new Array(30000)).map(function () {return 0;});\n" +
                "var pointer=0;\n" +
                "var result='';";
    }

    public String getJsCode() {
        return jsCode;
    }

    public void visit(MoveForwardCommand command) {
        setTab();
        jsCode +=moveForward + command.getRepeatCounts() + endLine;
    }

    public void visit(MoveBackwardCommand command) {
        setTab();
        jsCode +=moveBackward + command.getRepeatCounts() + endLine;
    }

    public void visit(IncrementCommand command) {
        setTab();
        jsCode +=upValue + command.getRepeatCounts() + endLine;
    }

    public void visit(DecrementCommand command) {
        setTab();
        jsCode +=downValue + command.getRepeatCounts() + endLine;
    }

    public void visit(PrintCommand command) {
        setTab();
        for (int i = 0; i < command.getRepeatCounts(); i++)
            jsCode +=result;
    }

    public void visit(LoopCommand command) {
        setTab();
        jsCode +=openLoop;
        tabsCount++;
        for (Command innerCommand : command.getInnerCommands()) {
            innerCommand.accept(this);
        }
        tabsCount--;
        setTab();
        jsCode +=endLoop;
    }

    private String setTab() {
        StringBuilder tab = new StringBuilder("");
        for (int i = 0; i < tabsCount; i++) {
            tab.append("\t");
        }
        return jsCode+=tab.toString();
    }
}
