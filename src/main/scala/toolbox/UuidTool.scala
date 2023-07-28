package toolbox

import com.raquo.laminar.api.L._
import java.util.UUID

class UuidTool() {
  private val uuidVar = Var("...")
  private val observer = Observer[Int](_ => genUuid())

  lazy val element: HtmlElement = div(
    onMountCallback(ctx => genUuid()),
    idAttr("uuid"),
    cls("block"),
    h1("Generate UUID"),
    child.text <-- uuidVar,
    br(),
    button(
      "more",
      cls("button"),
      onClick.mapTo(0) --> observer
    )
  )

  def genUuid(): Unit = {
    uuidVar.set(UUID.randomUUID().toString);
  }
}
