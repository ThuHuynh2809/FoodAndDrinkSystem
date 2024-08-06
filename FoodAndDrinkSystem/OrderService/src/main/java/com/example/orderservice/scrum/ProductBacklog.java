/*
 * @ (#) ProductBacklog.java     1.0     5/26/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved
 */
package com.example.orderservice.scrum;

import java.util.ArrayList;
import java.util.List;

/*
 * @description:
 * @author: Huynh Minh Thu
 * @date: 3:39 AM 5/26/2024
 * @version: 1.0
 */
public class ProductBacklog {

    private List<String> items = new ArrayList<>();

    public void addItem(String item) {
        items.add(item);
    }

    public List<String> getItems() {
        return items;
    }
}
