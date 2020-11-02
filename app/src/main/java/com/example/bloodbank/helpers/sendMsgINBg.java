package com.example.bloodbank.helpers;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;

import com.example.bloodbank.chatbot;
import com.example.bloodbank.interfaces.BotReply;
import com.google.cloud.dialogflow.v2.DetectIntentRequest;
import com.google.cloud.dialogflow.v2.DetectIntentResponse;
import com.google.cloud.dialogflow.v2.QueryInput;
import com.google.cloud.dialogflow.v2.SessionName;
import com.google.cloud.dialogflow.v2.SessionsClient;

public class sendMsgINBg extends AsyncTask<Void, Void, DetectIntentResponse> {
    private SessionName session;
    private SessionsClient sessionsClient;
    private QueryInput queryInput;
    private String TAG = "async";
    private BotReply botReply;

    public sendMsgINBg(BotReply botReply, SessionName sessionName, SessionsClient sessionsClient, QueryInput input) {
        this.botReply = botReply;
        this.session = sessionName;
        this.sessionsClient = sessionsClient;
        this.queryInput = input;
    }

    @Override
    protected DetectIntentResponse doInBackground(Void... voids) {
        try {
            DetectIntentRequest detectIntentRequest =
                    DetectIntentRequest.newBuilder()
                            .setSession(session.toString())
                            .setQueryInput(queryInput)
                            .build();
            return sessionsClient.detectIntent(detectIntentRequest);
        } catch (Exception e) {
            Log.d(TAG, "doInBackground: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(DetectIntentResponse response) {
        //handle return response here
        botReply.callback(response);
    }
}
