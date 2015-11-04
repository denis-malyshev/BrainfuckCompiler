package com.teamdev.brainfuck;


public class JSCode {
    private StringBuilder workArea;
    private String functionName;

    public JSCode() {
        this.workArea = new StringBuilder("");
    }

    public void declareFunction(String functionName) {
        this.functionName=functionName;
        workArea.append("function "+functionName+"() {\n");
    }

    public void endFunction() {
        workArea.append("\nreturn alert(result);}\n"+functionName+"();");
    }

    public void setBodyFunctions(String bodyFunctions) {
        workArea.append(bodyFunctions);
    }

    public StringBuilder getWorkArea() {
        return workArea;
    }
}
