package com.teamdev.brainfuck;


public class OptimizedCommand implements Command {
    private Command repeatCommand;
    private int counts;

    public OptimizedCommand(Command repeatCommand, int counts) {
        this.repeatCommand = repeatCommand;
        this.counts = counts;
    }

    public int getCounts() {
        return counts;
    }

    public Command getOptimizedCommand() {
        return repeatCommand;
    }

    public void accept(CommandVisitor visitor) {
        visitor.visit(this);
    }
}
