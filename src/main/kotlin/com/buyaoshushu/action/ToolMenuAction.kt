package com.buyaoshushu.action

import com.intellij.ide.util.PropertiesComponent
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.ui.Messages
import org.bff.javampd.server.MPD



class ToolMenuAction: AnAction() {
   lateinit var mpd:MPD
    init{
        var propertiesComponent= PropertiesComponent.getInstance()
        val server=propertiesComponent.getValue("intellMPD.server","0.0.0.0")
        val port=propertiesComponent.getInt("intellMPD.port",6600)
        val password=propertiesComponent.getValue("intellMPD.password")
        mpd= MPD.Builder()
                .server(server)
                .port(port).password(password)
                .build()
    }


    override fun actionPerformed(event: AnActionEvent?) {
        if(event!!.presentation.text=="Play")
            mpd.player.play()
        if(event.presentation.text=="Pause")
            mpd.player.pause()
        if(event.presentation.text=="Next")
            mpd.player.playNext()
        if(event.presentation.text=="Previous")
            mpd.player.playPrevious()
        if(event.presentation.text=="Stop")
            mpd.player.stop()
    }
}