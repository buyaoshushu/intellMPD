import org.bff.javampd.server.MPD
import org.junit.Test

class Test{

    @Test
   fun test(){
        val mpd = MPD.builder()
                .server("0.0.0.0")
                .port(6600).password(null)
                .build()
        mpd.player.play()

    }
}