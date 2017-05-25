package org.allen.utility.spi.impl;

import org.allen.utility.spi.IOperation;

public class DivisionOperationImpl implements IOperation {
    @Override
    public int operation(int numberA, int numberB) {
        return numberA / numberB;
    }
}
