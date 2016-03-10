package com.brij.domain

import auth.{AuthToken, RoleId}
import domain.UserId

/**
  * Created by bpant on 2/26/16.
  */

case class Role(id: RoleId, description: String)
case class Auth(userId: UserId, token: AuthToken)
