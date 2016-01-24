package models.account

sealed trait Role
case object Administrator extends Role
case object NormalUser extends Role
