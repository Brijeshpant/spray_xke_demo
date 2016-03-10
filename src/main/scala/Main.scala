import akka.actor.{Actor, Props, ActorSystem}
import akka.io.IO
import akka.io.Tcp.Register
import com.brij.route.{XkeRoutes, MyTestRoutes}
import spray.can.Http
import spray.http._
import spray.routing.{Route, HttpServiceActor}

// type Route = RequestContext=> Unit

object Main extends App {
  val system = ActorSystem()

//  val listener = system.actorOf(Props[ActorListener])

  val listener = system.actorOf(Props[RoutingService])
  IO(Http)(system) ! Http.Bind(listener, "localhost", port = 8080)
}

class RoutingService extends HttpServiceActor with MyTestRoutes  with XkeRoutes {

  override def receive: Actor.Receive = runRoute(testRoutes~xkeRoute)

}

class ActorListener extends Actor {
  override def receive: Receive = {
    case request@HttpRequest(HttpMethods.POST,Uri.Path("/hello"),_,_,_) => sender ! HttpResponse(entity = HttpEntity(s"tshis is fantastic $request"))
    case _: HttpRequest => sender ! HttpResponse(entity = HttpEntity("this is fantastic"))
    case _: Http.Connected => sender ! Register(self)
  }
}

