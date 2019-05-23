package com.example.vid_downloader.mq

import com.example.vid_downloader.service.CommandExec
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component


@Component
class Receiver {
    @RabbitListener(queues = ["hello"])
    fun processMessage(url: String) {
        CommandExec().exec(makeCommand(url))
    }
    fun makeCommand(url: String) :String{
        return "youtube-dl $url"
    }
}