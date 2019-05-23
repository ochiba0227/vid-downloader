package com.example.vid_downloader.mq

import org.springframework.amqp.core.Queue
import org.springframework.stereotype.Component
import org.springframework.amqp.rabbit.core.RabbitTemplate

@Component
class Sender(
    val template: RabbitTemplate,
    val queue: Queue
){
    fun command(name: String){
        template.convertAndSend(queue.name, name)
        println(" [x] Sent '$name'")
    }
}