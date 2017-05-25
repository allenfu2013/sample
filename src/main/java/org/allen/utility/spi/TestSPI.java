package org.allen.utility.spi;

import org.allen.utility.spi.impl.PlusOperationImpl;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * Created by allen on 17/5/14.
 */
public class TestSPI {

    public static void main(String[] args) {
        IOperation plus = new PlusOperationImpl();
        System.out.println(plus.operation(5, 3));

        ServiceLoader<IOperation> operations = ServiceLoader.load(IOperation.class);
        Iterator<IOperation> operationIterator = operations.iterator();
        while (operationIterator.hasNext()) {
            System.out.println("#####");
            IOperation operation = operationIterator.next();
            System.out.println(operation.operation(6, 3));
        }
    }
}
