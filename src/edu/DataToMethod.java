package edu;

import edu.methods.Method;

@FunctionalInterface
public interface DataToMethod {
    Method solve(InputData data);
}
