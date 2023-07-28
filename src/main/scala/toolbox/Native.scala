package toolbox

import scala.scalajs.js
import js.annotation._

object Native {
  @js.native
  @JSGlobal("helloJS") // Routing for JS function Wrapper
  def helloJS(): String = js.native
}
