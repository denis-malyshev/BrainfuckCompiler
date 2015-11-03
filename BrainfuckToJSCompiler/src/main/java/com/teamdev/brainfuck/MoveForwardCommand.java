package com.teamdev.brainfuck;


public class MoveForwardCommand implements Command {

    @Override
    public void accept(CommandVisitor visitor) {
        visitor.visit(this);
    }

}
