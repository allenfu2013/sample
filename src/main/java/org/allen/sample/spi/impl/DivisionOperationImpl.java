package org.allen.sample.spi.impl;

import org.allen.sample.spi.IOperation;

public class DivisionOperationImpl implements IOperation {
    @Override
    public int operation(int numberA, int numberB) {
        return numberA / numberB;
    }
}
