package com.example.otp_auto_receiverapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.provider.Telephony;
import android.telephony.SmsMessage;
import android.widget.EditText;

import androidx.annotation.RequiresApi;

public class OTPReceiver extends BroadcastReceiver {

    private static EditText editText;

    public void setEditText(EditText editText){
        OTPReceiver.editText = editText;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onReceive(Context context, Intent intent) {
        SmsMessage[] smsMessages = Telephony.Sms.Intents.getMessagesFromIntent(intent);
        for(SmsMessage smsMessage : smsMessages){
            String sms_body = smsMessage.getMessageBody();
            String getotp = sms_body.split(":")[1];
            editText.setText(getotp);
        }
    }
}
