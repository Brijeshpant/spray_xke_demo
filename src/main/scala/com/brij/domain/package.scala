import com.brij.domain.User
import com.brij.domain.xke.XKEs

/**
  * Created by bpant on 2/29/16.
  */
package object domain {
  type ProductType = String
  type UserId = Int
  type XkeType = String
  type userSXkes = List[(User,XKEs)]
}
