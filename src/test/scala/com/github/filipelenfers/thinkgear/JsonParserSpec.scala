import org.scalatest.WordSpec
import org.scalatest.Matchers
import com.github.filipelenfers.thinkgear._

class ParserSpec extends WordSpec with Matchers {

  "A json string" when {

    """{"poorSignalLevel":199}""" should {
      val json = """{"poorSignalLevel":199}"""
      "be parsed in PoorSignalLevel(199)" in {
        JsonParser.parse(json) shouldBe ThinkgearResponse(poorSignalLevel=Some(199))
      }
    }

    """{"blinkStrength":41}""" should {
      val json = """{"blinkStrength":41}"""
      "be parsed in Blink(41)" in {
        JsonParser.parse(json) shouldBe ThinkgearResponse(blinkStrength=Some(41))
     }
    }

    """{"rawEeg":-123}""" should {
      val json = """{"rawEeg":-123}"""
      "be parsed in RawData(-123)" in {
        JsonParser.parse(json) shouldBe ThinkgearResponse(rawEeg=Some(-123)) 
      }
    }

    """{"eSense":{"attention":75,"meditation":38},"eegPower":{"delta":247328,"theta":98222,"lowAlpha":27763,"highAlpha":6216,"lowBeta":9065,"highBeta":12236,"lowGamma":7982,"highGamma":5343},"poorSignalLevel":0}""" should {
      val json = """{"eSense":{"attention":75,"meditation":38},"eegPower":{"delta":247328,"theta":98222,"lowAlpha":27763,"highAlpha":6216,"lowBeta":9065,"highBeta":12236,"lowGamma":7982,"highGamma":5343},"poorSignalLevel":0}"""
      "be parsed in " in {
        JsonParser.parse(json) shouldBe ThinkgearResponse(
          Some(ESense(Some(75),Some(38))),
          Some(EEGPower(Some(247328),Some(98222),Some(27763),Some(6216),Some(9065),Some(12236),Some(7982),Some(5343))),
          Some(0),
          None
        )
      }
    }

    """{"eSense":{"attention":90,"meditation":47},"eegPower":{"delta":5614,"theta":7445,"lowAlpha":1165,"highAlpha":2645,"lowBeta":4108,"highBeta":15870,"lowGamma":4043,"highGamma":3281},"poorSignalLevel":0}""" should {
      val json = """{"eSense":{"attention":90,"meditation":47},"eegPower":{"delta":5614,"theta":7445,"lowAlpha":1165,"highAlpha":2645,"lowBeta":4108,"highBeta":15870,"lowGamma":4043,"highGamma":3281},"poorSignalLevel":5}"""
      "be parsed in " in {
        JsonParser.parse(json) shouldBe ThinkgearResponse(
          Some(ESense(Some(90),Some(47))),
          Some(EEGPower(Some(5614),Some(7445),Some(1165),Some(2645),Some(4108),Some(15870),Some(4043),Some(3281))),
          Some(5),
          None
        )
      }
    }

  }

}