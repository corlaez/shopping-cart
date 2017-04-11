package com.cesarmando.website.viewmodel;

import lombok.Getter;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * Un json de esta clase será siempre enviado al browser por ajax.
 *
 * Created by jarma on 4/11/2017.
 */
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
public class MyAjaxResponse {
    /** Message to display in an error popup*/
    private String errorMsg;
    /** Message to display in an info popup*/
    private String infoMsg;
    /** Message to display in a succcess popup*/
    private String successMsg;
    /** Message to display in an confirm (Yes/No) popup*/
    private String confirmMsg;
    /** Data sent to be evaluated by the client*/
    private String data;

    public MyAjaxResponse(String data){
        this.data = data;
    }

    public static MyAjaxResponse errorMsg(String e){
        return new MyAjaxResponse().setErrorMsg(e);
    }

    public static MyAjaxResponse successMsg(String s){
        return new MyAjaxResponse().setErrorMsg(s);
    }

    public static MyAjaxResponse infoMsg(String i){
        return new MyAjaxResponse().setErrorMsg(i);
    }

    public static MyAjaxResponse confirmMsg(String c){
        return new MyAjaxResponse().setErrorMsg(c);
    }

    public static MyAjaxResponse data(String data){
        return new MyAjaxResponse().setErrorMsg(data);
    }

}