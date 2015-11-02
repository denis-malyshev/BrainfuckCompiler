package com.teamdev.brainfuck;


public class MoveBackwardCommand implements Command {

    public void accept(CommandVisitor visitor) {
        visitor.visit(this);
    }
}
