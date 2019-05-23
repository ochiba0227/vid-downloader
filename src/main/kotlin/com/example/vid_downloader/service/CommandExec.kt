package com.example.vid_downloader.service

import org.springframework.stereotype.Service
import java.io.File
import java.lang.ProcessBuilder.Redirect.*
import java.util.concurrent.TimeUnit

@Service
class CommandExec {
    fun exec(command: String) {
        println(command)
        command.runCommand(File("/tmp"))
    }

    fun String.runCommand(workingDir: File) {
        ProcessBuilder(*split(" ").toTypedArray())
                .directory(workingDir)
                .redirectOutput(INHERIT)
                .redirectError(INHERIT)
                .start()
                .waitFor(60, TimeUnit.MINUTES)
    }
}