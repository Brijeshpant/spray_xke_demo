package com.brij
package util

import com.brij.domain.User
import com.brij.domain.xke.{XKE, XKEs}
import spray.json.DefaultJsonProtocol

/**
  * Created by bpant on 3/9/16.
  */
trait DomainApiFormatter {

  object ApiFormatProtocol extends DefaultJsonProtocol {
    implicit val userFormat = jsonFormat4(User)
    implicit val xkeFormat = jsonFormat3(XKE)
    implicit val userXkeFormat = jsonFormat1(XKEs)
  }
}
