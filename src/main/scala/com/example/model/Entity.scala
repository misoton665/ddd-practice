package com.example.model

trait Entity[ID <: Identifier[_]] {
  val identifier: ID

  override final def hashCode(): Int = 31 * identifier.##

  override final def equals(that: Any): Boolean = that match {
    case that: Entity[_] => identifier == that.identifier
    case _               => false
  }
}
