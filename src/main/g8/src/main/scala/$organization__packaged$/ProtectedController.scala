package $organization$.$name;format="lower,word"$

import org.scalatra._
import scalate.ScalateSupport
import $organization$.$name;format="lower,word"$.auth.AuthenticationSupport

class ProtectedController extends $classname$ with AuthenticationSupport {

  /**
   * Require that users be logged in before they can hit any of the routes in this controller.
   */
  before() {
    requireLogin()
  }

  get("/") {
    "This is a protected controller action. If you can see it, you're logged in."
  }
}
