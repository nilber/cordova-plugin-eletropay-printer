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


public class AndroidToast extends CordovaPlugin {

    EletroPayPrinter eletroPayPrinter;
    Handler handler;

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if ("show".equals(action)) {
            show(args.getString(0), callbackContext);
            return true;
        }

        return false;
    }



    private void printer() {
        handler = new Handler();
        handler.postDelayed(() -> {

            if (eletroPayPrinter.getPrinterStatus() == eletroPayPrinter.PRINTER_NORMAL) {

                eletroPayPrinter.printQRCode("msg de teste aqui");
            } else {
                printer();
            }
        }, 1000);
    }

    private void show(String msg, CallbackContext callbackContext) {

        eletroPayPrinter = new EletroPayPrinter(webView.getContext());
        eletroPayPrinter.init();

        printer();
        if (msg == null || msg.length() == 0) {
            callbackContext.error("Empty message!");
        } else {
            Toast.makeText(webView.getContext(), msg, Toast.LENGTH_LONG).show();
            callbackContext.success(msg);
        }
    }
}