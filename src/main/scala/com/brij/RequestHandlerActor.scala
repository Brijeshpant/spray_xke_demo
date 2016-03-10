package com.brij

import akka.actor.Actor.Receive
import spray.routing.{Route, HttpServiceActor}

/**
  * Created by bpant on 2/13/16.
  */
class RequestHandlerActor extends HttpServiceActor {
  override def receive: Receive = runRoute(route)

  val route: Route = pathPrefix("ccd") {
    path("name")
    get{
      complete("park centra")
    }~post{
      complete("post completed")
    }
  }

}
