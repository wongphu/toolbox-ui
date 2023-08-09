package toolbox

import com.raquo.laminar.api.L.*
import org.scalajs.dom

import scala.scalajs.js.annotation.{JSExport, JSExportTopLevel}

@JSExportTopLevel("Main")
object Main {

  @JSExport
  def main(): Unit = {
    val hash = new HashTool()
    val joke = new JokeTool()
    val uuid = new UuidTool()
    val observer = Observer[(String, Boolean)] {
      case ("hash", checked) =>
        if (checked) {
          render(dom.document.getElementById("content"), hash.element)
        } else {
          dom.document.getElementById("content").removeChild(hash.element.ref)
        }
      case ("joke", checked) =>
        if (checked) {
          render(dom.document.getElementById("content"), joke.element)
        } else {
          dom.document.getElementById("content").removeChild(joke.element.ref)
        }
      case ("uuid", checked) =>
        if (checked) {
          render(dom.document.getElementById("content"), uuid.element)
        } else {
          dom.document.getElementById("content").removeChild(uuid.element.ref)
        }
      case _ =>
    }
    val sidebar = div(
      idAttr("sidebar"),
      cls("sidebar"),
      div(
          input(idAttr("hash-input"), typ("checkbox"), onChange.mapToChecked.map(v => ("hash", v)) --> observer),
          label("hash", forId("joke-input"))
      ),
      div(
          input(idAttr("joke-input"), typ("checkbox"), onChange.mapToChecked.map(v => ("joke", v)) --> observer),
          label("joke", forId("joke-input"))
      ),
      div(
          input(idAttr("uuid-input"), typ("checkbox"), onChange.mapToChecked.map(v => ("uuid", v)) --> observer),
          label("uuid", forId("uuid-input"))
      ),
    )
    val app = div(
      cls("container"),
      div(
        cls("header"),
        div(cls("logo"), "toolbox"),
      ),
      sidebar,
      div(idAttr("content"), cls("content"))
    )
    render(dom.document.getElementById("root"), app)
  }
}
