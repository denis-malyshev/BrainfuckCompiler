package com.teamdev.brainfuck;

public interface Command {
    void accept(CommandVisitor visitor);
}
