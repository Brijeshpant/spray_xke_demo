package com.brij.services

import com.brij.domain.User

import scala.collection.mutable.ListBuffer

/**
  * Created by bpant on 3/1/16.
  */
object UserService {
  var users = ListBuffer.empty[User]

  def addUser(user:User) ={
    users += user
  }

  def getUser(id:String):User = {
    val user: User = users.filter(u=>u.id == id).head
    user
  }

  def getUserList() ={
    users
  }

  def getFilteredUsers(name:String,age:Int):List[User] = {
    users.filter(u=>u.userName == name && u.age == age).toList
  }

  def deleteUser(user:User) = {
    users -= user
  }
}
