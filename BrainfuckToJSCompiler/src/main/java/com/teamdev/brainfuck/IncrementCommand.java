package com.teamdev.brainfuck;


public class IncrementCommand implements Command {

    @Override
    public void accept(CommandVisitor visitor) {
        visitor.visit(this);
    }
}
