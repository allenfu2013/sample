package org.allen.sample.algorithm;

public class LinkDemo {

    private Node head;

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    static class Node {
        private Object data;
        private Node next;

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    public static void main(String[] args) {
        Node head = new Node();

        Node five = new Node();
        five.setData(5);
        five.setNext(head);

        Node four = new Node();
        four.setData(4);
        four.setNext(five);

        Node three = new Node();
        three.setData(3);
        three.setNext(four);

        Node second = new Node();
        second.setData(2);
        second.setNext(three);

        head.setData(1);
        head.setNext(second);

        LinkDemo linkDemo = new LinkDemo();
        linkDemo.setHead(head);

        Node m = linkDemo.getHead().getNext();
        Node n = m.getNext();

        do {
            if (m.getData().equals(n.data)) {
                System.out.println("yes");
                return;
            } else {
                m = m.getNext();
                n = n.getNext().getNext();
            }
        } while (m != null && n != null);
        System.out.println("no");

    }
}
