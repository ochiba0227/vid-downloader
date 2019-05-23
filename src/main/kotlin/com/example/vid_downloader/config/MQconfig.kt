package com.example.vid_downloader.config

import com.example.vid_downloader.mq.Sender
import org.springframework.amqp.core.Queue
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.springframework.scheduling.annotation.EnableScheduling

@Configuration
@EnableScheduling
class MQconfig {

    @Bean
    fun getHelloQueue() = Queue("hello")

    @Profile("sender")
    @Bean
    fun sender(template: RabbitTemplate, queue: Queue) = Sender(template, queue)
}