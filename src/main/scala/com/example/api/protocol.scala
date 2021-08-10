package com.example.api

import com.example.api.healthcheck.DbStatus
import com.example.domain.{ Item, ItemId }
import de.heikoseeberger.akkahttpplayjson.PlayJsonSupport
import play.api.libs.json.Json

final case class CreateItemRequest(name: String, price: BigDecimal)
final case class UpdateItemRequest(name: String, price: BigDecimal)
final case class PartialUpdateItemRequest(name: Option[String], price: Option[BigDecimal])

trait JsonSupport extends PlayJsonSupport {
  implicit val itemIdFormat                   = Json.valueFormat[ItemId]
  implicit val itemFormat                     = Json.format[Item]
  implicit val dbStatusFormat                 = Json.format[DbStatus]
  implicit val createItemRequestFormat        = Json.format[CreateItemRequest]
  implicit val updateItemRequestFormat        = Json.format[UpdateItemRequest]
  implicit val partialUpdateItemRequestFormat = Json.format[PartialUpdateItemRequest]
}

object JsonSupport extends JsonSupport
