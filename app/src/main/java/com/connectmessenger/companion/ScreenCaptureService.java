package com.connectmessenger.companion;
import android.app.*; import android.content.*; import android.media.projection.*; import android.os.*;
/** Keeps only a user-approved projection alive; no stream is transmitted in this starter. */
public class ScreenCaptureService extends Service {
 public static final String CODE="code", DATA="data"; private MediaProjection projection;
 @Override public void onCreate(){super.onCreate();if(Build.VERSION.SDK_INT>=26)getSystemService(NotificationManager.class).createNotificationChannel(new NotificationChannel("share","Screen sharing",NotificationManager.IMPORTANCE_LOW));}
 @Override public int onStartCommand(Intent i,int f,int id){if(i==null){stopSelf();return START_NOT_STICKY;} Notification.Builder b=Build.VERSION.SDK_INT>=26?new Notification.Builder(this,"share"):new Notification.Builder(this);b.setSmallIcon(android.R.drawable.ic_menu_view).setContentTitle("Screen sharing active").setContentText("Stop sharing in Connect Messenger").setOngoing(true);startForeground(7,b.build());Intent data=i.getParcelableExtra(DATA);int code=i.getIntExtra(CODE,Activity.RESULT_CANCELED);if(code==Activity.RESULT_OK&&data!=null){MediaProjectionManager m=(MediaProjectionManager)getSystemService(MEDIA_PROJECTION_SERVICE);projection=m.getMediaProjection(code,data);if(projection!=null)projection.registerCallback(new MediaProjection.Callback(){public void onStop(){stopSelf();}},new Handler(Looper.getMainLooper()));}else stopSelf();return START_NOT_STICKY;}
 @Override public void onDestroy(){if(projection!=null)projection.stop();super.onDestroy();}@Override public IBinder onBind(Intent i){return null;}
}
