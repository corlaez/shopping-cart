package com.cesarmando.website.forms;

import com.cesarmando.website.dao.model.ProductE;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by jarma on 7/15/2017.
 */
public class Cart {
    @Getter @Setter
    private String items;
    @Getter @Setter
    private List<ProductE> itemList;

    private Gson gson = new Gson();
    private Type typeOfItemList = new TypeToken<List<ProductE>>(){}.getType();

    private List<ProductE> getItemList(){
        if(itemList == null){
            itemList = gson.fromJson(items, typeOfItemList);
        }
        return itemList;
    }

    @Override
    public String toString() {
        return items;
    }
}