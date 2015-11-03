package com.teamdev.brainfuck;


public class DecrementCommand implements Command {

    @Override
    public void accept(CommandVisitor visitor) {
        visitor.visit(this);
    }
}
