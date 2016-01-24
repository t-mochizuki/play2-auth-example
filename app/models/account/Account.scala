package models.account

case class Account(id: Int, email: String, password: String, name: String, role: Role)

object Account {

  def authenticate(email: String, password: String): Option[Account] =
    Some(Account(1, "tokyo@gmail.com", "pw", "tokyo", Administrator))

}
