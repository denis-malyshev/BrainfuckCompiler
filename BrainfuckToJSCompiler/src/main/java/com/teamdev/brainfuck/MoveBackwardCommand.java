package com.teamdev.brainfuck;


public class MoveBackwardCommand implements Command {

    @Override
    public void accept(CommandVisitor visitor) {
        visitor.visit(this);
    }
}
