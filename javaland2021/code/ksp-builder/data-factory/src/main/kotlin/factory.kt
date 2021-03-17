import org.dukecon.domain.model.Conference
import org.dukecon.domain.model.ConferenceBuilder

fun main() {
    val coference = Conference(
        id = "123",
        name = "javaland",
        url = "",
        events = emptyList()
    )
    println(coference.name)

    val conf = ConferenceBuilder()
        .withId("javaland")
        .withName("javaland 2021")
        .withUrl("")
        .withEvents(emptyList())
        .build()
    println(conf.name)
}