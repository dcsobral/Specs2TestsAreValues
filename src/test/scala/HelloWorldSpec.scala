import org.specs2._
import scala.concurrent.duration._

class HelloWorldSpec extends Specification with specification.AllExpectations {

  def spec = s2"""

 This is a specification to check the 'Hello world' string

 The 'Hello world' string should
   contain 11 characters                                         $e1
   start with 'Hello'                                            $e2
   end with 'world'                                              $e3
                                                                 """

  def e1 = { Thread.sleep(300); "Hello world" must have size(11) }
  def e2 = "Hello world" must startWith("Hello")
  def e3 = { Thread.sleep(600); "Hello world" must endWith("world") }

  def timedOutSpec = spec.map(f => if (f.isExecutable) f.setTimeout(500.millis) else f)

  def is = spec.append(timedOutSpec)
}
