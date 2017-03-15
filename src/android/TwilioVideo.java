

import org.apache.cordova.BuildHelper;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaResourceApi;
import org.apache.cordova.LOG;
import org.apache.cordova.PermissionHelper;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;

public class TwilioVideo extends CordovaPlugin {


 
 	public CallbackContext callbackContext;
    
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		 this.callbackContext = callbackContext;
       
	}

}