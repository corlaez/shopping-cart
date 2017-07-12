package com.cesarmando.website.viewmodel;

import com.cesarmando.website.service.ConsService;
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
    /** Json data sent to be evaluated by the client*/
    private String data;
    /** A flag sent to be evaluated by the client*/
    private String flag;//no recuerdo pa que es esto.
    /** If present the Ajax response should redirect*/
    private String redirect;

    public String getRedirect() {
        return ConsService.getRedirect() + redirect;
    }

    public MyAjaxResponse(String data){
        this.data = data;
    }

    public static MyAjaxResponse errorMsg(String e){
        return new MyAjaxResponse().setErrorMsg(e);
    }

    public static MyAjaxResponse successMsg(String s){
        return new MyAjaxResponse().setSuccessMsg(s);
    }

    public static MyAjaxResponse infoMsg(String i){
        return new MyAjaxResponse().setInfoMsg(i);
    }

    public static MyAjaxResponse confirmMsg(String c){
        return new MyAjaxResponse().setConfirmMsg(c);
    }

    public static MyAjaxResponse data(String data){
        return new MyAjaxResponse(data);
    }

    @Override
    public String toString() {
        return "MyAjaxResponse{" +
                "errorMsg='" + errorMsg + '\'' +
                ", infoMsg='" + infoMsg + '\'' +
                ", successMsg='" + successMsg + '\'' +
                ", confirmMsg='" + confirmMsg + '\'' +
                ", data='" + data + '\'' +
                '}';
    }

}