package com.github.filipelenfers.thinkgear

case class ThinkgearResponse(
  eSense: Option[ESense] = None,
  eegPower: Option[EEGPower] = None,
  poorSignalLevel: Option[Int] = None,
  blinkStrength: Option[Int] = None,
  rawEeg: Option[Int] = None
)

case class ESense(attention: Option[Int], meditation: Option[Int])

case class EEGPower(
  delta: Option[Int],
  theta: Option[Int],
  lowAlpha: Option[Int], highAlpha: Option[Int],
  lowBeta: Option[Int], highBeta: Option[Int],
  lowGamma: Option[Int], highGamma: Option[Int]
)

case class PoorSignalLevel(level: Int) 

object ThinkgearResponse {
  def empty = ThinkgearResponse(None,None,None,None,None)
  
}