package toolbox

import org.scalajs.dom.Blob
import scala.scalajs.js
import js.annotation.*

object Native {
  @js.native
  @JSGlobal("helloJS")
  def helloJS(): String = js.native

  @js.native
  @JSGlobal("downloadBlob")
  def downloadBlob(blob: Blob, name: String): Unit = js.native

  @js.native
  @JSGlobal("parseCsv")
  def parseCsv(text: String): js.Array[js.Array[String]] = js.native

  @js.native
  @JSGlobal("makeCsv")
  def makeCsv(rows: js.Array[js.Array[String]]): String = js.native

  @js.native
  @JSGlobal("copyToClipboard")
  def copyToClipboard(id: String): Unit = js.native
}
