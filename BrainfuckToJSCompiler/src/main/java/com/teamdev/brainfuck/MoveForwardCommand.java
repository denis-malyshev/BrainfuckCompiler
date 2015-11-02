package com.teamdev.brainfuck;


public class MoveForwardCommand implements Command {

    public void accept(CommandVisitor visitor) {
        visitor.visit(this);
    }

}
