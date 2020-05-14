package com.example.glide;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
/*
import com.google.cloud.pubsub.v1.AckReplyConsumer;
import com.google.cloud.pubsub.v1.MessageReceiver;
import com.google.cloud.pubsub.v1.Subscriber;
import com.google.cloud.pubsub.v1.TopicAdminClient;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.pubsub.v1.ProjectSubscriptionName;
import com.google.pubsub.v1.ProjectTopicName;
import com.google.pubsub.v1.PubsubMessage;

import java.io.IOException;

 */

public class PubActiviy extends AppCompatActivity {
    private static final String PROJECT_ID = "fir-demo-b26a3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pub_activiy);
/*
        ProjectSubscriptionName subscription = ProjectSubscriptionName.of(PROJECT_ID,"mysubscription");

        MessageReceiver receiver =
                new MessageReceiver() {
                    @Override
                    public void receiveMessage(PubsubMessage message, AckReplyConsumer consumer) {
             //         Log.i( "receiveMessage: ","got message: " + message.getData().toStringUtf8());
                        consumer.ack();
                    }
                };

        Subscriber subscriber = null;
        try {
            subscriber = Subscriber.newBuilder(subscription, receiver).build();
            subscriber.addListener(
                    new Subscriber.Listener() {
                        @Override
                        public void failed(Subscriber.State from, Throwable failure) {
                            // Handle failure. This is called when the Subscriber encountered a fatal error and is shutting down.
                            System.err.println(failure);
                        }
                    },
                    MoreExecutors.directExecutor());
          //  subscriber.startAsync().awaitRunning();
            //...
        } finally {
            if (subscriber != null) {
                subscriber.stopAsync();
            }

        }

 */



     /*   String subscriptionId = "mysubscription";
        ProjectSubscriptionName subscriptionName =
                ProjectSubscriptionName.of(PROJECT_ID, subscriptionId);
        Subscriber subscriber = null;
        try {
            // create a subscriber bound to the asynchronous message receiver
            subscriber = Subscriber.newBuilder(subscriptionName, new MessageReceiverExample()).build();
            subscriber.startAsync().awaitRunning();
            // Allow the subscriber to run indefinitely unless an unrecoverable error occurs.
            subscriber.awaitTerminated();
        } catch (IllegalStateException e) {
            System.out.println("Subscriber unexpectedly stopped: " + e);
        }

      */
    }

    /*
    static class MessageReceiverExample implements MessageReceiver {
        @Override
        public void receiveMessage(PubsubMessage message, AckReplyConsumer consumer) {
          //        Log.i("receiveMessage: ",
            //              "Message Id: " + message.getMessageId() + " Data: " + message.getData().toStringUtf8());
            // Ack only after all work for the message is complete.
          consumer.ack();
        }
    }

     */


}
