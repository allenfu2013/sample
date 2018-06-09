package org.allen.sample.designpattern.decorator;

public class ConcreteComponent extends Component {

    @Override
    public void operate() {
        System.out.println("do Something");
    }
}
