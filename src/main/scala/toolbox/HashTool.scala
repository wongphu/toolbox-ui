package toolbox

import com.raquo.laminar.api.L._
import org.scalajs.dom
import com.dedipresta.crypto.hash.sha256.Sha256

class HashTool() {
  private val firstNameVar = Var("")
  private val lastNameVar = Var("")
  private val dateOfBirthVar = Var("")
  private val hashVar = Var("")
  private val observer = Observer[Int](_ => computeHash())

  lazy val element: HtmlElement = div(
    idAttr("hash"),
    cls("block"),
    h1("Sha256 Hash"),
    input(
      onMountFocus,
      placeholder := "first name",
      idAttr("firstName"),
      className("form-control"),
      inContext { thisNode =>
        onInput.map(_ => thisNode.ref.value) --> firstNameVar
      }
    ),
    input(
      placeholder := "last name",
      idAttr("lastName"),
      className("form-control"),
      inContext { thisNode =>
        onInput.map(_ => thisNode.ref.value) --> lastNameVar
      }
    ),
    input(
      placeholder := "yyyy-mm-dd",
      idAttr("dateOfBirth"),
      className("form-control"),
      inContext { thisNode =>
        onInput.map(_ => thisNode.ref.value) --> dateOfBirthVar
      }
    ),
    br(),
    child.text <-- hashVar,
    br(),
    button(
      "compute",
      cls("button"),
      onClick.mapTo(0) --> observer
    )
  )

  def computeHash(): Unit = {
    val text = Seq(
      firstNameVar.now().trim.toLowerCase,
      lastNameVar.now().trim.toLowerCase,
      dateOfBirthVar.now().trim
    ).mkString("-")
    val hash = Sha256.hashString(text)

    hashVar.set(hash)
  }
}
