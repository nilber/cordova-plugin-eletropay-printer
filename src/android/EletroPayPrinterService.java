package com.eletropay.printer;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;
import android.content.Context;
import android.widget.Toast;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;

public class EletroPayPrinterService extends CordovaPlugin {

    EletroPayPrinter eletroPayPrinter;
    Handler handler;

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {

        if ("start".equals(action)) {
            startPrinter(callbackContext);
            return true;
        }

        if ("add_command".equals(action)) {

            switch (args.getInt(2)){
                case 0:
                    eletroPayPrinter.AddCommand(new PrinterCommand(args.getString(0), args.getInt(1),0,args.getInt(3)));
                    break;
            }
            callbackContext.success("start");
            return true;
        }


        if ("printer".equals(action)) {
            printer(callbackContext);
            return true;
        }

        if ("show".equals(action)) {
            show(args.getString(0), callbackContext);
            return true;
        }

        return false;
    }

    private void startPrinter(CallbackContext callbackContext){

        eletroPayPrinter = new EletroPayPrinter(webView.getContext());
        eletroPayPrinter.init();

        callbackContext.success("start");
    }


    private void printer(CallbackContext callbackContext) {
        handler = new Handler();
        handler.postDelayed(() -> {

            if (eletroPayPrinter.getPrinterStatus() == eletroPayPrinter.PRINTER_NORMAL) {

                eletroPayPrinter.printer();
                callbackContext.success("printer");
            } else {
                printer(callbackContext);
            }
        }, 1000);
    }

    private void show(String msg, CallbackContext callbackContext) {

        if (msg == null || msg.length() == 0) {
            callbackContext.error("Empty message!");
        } else {
            Toast.makeText(webView.getContext(), msg, Toast.LENGTH_LONG).show();
            callbackContext.success(msg);
        }
    }
}