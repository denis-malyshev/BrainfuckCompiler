package com.teamdev.brainfuck;


public class DecrementCommand implements Command {

    private int repeatCounts=1;

    public void accept(CommandVisitor visitor) {
        visitor.visit(this);
    }

    public void addRepeat() {
        repeatCounts++;
    }

    public int getRepeatCounts() {
        return repeatCounts;
    }
}
