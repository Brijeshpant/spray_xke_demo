import com.brij.auth.route.UserRoute
import org.specs2.mutable.Specification
import spray.testkit.Specs2RouteTest
import spray.http.StatusCodes._


class RouteSpecification extends Specification with Specs2RouteTest  with UserRoute {

  def actorRefFactory = system

  "The EndPoint " should {
    "return Pong to a Get request to the ping" in {
      Get("/user/1/brij") ~> userRoute ~> check {
        status === OK
        responseAs[String] === "pong"
      }
    }
  }
}