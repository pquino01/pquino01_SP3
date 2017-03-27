package command

class LoggingJob extends Job {

  var logging: Logging =null

  def setLogging(logging: Logging): Unit = this.logging=logging

  override def run(): Unit = logging.log
}