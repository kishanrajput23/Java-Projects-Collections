package com.prabhu.womensafetyapp;




import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.telephony.SmsManager;
import android.util.Log;
import android.widget.Toast;

@SuppressLint("HandlerLeak")


public class BgService extends Service implements AccelerometerListener{
	
    String str_address;


    private Looper mServiceLooper;
    private ServiceHandler mServiceHandler;
	  
    // Handler that receives messages from the thread.
    private final class ServiceHandler extends Handler {
    	
        public ServiceHandler(Looper looper) {
        	
        	super(looper);
        }
	    @Override
	    public void handleMessage(Message msg) {

	    	// REPLACE THIS CODE WITH YOUR APP CODE
            // Wait before Toasting Service Message  
	    	// to give the Service Started message time to display.	    	
    	   
	        // Toast Service Message.
	/*  		Context context = getApplicationContext();
			CharSequence text = "Service Message";
			int duration = Toast.LENGTH_LONG;
			Toast toast = Toast.makeText(context, text, duration);
			toast.show();
	*/
			      
	        // Service can stop itself using the stopSelf() method.
			// Not using in this app.  Example statement shown below.
	        //stopSelf(msg.arg1);
	    }
    }
    
    
	@Override
	public IBinder onBind(Intent arg0) {
		
		return null;
    }
	
	
	
	@Override
	public void onCreate() {
		super.onCreate();
        
		
		 if (AccelerometerManager.isSupported(this)) {
             
             AccelerometerManager.startListening(this);
         }
	    HandlerThread thread = new HandlerThread("ServiceStartArguments",android.os.Process.THREAD_PRIORITY_BACKGROUND);
	    thread.start();
	    
	    mServiceLooper = thread.getLooper();
	    
	    mServiceHandler = new ServiceHandler(mServiceLooper);		
	}
	
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		
		// Get message from message pool using handler.
	    Message msg = mServiceHandler.obtainMessage();
	    
	    // Set start ID (unique to the specific start) in message.
	    msg.arg1 = startId;
	    
	    // Send message to start job.
	    mServiceHandler.sendMessage(msg);		
		
	    // Toast Service Started message.
	//	Context context = getApplicationContext();
		
		
		
		
	/*	CharSequence text = "Service Started";
		int duration = Toast.LENGTH_SHORT;
		Toast toast = Toast.makeText(context, text, duration);
		toast.show();	
    */

		// Start a sticky.
		return START_STICKY;
	}	
	
	
	
	public class GeocoderHandler extends Handler {
        @Override
        public void handleMessage(Message message) {
        	
        	Toast.makeText(getApplicationContext(), "geocoderhandler started", Toast.LENGTH_SHORT).show();

    		   
            switch (message.what) {
                case 1:
                    Bundle bundle = message.getData();
                    str_address = bundle.getString("address");
                   // TelephonyManager tmgr=(TelephonyManager)BgService.this.getSystemService(Context.TELEPHONY_SERVICE);
                  //  String ph_number=tmgr.getLine1Number();
                	SQLiteDatabase db;
            		db=openOrCreateDatabase("NumDB", Context.MODE_PRIVATE, null);
            		Cursor c=db.rawQuery("SELECT * FROM details", null);
            		Cursor c1=db.rawQuery("SELECT * FROM SOURCE", null); 
                
                    String source_ph_number=c1.getString(0);
                      while(c.moveToNext())
         		   {
         		      String target_ph_number=c.getString(1);
         		    
            //         SmsManager smsManager=SmsManager.getDefault();
            //         smsManager.sendTextMessage("+918121668944", "+918121668944", "Please help me. I need help immediately. This is where i am now:"+str_address, null, null);
                     
                 	Toast.makeText(getApplicationContext(), "Source:"+source_ph_number+"Target:"+target_ph_number, Toast.LENGTH_SHORT).show();

         		   } 
                      db.close();
                
                    break;
                default:
                	str_address = null;
            }
        	Toast.makeText(getApplicationContext(), str_address, Toast.LENGTH_SHORT).show();
        	
        }
    }
	
   

	@Override
	public void onAccelerationChanged(float x, float y, float z) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onShake(float force) {
		
		GPSTracker gps;
		gps = new GPSTracker(BgService.this);
        if(gps.canGetLocation()){
        	
        	double latitude = gps.getLatitude();
        	double longitude = gps.getLongitude();
        	
        	RGeocoder RGeocoder = new RGeocoder();
        	RGeocoder.getAddressFromLocation(latitude, longitude,getApplicationContext(), new GeocoderHandler());
        	Toast.makeText(getApplicationContext(), "onShake", Toast.LENGTH_SHORT).show();

        }
        else{
        	gps.showSettingsAlert();
		}   
		
	}
	
	
	
	
	
	// onDestroy method.   Display toast that service has stopped.
	@Override
	public void onDestroy() {
		super.onDestroy();
		
		// Toast Service Stopped.
		Context context = getApplicationContext();
		
		   Log.i("Sensor", "Service  distroy");
	         
	        if (AccelerometerManager.isListening()) {
	             
	            AccelerometerManager.stopListening();
	             
	        }
		
		CharSequence text = "Women Safety App Service Stopped";
		int duration = Toast.LENGTH_SHORT;
		Toast toast = Toast.makeText(context, text, duration);
		toast.show();
		
		
	}
	
	
	
}