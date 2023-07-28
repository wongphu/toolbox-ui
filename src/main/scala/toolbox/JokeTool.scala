package toolbox

import com.raquo.laminar.api.L._
import org.scalajs.dom
import org.scalajs.dom.ext.Ajax

import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue
import scala.scalajs.js.JSON

class JokeTool() {
  private val jokeVar = Var("...")
  private val observer = Observer[Int](_ => fetchJoke())
  private val ticks = EventStream.periodic(10000)

  lazy val element: HtmlElement = div(
    onMountCallback(ctx => { ticks.foreach { _ => fetchJoke() } (ctx.owner) }),
    idAttr("joke"),
    cls("block"),
    h1("Joke"),
    child.text <-- jokeVar,
    br(),
    button(
      "more",
      cls("button"),
      onClick.mapTo(0) --> observer
    )
  )

  def fetchJoke(): Unit = {
    println("fetchJoke")
    val headers = Map("Accept" -> "application/json")
    Ajax.get("https://icanhazdadjoke.com", headers = headers).foreach { xhr =>
      val joke = JSON.parse(xhr.responseText).joke.toString
      jokeVar.set(joke)
    }
  }
}
