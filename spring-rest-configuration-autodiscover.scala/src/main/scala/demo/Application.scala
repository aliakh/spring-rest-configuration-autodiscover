package demo

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class SpringMainApplication {
}

object SpringMainApplication extends App {
  SpringApplication.run(classOf[SpringMainApplication], args: _*)
}