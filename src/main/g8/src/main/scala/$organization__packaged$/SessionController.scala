package $organization$.$name;format="lower,word"$


import org.scalatra._

import $organization$.$name;format="lower,word"$.auth.AuthenticationSupport


class SessionsController extends $classname$ with AuthenticationSupport with CsrfTokenSupport {

  before("/new") {
    logger.info("SessionsController: checking whether to run RememberMeStrategy: " + !isAuthenticated)

    if(!isAuthenticated) {
      scentry.authenticate("RememberMe")
    }
  }

  get("/new") {
    if (isAuthenticated) redirect("/")
    logger.info(csrfKey)
    contentType="text/html"
    ssp("/sessions/new", "csrfKey" -> csrfKey, "csrfToken" -> csrfToken)
  }

  post("/") {
    scentry.authenticate()

    if (isAuthenticated) {
      redirect("/")
    }else{
      redirect("/sessions/new")
    }
  }

  // Never do this in a real app. State changes should never happen as a result of a GET request. However, this does
  // make it easier to illustrate the logout code.
  get("/logout") {
    scentry.logout()
    redirect("/")
  }

}
