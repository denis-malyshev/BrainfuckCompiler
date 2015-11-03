package com.teamdev.brainfuck;


public class PrintCommand implements Command {

    @Override
    public void accept(CommandVisitor visitor) {
        visitor.visit(this);
    }
}
