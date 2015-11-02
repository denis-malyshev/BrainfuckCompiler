package com.teamdev.brainfuck;


public class PrintCommand implements Command {

    public void accept(CommandVisitor visitor) {
        visitor.visit(this);
    }
}
