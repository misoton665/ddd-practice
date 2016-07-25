package com.example.model

trait Identifier[+A] extends Serializable {
  def value: A
}
