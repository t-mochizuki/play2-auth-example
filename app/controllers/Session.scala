package controllers

import jp.t2v.lab.play2.auth.LoginLogout
import models.account.Account
import play.api.data.Form
import play.api.data.Forms._
import play.api.mvc.{Action, Controller}
import views.html

import scala.concurrent.Future
import play.api.libs.concurrent.Execution.Implicits.defaultContext

object Session extends Controller with LoginLogout with AuthConfigImpl {
  val loginForm = Form {
    mapping("email" -> email, "password" -> text)(Account.authenticate)(_.map(u => (u.email, "")))
      .verifying("Invalid email or password", result => result.isDefined)
  }

  def login = Action { implicit request =>
      Ok(html.login(loginForm))
  }

  def logout = Action.async { implicit request =>
    // do something...
    gotoLogoutSucceeded.map(_.flashing(
      "success" -> "You've been logged out"
    ))
  }

  def authenticate = Action.async { implicit request =>
    loginForm.bindFromRequest.fold(
      formWithErrors => Future.successful(BadRequest(html.login(formWithErrors))),
      user => gotoLoginSucceeded(user.get.id)
    )
  }
}
