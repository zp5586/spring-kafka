package com.gblfy.kafkaListener;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.gblfy.entity.Trace;
import lombok.extern.log4j.Log4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.listener.MessageListener;

@Log4j
public class KafkaConsumerListener implements MessageListener<String,String> {

    /**
     * 监听类的实现
     */
    public void onMessage(ConsumerRecord<String, String> stringStringConsumerRecord) {
        System.out.println("========消费端收到消息========");
        JSONObject jsonObject = JSON.parseObject(stringStringConsumerRecord.value());
        Trace trace = JSON.toJavaObject(jsonObject, Trace.class);

        log.info("id:" + trace.getId());
        log.info("姓名:" + trace.getName());

        log.info("姓名:" + stringStringConsumerRecord.topic());
        log.info("姓名:" + stringStringConsumerRecord.offset());
        log.info("姓名:" + stringStringConsumerRecord.key());
        log.info("姓名:" + stringStringConsumerRecord.headers());
        log.info("姓名:" + stringStringConsumerRecord.serializedKeySize());
        log.info("姓名:" + stringStringConsumerRecord.serializedValueSize());
        log.info("姓名:" + stringStringConsumerRecord.partition());

        System.out.println(stringStringConsumerRecord.value());
    }

}
