package runner

import com.sumologic.exceptions.bugsnag.BugsnagMain
import com.sumologic.exceptions.raygun.RaygunMain
import com.sumologic.exceptions.rollbar.RollbarMain
import com.sumologic.exceptions.sentry.SentryMain

object App {
  private val twoMinutes = 120000

  def main(args: Array[String]): Unit = {
    val bugsnagMain = new BugsnagMain
    val raygunMain = new RaygunMain
    val rollbarMain = new RollbarMain
    val sentryMain = new SentryMain

    for(i <- 0 until 20) {
      bugsnagMain.start()
      raygunMain.start()
      rollbarMain.start()
      sentryMain.start()
      Thread.sleep(twoMinutes)
    }
  }
}
