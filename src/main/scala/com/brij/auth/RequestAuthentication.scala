package com.brij.auth

import com.brij.domain._
import spray.routing.authentication.{BasicAuth, UserPass}
import spray.routing.directives.AuthMagnet
import scala.concurrent.{ExecutionContext, Future}

trait RequestAuthentication {
  def basicUserAuthenticator(implicit ec: ExecutionContext): AuthMagnet[AuthInfo] = {
    def validateUser(userPass: Option[UserPass]): Option[AuthInfo] = {
      for {
        p <- userPass
        user <- Some(User("id","brijesh", "1234"))
        if user.passwordMatcher(p.pass)
      } yield new AuthInfo(user)
    }
    def authenticator(userPass: Option[UserPass]): Future[Option[AuthInfo]] = Future {
      validateUser(userPass)
    }

    BasicAuth(authenticator _, realm = "Private API")
  }

}
