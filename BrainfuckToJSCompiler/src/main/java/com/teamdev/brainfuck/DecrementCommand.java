package com.teamdev.brainfuck;


public class DecrementCommand implements Command {
    public void accept(CommandVisitor visitor) {
        visitor.visit(this);
    }
}
