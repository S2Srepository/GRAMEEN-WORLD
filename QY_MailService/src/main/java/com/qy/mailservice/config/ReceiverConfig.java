 package com.qy.mailservice.config;
   
   import java.util.HashMap; import java.util.Map;
   
   import org.apache.kafka.clients.consumer.ConsumerConfig; import
   org.apache.kafka.common.serialization.StringDeserializer; import
   org.springframework.beans.factory.annotation.Value; import
   org.springframework.context.annotation.Bean; import
   org.springframework.context.annotation.Configuration; import
   org.springframework.kafka.annotation.EnableKafka; import
   org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
   import org.springframework.kafka.core.ConsumerFactory; import
   org.springframework.kafka.core.DefaultKafkaConsumerFactory; import
   org.springframework.kafka.support.serializer.JsonDeserializer;
   
   import com.qy.mailservice.model.SendMailRequest; import
   com.qy.mailservice.service.MailReceiver;
   
   
   
   @Configuration
   
   @EnableKafka public class ReceiverConfig {
   
   @Value("${kafka.bootstrap-servers}") private String bootStrapServers;
   
   @Bean public Map<String,Object> consumerConfig(){ Map<String,Object>
   consumerProperties=new HashMap<String,Object>();
   consumerProperties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
   bootStrapServers);
   consumerProperties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
   StringDeserializer.class);
   consumerProperties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
   JsonDeserializer.class); return consumerProperties; }
   
   @Bean public ConsumerFactory<String, SendMailRequest> consumerFactory(){
   return new DefaultKafkaConsumerFactory<>(consumerConfig(),new
   StringDeserializer(),new JsonDeserializer<>(SendMailRequest.class)); }
   
   @Bean public ConcurrentKafkaListenerContainerFactory<String, SendMailRequest>
   kafkaListenerContainerFactory(){
   ConcurrentKafkaListenerContainerFactory<String, SendMailRequest> factory=new
   ConcurrentKafkaListenerContainerFactory<String,SendMailRequest>();
   factory.setConsumerFactory(consumerFactory()); return factory; }
   
   @Bean public MailReceiver receiver(){ return new MailReceiver(); } }
