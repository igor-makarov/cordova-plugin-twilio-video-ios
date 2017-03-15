package org.apache.cordova.plugin;

import org.apache.cordova.BuildHelper;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaResourceApi;
import org.apache.cordova.LOG;
import org.apache.cordova.PermissionHelper;
import org.apache.cordova.PluginResult;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

import android.app.Activity;
import android.content.Intent;

import org.apache.cordova.plugin.TwilioVideoActivity;


public class TwilioVideo extends CordovaPlugin {


    public CallbackContext callbackContext;
    private CordovaInterface cordova;

    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
        this.cordova = cordova;
        // your init code here
    }

    
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		this.callbackContext = callbackContext;
		
		if (action.equals("openRoom")) {
		   	this.openRoom(args);
		    return true;
		}

	}

	public void openRoom(final JSONArray args) {

	 	String token = args.getString(0);
        String roomId = args.getString(1);


        final CordovaPlugin that = this;
 			cordova.getThreadPool().execute(new Runnable() {
            public void run() {

                Intent intentTwilioVideo = new Intent(that.cordova.getActivity().getBaseContext(), TwilioVideoActivity.class);
    			intentTwilioVideo.putExtra("token", token);
                intentTwilioVideo.putExtra("roomId", roomId);
                // avoid calling other phonegap apps
                intentTwilioVideo.setPackage(that.cordova.getActivity().getApplicationContext().getPackageName());
                that.cordova.startActivityForResult(that, intentTwilioVideo);
            }
        });
    }



}