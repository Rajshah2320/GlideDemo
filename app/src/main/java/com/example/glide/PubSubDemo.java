package com.example.glide;

public class PubSubDemo  {

}


    /*
    SubscriberStubSettings subscriberStubSettings;

    {
        try {
            subscriberStubSettings = SubscriberStubSettings.newBuilder()
                    .setTransportChannelProvider(
                            SubscriberStubSettings.defaultGrpcTransportProviderBuilder()
                                    .setMaxInboundMessageSize(20 << 20) // 20MB
                                    .build()).build();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

try (
    SubscriberGrpc.SubscriberStub subscriber = GrpcSubscriberStub.create(subscriberStubSettings)) {
        // String projectId = "my-project-id";
        // String subscriptionId = "my-subscription-id";
        // int numOfMessages = 10;   // max number of messages to be pulled
        String subscriptionName = ProjectSubscriptionName.format(projectId, subscriptionId);
        PullRequest pullRequest =
                PullRequest.newBuilder()
                        .setMaxMessages(numOfMessages)
                        .setReturnImmediately(false) // return immediately if messages are not available
                        .setSubscription(subscriptionName)
                        .build();

        // use pullCallable().futureCall to asynchronously perform this operation
        PullResponse pullResponse = subscriber.pullCallable().call(pullRequest);
        List<String> ackIds = new ArrayList<>();
        for (ReceivedMessage message : pullResponse.getReceivedMessagesList()) {
            // handle received message
            // ...
            ackIds.add(message.getAckId());
        }
        // acknowledge received messages
        AcknowledgeRequest acknowledgeRequest =
                AcknowledgeRequest.newBuilder()
                        .setSubscription(subscriptionName)
                        .addAllAckIds(ackIds)
                        .build();
        // use acknowledgeCallable().futureCall to asynchronously perform this operation
        subscriber.acknowledgeCallable().call(acknowledgeRequest);
        return pullResponse.getReceivedMessagesList();
    }

     */


