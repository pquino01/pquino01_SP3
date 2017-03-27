package command

class EmailJob extends Job {

  var email:Email =null

  def setEmail(email: Email): Unit = this.email=email

  override def run(): Unit = email.sendEmail()
}