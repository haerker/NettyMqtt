//package view;
//import io.netty.channel.Channel;
//import io.netty.handler.codec.mqtt.*;
//
//public class d {
//
//    // 处理接收到的 publish 消息并将其转发给订阅了相同主题的客户端
//    public void handlePublishMessage(Channel incomingChannel, MqttPublishMessage publishMessage) {
//        String topic = publishMessage.variableHeader().topicName();
//        ByteBuf payload = publishMessage.payload();
//
//        // 获取订阅了相同主题的客户端
//        List<Channel> subscribers = findSubscribers(topic);
//
//        // 构建一个新的 publish 消息
//        MqttPublishMessage newPublishMessage = MqttMessageBuilders.publish()
//                .topicName(topic)
//                .qos(publishMessage.fixedHeader().qosLevel())
//                .payload(payload)
//                .retained(publishMessage.fixedHeader().isRetain())
//                .messageId(generateMessageId()) // 如果需要
//                .build();
//
//        // 发送 publish 消息给所有订阅了相同主题的客户端
//        for (Channel subscriber : subscribers) {
//            subscriber.writeAndFlush(newPublishMessage);
//        }
//    }
//
//    // 查找订阅了指定主题的客户端
//    private List<Channel> findSubscribers(String topic) {
//        List<Channel> subscribers = new ArrayList<>();
//
//        for (Channel client : connectedClients) {
//            // 检查客户端是否订阅了指定主题
//            if (client.hasSubscription(topic)) {
//                subscribers.add(client);
//            }
//        }
//
//        return subscribers;
//    }
//
//}
