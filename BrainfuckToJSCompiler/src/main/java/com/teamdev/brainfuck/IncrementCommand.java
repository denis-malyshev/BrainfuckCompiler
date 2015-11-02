package com.teamdev.brainfuck;


public class IncrementCommand implements Command {

    public void accept(CommandVisitor visitor) {
        visitor.visit(this);
    }
}
