package com.example.domain

import zio.{ Has, IO, ZIO }
import zio.stream.{ Stream, ZStream }

trait Subscriber {

  def publishDeleteEvents(deletedItemId: ItemId): IO[Nothing, List[Boolean]]

  def showDeleteEvents: Stream[Nothing, ItemId]

}

object Subscriber {

  def publishDeleteEvents(deletedItemId: ItemId): ZIO[Has[Subscriber], Nothing, List[Boolean]] =
    ZIO.accessM(_.get.publishDeleteEvents(deletedItemId))

  def showDeletedEvents: ZStream[Has[Subscriber], Nothing, ItemId] =
    ZStream.accessStream(_.get.showDeleteEvents)

}