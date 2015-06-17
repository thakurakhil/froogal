package co.froogal.froogal.library;


import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
import android.util.Log;

import co.froogal.froogal.util.basic_utils;


public class UserFunctions {

    private static final String TAG = "UserFunctions";
    private JSONParser jsonParser;


    //URL of the PHP API
    private static String loginURL = "http://froogal.in/files/login.php";
    private static String registerURL = "http://froogal.in/files/signup.php";
    private static String forpassURL = "http://froogal.in/files/forgotpass.php";
    private static String chgpassURL = "http://froogal.in/files/changepass.php";
    private static String gcm_testingURL = "http://ec2-52-10-172-112.us-west-2.compute.amazonaws.com";
    private static String save_token_to_server_URL = "http://froogal.in/files/save_token_to_server.php";
    private static String save_location_to_server_URL = "http://froogal.in/files/save_location_to_server.php";
    private static String save_google_user_data_to_server_URL = "http://froogal.in/files/save_google_user_data_to_server.php";
    private static String save_facebook_user_data_to_server_URL = "http://froogal.in/files/save_facebook_user_data_to_server.php";


    private static String login_tag = "login";
    private static String register_tag = "register";
    private static String forpass_tag = "forpass";
    private static String chgpass_tag = "chgpass";


    // constructor
    public UserFunctions(){
        jsonParser = new JSONParser();
    }

    /**
     * Function to store facebook user data to server
     */

    public JSONObject save_facebook_user_data_to_server(String id,String gcm_token,String first_name,String last_name,String image_url,String email,String ip_address,String imei,String registered_through,String latitude, String longitude,String registered_at,String birthday){
        // Building Parameters
        Log.d(TAG, "save_facebook_user_data_to_server");
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("first_name", first_name));
        params.add(new BasicNameValuePair("last_name", last_name));
        params.add(new BasicNameValuePair("email", email));
        params.add(new BasicNameValuePair("ip_address", ip_address));
        params.add(new BasicNameValuePair("imei", imei));
        params.add(new BasicNameValuePair("birthday", birthday));
        params.add(new BasicNameValuePair("longitude", longitude));
        params.add(new BasicNameValuePair("latitude", latitude));
        params.add(new BasicNameValuePair("registered_through", registered_through));
        params.add(new BasicNameValuePair("registered_at", registered_at));
        params.add(new BasicNameValuePair("image_url", image_url));
        params.add(new BasicNameValuePair("gcm_token", gcm_token));
        params.add(new BasicNameValuePair("facebook_id", id));
        Log.d(TAG, "Params : " + params.toString());
        JSONObject json = jsonParser.makeHttpRequest(save_facebook_user_data_to_server_URL,"POST", params);
        Log.d(TAG,"Json Response : " + json);
        return json;
    }

    /**
     * Function to store google+ user data to server
     */

    public JSONObject save_google_user_data_to_server(String gcm_token,String first_name,String last_name,String image_url,String email,String ip_address,String imei,String registered_through,String latitude, String longitude,String registered_at,String birthday){
        // Building Parameters
        Log.d(TAG, "save_google_user_data_to_server");
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("first_name", first_name));
        params.add(new BasicNameValuePair("last_name", last_name));
        params.add(new BasicNameValuePair("email", email));
        params.add(new BasicNameValuePair("ip_address", ip_address));
        params.add(new BasicNameValuePair("imei", imei));
        params.add(new BasicNameValuePair("birthday", birthday));
        params.add(new BasicNameValuePair("longitude", longitude));
        params.add(new BasicNameValuePair("latitude", latitude));
        params.add(new BasicNameValuePair("registered_through", registered_through));
        params.add(new BasicNameValuePair("registered_at", registered_at));
        params.add(new BasicNameValuePair("image_url", image_url));
        params.add(new BasicNameValuePair("gcm_token", gcm_token));
        Log.d(TAG, "Params : " + params.toString());
        JSONObject json = jsonParser.makeHttpRequest(save_google_user_data_to_server_URL,"POST", params);
        Log.d(TAG,"Json Response : " + json);
        return json;
    }


    /**
     * Function to test gcm
     */

    public JSONObject gcmtest(String alpha){
        // Building Parameters
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("alpha", alpha));
        JSONObject json = jsonParser.makeHttpRequest(gcm_testingURL,"POST", params);
        return json;
    }

    /**
     * Function to Login
     **/

    // TODO add gcm_token into server after login

    public JSONObject loginUser(String email, String password,String gcm_token){
        // Building Parameters
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("tag", login_tag));
        params.add(new BasicNameValuePair("email", email));
        params.add(new BasicNameValuePair("password", password));
        params.add(new BasicNameValuePair("gcm_token", gcm_token));
        JSONObject json = jsonParser.makeHttpRequest(loginURL,"POST", params);
        Log.d("infunction", json.toString());
        return json;
    }

    /**
     * Function to change password
     **/

    public JSONObject chgPass(String newpas, String email){
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("tag", chgpass_tag));

        params.add(new BasicNameValuePair("newpas", newpas));
        params.add(new BasicNameValuePair("email", email));
        JSONObject json = jsonParser.makeHttpRequest(chgpassURL, "POST", params);
        Log.d("inchgpassfunction", json.toString());
        return json;
    }





    /**
     * Function to reset the password
     **/

    public JSONObject forPass(String forgotpassword){
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("tag", forpass_tag));
        params.add(new BasicNameValuePair("forgotpassword", forgotpassword));
        JSONObject json = jsonParser.makeHttpRequest(forpassURL, "POST", params);
        Log.d("inforpassfunction", json.toString());
        return json;
    }






     /**
      * Function to  Register
      **/
    public JSONObject registerUser(String fname, String lname, String email, String mobile, String password){
        // Building Parameters
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("tag", register_tag));
        params.add(new BasicNameValuePair("fname", fname));
        params.add(new BasicNameValuePair("lname", lname));
        params.add(new BasicNameValuePair("email", email));
        params.add(new BasicNameValuePair("mobile", mobile));
        params.add(new BasicNameValuePair("password", password));
        JSONObject json = jsonParser.makeHttpRequest(registerURL,"POST", params);
        Log.d("infunctionreg", json.toString());
        return json;
    }

    public JSONObject getMenu(String s) {
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("tag", register_tag));
        params.add(new BasicNameValuePair("resid", s));
        JSONObject json = jsonParser.makeHttpRequest("http://froogal.in/files/getmenu.php","GET", params);
        Log.d("infunctionreg", json.toString());
        return json;

    }



}

