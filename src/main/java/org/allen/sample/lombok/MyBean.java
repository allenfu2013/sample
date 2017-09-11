package org.allen.sample.lombok;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyBean {

    private Long id;

    private String name;

    private Date createdAt;

    public static void main(String[] args) {
        MyBean myBean = new MyBean();
        myBean.setId(1L);
        myBean.setName("abc");
        myBean.setCreatedAt(new Date());
        System.out.println(myBean);

        MyBean myBean1 = new MyBean(2l, "def", new Date());
        System.out.println(myBean1);
    }
}
