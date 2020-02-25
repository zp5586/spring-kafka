package com.gblfy.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gblfy.entity.Trace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("kafka")
public class KafkaController {

    @Autowired
    KafkaTemplate kafkaTemplate;
    //引入json工具类
    private static final ObjectMapper MAPPER = new ObjectMapper();
    /**
     * 消息发送
     */
    @RequestMapping("producer")
    public String producer()throws Exception{
//        kafkaTemplate.send("testTopic","producer发送消息");
        Trace trace = new Trace().builder()
                .id(1l)
                .name("yx").build();
//把对象转换成 jsonStr 类型便与解析
        String jsonStrObj = MAPPER.writeValueAsString(trace);
        kafkaTemplate.send("testTopic",jsonStrObj);
        return "success";
    }

}
