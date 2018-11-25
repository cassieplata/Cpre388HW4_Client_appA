package edu.iastate.cplata.client_applicationa;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.support.annotation.Nullable;
import android.widget.Toast;

public class MessengerService extends Service {
    private final Messenger mMessenger = new Messenger(new IncomingHandler());


    public MessengerService(){

    }

    @Override
    public IBinder onBind(Intent intent) {
        return mMessenger.getBinder();
    }

    private class IncomingHandler extends Handler{
        @Override
        public void handleMessage(Message msg){

        }
    }


}
