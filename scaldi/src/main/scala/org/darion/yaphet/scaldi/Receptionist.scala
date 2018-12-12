package org.darion.yaphet.scaldi

import akka.actor.Actor
import org.darion.yaphet.scaldi.Messages._
import scaldi.Injector
import scaldi.akka.AkkaInjectable

class Receptionist(implicit inj: Injector) extends Actor with AkkaInjectable {
  val userService = inject[UserService]
  val orderProcessorProps = injectActorProps[Order]
  val priceCalculator = injectActorRef[PriceCalculator]

  def receive = {
    case PlaceOrder(userName, itemId, netAmount) =>
      userService.getUserByUserName(userName)
        .map { user =>
          val processor = context.actorOf(orderProcessorProps)
          processor forward ProcessOrder(user, itemId, netAmount)
          sender ! OrderProcessingStarted(processor)
        }
        .getOrElse {
          sender ! OrderProcessingFailed("Unknown user")
        }
    case msg: CalculatePrice =>
      priceCalculator forward msg
  }
}
