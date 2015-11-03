package com.teamdev.brainfuck;


public class OptimizedCommand {
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

}
