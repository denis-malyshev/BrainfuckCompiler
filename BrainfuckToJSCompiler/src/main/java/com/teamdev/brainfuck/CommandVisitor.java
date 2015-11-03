package com.teamdev.brainfuck;

public interface CommandVisitor {

    void visit(MoveForwardCommand command);

    void visit(MoveBackwardCommand command);

    void visit(IncrementCommand command);

    void visit(DecrementCommand command);

    void visit(PrintCommand command);

    void visit(LoopCommand command);
}
